package hu.unideb.inf.snake.snakefx.model.graphics;

import hu.unideb.inf.snake.snakefx.model.audio.Sounds;
import hu.unideb.inf.snake.snakefx.model.dto.snakedto.Snake;
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Zoli
 */
public class Graphics {

    public int score;
    private Sounds sounds;
    private int[][] board;
    private boolean isEaten;

    public Graphics() {
        board = new int[50][44];
        //snake default position
        board[25][22] = 4;
        board[24][22] = 3;
        board[23][22] = 2;
        board[22][22] = 1;

        this.score = 0;
        this.sounds = new Sounds();
        this.isEaten = true;
    }

    private void drawBoard(GraphicsContext gc, Snake snake) {

        if (board[snake.getXPosition()][snake.getYPosition()] > 0 || board[snake.getXPosition()][snake.getYPosition()] == -2) {
            snake.setIsAlive(false);
        } else if (snake.isAlive()) {
            if (board[snake.getXPosition()][snake.getYPosition()] == -1) {
                snake.setSize(snake.getSize() + 1);
                isEaten = true;
                score += 1;
                sounds.playPickUp();
            }

            board[snake.getXPosition()][snake.getYPosition()] = snake.getSize() + 1;
            gc.setStroke(Color.WHITE);
            gc.setLineWidth(2);

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    gc.strokeRect(i * 10, j * 10, 10, 10);
                    //the block after the Snake
                    if (board[i][j] == 1) {
                        gc.setFill(Color.WHITE);
                        gc.fillRect(i * 10, j * 10, 10, 10);
                        board[i][j]--;
                        //if Snake
                    } else if (board[i][j] > 1) {
                        gc.setFill(Color.GOLD);
                        gc.fillRect(i * 10, j * 10, 10, 10);
                        board[i][j]--;
                        //if generateFood
                    } else if (board[i][j] == -1) {
                        gc.setFill(Color.RED);
                        gc.fillRect(i * 10, j * 10, 10, 10);
                        isEaten = false;
                        //if snake isAlive == false
                    } else if (board[i][j] == -2) {
                        gc.setFill(Color.WHITE);
                        gc.fillRect(i * 10, j * 10, 10, 10);
                    }
                }
            }
        }
    }

    private void generateFood() {
        Random random = new Random();
        int x;
        int y;

        do {
            x = random.nextInt(50);
            y = random.nextInt(44);

            if (board[x][y] == 0) {
                board[x][y] = -1;
            }
            //if we generate a food to a food
        } while (board[x][y] != -1);
    }

    public void render(GraphicsContext gc, Snake snake) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, 500, 440);

        if (isEaten) {
            generateFood();
        }
        snake.move();
        drawBoard(gc, snake);
    }

}

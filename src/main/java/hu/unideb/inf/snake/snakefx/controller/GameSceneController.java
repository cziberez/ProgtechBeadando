package hu.unideb.inf.snake.snakefx.controller;

import hu.unideb.inf.snake.snakefx.dao.DomImpl;
import hu.unideb.inf.snake.snakefx.view.Context;
import hu.unideb.inf.snake.snakefx.model.graphics.Graphics;
import hu.unideb.inf.snake.snakefx.model.audio.Sounds;
import hu.unideb.inf.snake.snakefx.view.GameView;
import hu.unideb.inf.snake.snakefx.view.MainSceneView;
import hu.unideb.inf.snake.snakefx.model.dto.snakedto.Snake;
import javafx.scene.input.KeyCode;
import hu.unideb.inf.snake.snakefx.controller.listeners.GameSceneListener;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;

/**
 * FXML Game Scene Controller class.
 *
 * @author Zoli
 */
public class GameSceneController {

    private Snake snake;
    private boolean disableMovement;
    private MainSceneView mainScene;
    private Sounds sounds;

    public GameSceneController(Graphics graphics, GameView gameScene, Context context) {
        snake = new Snake();
        sounds = new Sounds();
        sounds.playGameStart();
        this.disableMovement = false;
        graphics.score = 0; //just in case ;)

        gameScene.setGameSceneListener(new GameSceneListener() {
            @Override
            public void onKeyPressed(KeyCode keyCode) {
                switch (keyCode) {
                    case W:
                        if (snake.getDirection() != Snake.Direction.DOWN && !disableMovement) {
                            snake.setDirection(Snake.Direction.UP);
                            disableMovement = true;
                        }
                        break;
                    case D:
                        if (snake.getDirection() != Snake.Direction.LEFT && !disableMovement) {
                            snake.setDirection(Snake.Direction.RIGHT);
                            disableMovement = true;
                        }
                        break;
                    case S:
                        if (snake.getDirection() != Snake.Direction.UP && !disableMovement) {
                            snake.setDirection(Snake.Direction.DOWN);
                            disableMovement = true;
                        }
                        break;
                    case A:
                        if (snake.getDirection() != Snake.Direction.RIGHT && !disableMovement) {
                            snake.setDirection(Snake.Direction.LEFT);
                            disableMovement = true;
                        }
                        break;
                }
            }

            @Override
            public void onMainMenuPressed() {
                mainScene = new MainSceneView(context);
                context.switchScene(mainScene);
                new MainSceneController(context, mainScene);
            }

            @Override
            public void onSavePressed() {
                DomImpl dom = new DomImpl();
                dom.saveScore(gameScene.inputName.getText(), graphics.score);
                onMainMenuPressed();
            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (snake.isAlive()) {
                        graphics.render(gameScene.getGraphicsContext(), snake);
                        disableMovement = false;
                        gameScene.score.setText("" + graphics.score);
                    } else {
                        cancel();
                        sounds = new Sounds();
                        sounds.playGameOver();
                        gameScene.showInput();
                    }
                });
            }
        }, 0L, 100L);

    }

}

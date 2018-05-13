package hu.unideb.inf.snake.snakefx.model.test;

import hu.unideb.inf.snake.snakefx.model.snake.Snake;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Zoli
 */
public class SnakeTest {

    Snake snake;

    @Before
    public void setUp() {
        /* default size is 4
         * default xPos = 25
         * default yPos = 22
         * default direction is Direction.RIGHT
         */
        snake = new Snake();
    }

    @Test
    public void testIsAlive() {
        snake.setIsAlive(true);
        assertEquals(true, snake.isAlive());
        snake.setIsAlive(false);
        assertEquals(false, snake.isAlive());
    }

    @Test
    public void snakeSizeTest() {
        assertEquals(4, snake.getSize());
        snake.setSize(snake.getSize() + 1);
        assertEquals(5, snake.getSize());
        snake.setSize(snake.getSize() + 1);
        assertEquals(6, snake.getSize());
    }

    @Test
    public void snakeXPositionTest() {
        assertEquals(25, snake.getXPosition());
        snake.setxPosition(snake.getXPosition() + 1);
        assertEquals(26, snake.getXPosition());
        snake.setxPosition(snake.getXPosition() + 1);
        assertEquals(27, snake.getXPosition());
    }

    @Test
    public void snakeYPositionTest() {
        assertEquals(22, snake.getYPosition());
        snake.setyPosition(snake.getYPosition() + 1);
        assertEquals(23, snake.getYPosition());
        snake.setyPosition(snake.getYPosition() + 1);
        assertEquals(24, snake.getYPosition());
    }

    @Test
    public void snakeDirectionTest() {
        assertEquals(snake.getDirection(), Snake.Direction.RIGHT);
        snake.setDirection(Snake.Direction.DOWN);
        assertEquals(snake.getDirection(), Snake.Direction.DOWN);
        snake.setDirection(Snake.Direction.UP);
        assertEquals(snake.getDirection(), Snake.Direction.UP);
        snake.setDirection(Snake.Direction.LEFT);
        assertEquals(snake.getDirection(), Snake.Direction.LEFT);
    }
}

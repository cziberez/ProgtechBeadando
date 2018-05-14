package hu.unideb.inf.snake.snakefx.model.dto.snakedto;

/**
 *
 * @author Zoli
 */
public class Snake {

    public enum Direction {
        UP, DOWN, RIGHT, LEFT
    }

    private boolean isAlive;
    private int xPosition;
    private int yPosition;
    private Direction direction;
    private int size;

    public Snake() {
        this.isAlive = true;
        this.xPosition = 25;
        this.yPosition = 22;
        this.direction = Direction.RIGHT;
        this.size = 4;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public int getYPosition() {
        return yPosition;
    }

    //Only for test cases
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    //Only for test cases
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * move() method changes x and y positions of head according to key pressed.
     */
    public void move() {

        switch (direction) {

            case UP:
                if (yPosition == 0) {
                    isAlive = false;
                } else {
                    yPosition -= 1;
                }
                break;
            case DOWN:
                if (yPosition == 43) {
                    isAlive = false;
                } else {
                    yPosition += 1;
                }
                break;
            case RIGHT:
                if (xPosition == 49) {
                    isAlive = false;
                } else {
                    xPosition += 1;
                }
                break;
            case LEFT:
                if (xPosition == 0) {
                    isAlive = false;
                } else {
                    xPosition -= 1;
                }
                break;
        }

    }
}

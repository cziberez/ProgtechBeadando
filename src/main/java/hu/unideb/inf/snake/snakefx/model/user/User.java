package hu.unideb.inf.snake.snakefx.model.user;

/**
 *
 * @author Zoli
 */
public class User {

    private String name;
    private int score;

    public User() {
        this.name = "";
        this.score = -1;
    }

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", score=" + score + '}';
    }

}

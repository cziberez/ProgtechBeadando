package hu.unideb.inf.snake.snakefx.model.audio;

import java.net.URL;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Zoli
 */
public class Sounds {

    public void playStart() {
        URL start = getClass().getResource("/sounds/start.mp3");
        Media startMedia = new Media(start.toString());
        try {
            MediaPlayer player = new MediaPlayer(startMedia);
            player.setVolume(0.3);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playGameStart() {
        URL gameStart = getClass().getResource("/sounds/gamestart.mp3");
        Media gameStartMedia = new Media(gameStart.toString());
        try {
            MediaPlayer player = new MediaPlayer(gameStartMedia);
            player.setVolume(0.3);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playPickUp() {
        URL pickUp = getClass().getResource("/sounds/pickup.mp3");
        Media pickupMedia = new Media(pickUp.toString());
        try {
            MediaPlayer player = new MediaPlayer(pickupMedia);
            player.setVolume(0.3);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playGameOver() {
        URL gameOver = getClass().getResource("/sounds/gameover.mp3");
        Media gameOverMedia = new Media(gameOver.toString());
        try {
            MediaPlayer player = new MediaPlayer(gameOverMedia);
            player.setVolume(0.3);
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

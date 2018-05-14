package hu.unideb.inf.snake.snakefx.controller.listeners;

import javafx.scene.input.KeyCode;

/**
 *
 * @author Zoli
 */
public interface GameSceneListener {

    void onKeyPressed(KeyCode keyCode);

    void onMainMenuPressed();

    void onSavePressed();
}

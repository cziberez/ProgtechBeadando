package hu.unideb.inf.snake.snakefx.controller;

import hu.unideb.inf.snake.snakefx.controller.listeners.HighScoreSceneListener;
import hu.unideb.inf.snake.snakefx.view.Context;
import hu.unideb.inf.snake.snakefx.view.HighScoreView;
import hu.unideb.inf.snake.snakefx.view.MainSceneView;

/**
 *
 * @author Zoli
 */
public class HighScoreSceneController {

    private MainSceneView mainScene;

    public HighScoreSceneController(Context context, HighScoreView highScoreSceneView) {
        highScoreSceneView.setHighScoreSceneListener(new HighScoreSceneListener() {
            @Override
            public void onMainMenuPressed() {
                
            }
        });
    }
}

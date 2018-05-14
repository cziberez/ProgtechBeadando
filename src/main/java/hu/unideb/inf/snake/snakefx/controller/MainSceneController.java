package hu.unideb.inf.snake.snakefx.controller;

import hu.unideb.inf.snake.snakefx.view.Context;
import hu.unideb.inf.snake.snakefx.model.graphics.Graphics;
import hu.unideb.inf.snake.snakefx.model.audio.Sounds;
import hu.unideb.inf.snake.snakefx.view.HighScoreView;
import hu.unideb.inf.snake.snakefx.view.MainSceneView;
import hu.unideb.inf.snake.snakefx.view.GameView;
import hu.unideb.inf.snake.snakefx.controller.listeners.MainSceneListener;

/**
 *
 * @author Zoli
 */
public class MainSceneController {

    private GameView playScene;
    private HighScoreView highScoreSceneView;
    private Graphics graphics;
    private Sounds sounds;

    public MainSceneController(Context context, MainSceneView mainScene) {

        graphics = new Graphics();
        sounds = new Sounds();
        sounds.playStart();

        mainScene.setMainScreenListener(new MainSceneListener() {
            @Override
            public void onButtonPlay() {
                playScene = new GameView(context);
                context.switchScene(playScene);
                playScene.requestFocus();
                new GameSceneController(graphics, playScene, context);
            }

            @Override
            public void onButtonHighscore() {
                highScoreSceneView = new HighScoreView(context, highScoreSceneView);
                context.switchScene(highScoreSceneView);
                highScoreSceneView.requestFocus();
                new HighScoreView(context, highScoreSceneView);
            }

            @Override
            public void onButtonClose() {
                context.getStage().close();
                System.exit(0);
            }
        });
    }

    // Factory method to create an object.
    public static void initAndStart(Context context, MainSceneView mainScene) {
        new MainSceneController(context, mainScene);
    }
}

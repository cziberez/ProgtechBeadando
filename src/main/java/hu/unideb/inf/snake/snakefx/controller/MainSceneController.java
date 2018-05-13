package hu.unideb.inf.snake.snakefx.controller;

import hu.unideb.inf.snake.snakefx.model.context.Context;
import hu.unideb.inf.snake.snakefx.model.graphics.Graphics;
import hu.unideb.inf.snake.snakefx.model.audio.Sounds;
import hu.unideb.inf.snake.snakefx.view.HighScoreScene;
import hu.unideb.inf.snake.snakefx.view.MainScene;
import hu.unideb.inf.snake.snakefx.view.GameScene;
import hu.unideb.inf.snake.snakefx.model.scenes.listeners.MainSceneListener;

/**
 *
 * @author Zoli
 */
public class MainSceneController {

    private GameScene playScene;
    private HighScoreScene highScoreScene;
    private Graphics graphics;
    private Sounds sounds;

    public MainSceneController(Context context, MainScene mainScene) {

        graphics = new Graphics();
        sounds = new Sounds();
        sounds.playStart();

        mainScene.setMainScreenListener(new MainSceneListener() {
            @Override
            public void onButtonPlay() {
                playScene = new GameScene(context);
                context.switchScene(playScene);
                playScene.requestFocus();
                new GameSceneController(graphics, playScene, context);
            }

            @Override
            public void onButtonHighscore() {
                highScoreScene = new HighScoreScene(context, highScoreScene);
                context.switchScene(highScoreScene);
                highScoreScene.requestFocus();
                new HighScoreScene(context, highScoreScene);
            }

            @Override
            public void onButtonClose() {
                context.getStage().close();
                System.exit(0);
            }
        });
    }

    // Factory method to create an object.
    public static void initAndStart(Context context, MainScene mainScene) {
        new MainSceneController(context, mainScene);
    }
}

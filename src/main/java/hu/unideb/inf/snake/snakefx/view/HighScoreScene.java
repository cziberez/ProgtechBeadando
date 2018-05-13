package hu.unideb.inf.snake.snakefx.view;

import hu.unideb.inf.snake.snakefx.dao.Dom;
import hu.unideb.inf.snake.snakefx.model.context.Context;
import hu.unideb.inf.snake.snakefx.model.scenes.listeners.HighScoreSceneListener;
import hu.unideb.inf.snake.snakefx.model.basicview.BasicView;
import hu.unideb.inf.snake.snakefx.model.user.User;
import java.util.ArrayList;

/**
 *
 * @author Zoli
 */
public class HighScoreScene extends BasicView {

    private MainScene mainScene;
    private HighScoreSceneListener highScoreSceneListener;
    private Dom dom;

    public HighScoreScene(Context context, HighScoreScene highScoreScene) {
        super(context);
        dom = new Dom();
        ArrayList<User> users = dom.getUsers();
    }

    public void setHighScoreSceneListener(HighScoreSceneListener highScoreSceneListener) {
        this.highScoreSceneListener = highScoreSceneListener;
    }

}

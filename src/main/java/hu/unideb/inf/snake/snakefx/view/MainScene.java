package hu.unideb.inf.snake.snakefx.view;

import hu.unideb.inf.snake.snakefx.model.context.Context;
import hu.unideb.inf.snake.snakefx.model.scenes.listeners.MainSceneListener;
import hu.unideb.inf.snake.snakefx.model.basicview.BasicView;
import javafx.geometry.HPos;
import javafx.scene.control.Button;

/**
 *
 * @author Zoli
 */
public class MainScene extends BasicView {

    private MainSceneListener mainScreenListener;

    private Button button;
    private Button button2;
    private Button button3;

    public MainScene(Context context) {
        super(context);
        init();
        add();

    }

    private void init() {
        
        button = new Button("Play");
        button2 = new Button("Highscore");
        button3 = new Button("Exit");

        button.getStyleClass().add("button");
        button.getStyleClass().add("primary");

        button2.getStyleClass().add("button");
        button2.getStyleClass().add("primary");

        button3.getStyleClass().add("button");
        button3.getStyleClass().add("primary");

        grid.setHalignment(button, HPos.CENTER);
        grid.setHalignment(button2, HPos.CENTER);
        grid.setHalignment(button3, HPos.CENTER);

        getContext().getStage().setOnCloseRequest(e -> mainScreenListener.onButtonClose());

        button.setOnAction(e -> mainScreenListener.onButtonPlay());
        button2.setOnAction(e -> mainScreenListener.onButtonHighscore());
        button3.setOnAction(e -> mainScreenListener.onButtonClose());

    }

    private void add() {
        grid.add(button, 3, 2, 3, 1);
        grid.add(button2, 3, 4, 3, 1);
        grid.add(button3, 3, 6, 3, 1);
    }

    public void setMainScreenListener(MainSceneListener listener) {
        this.mainScreenListener = listener;
    }

}

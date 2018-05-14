package hu.unideb.inf.snake.snakefx.view;

import javafx.geometry.HPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.paint.Color;
import hu.unideb.inf.snake.snakefx.controller.listeners.GameSceneListener;
import javafx.scene.control.TextField;

/**
 *
 * @author Zoli
 */
public class GameView extends BasicView {
    
    private Button mainMenuButton;
    private Button submitButton;
    private Label scoreLabel;
    public Label score;
    private final Canvas canvas;
    private final GraphicsContext graphicsContext;
    private GameSceneListener gameSceneListener;
    public TextField inputName;
    
    public GameView(Context context) {
        super(context);
        
        canvas = new Canvas(500, 440);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0, 0, 500, 440);
        
        setCenter(null);
        setTop(grid2);
        setBottom(canvas);
        
        init();
        add();
        
        setFocusTraversable(true);
        setOnKeyPressed(e -> gameSceneListener.onKeyPressed(e.getCode()));
        
        mainMenuButton.setOnAction(e -> gameSceneListener.onMainMenuPressed());
        submitButton.setOnAction(e -> gameSceneListener.onSavePressed());
    }
    
    private void init() {
        scoreLabel = new Label("Score: ");
        score = new Label("0");
        
        mainMenuButton = new Button("Main Menu");
        
        inputName = new TextField();
        inputName.setPromptText("Enter name...");
        submitButton = new Button("Save");
        
        mainMenuButton.getStyleClass().add("button");
        mainMenuButton.getStyleClass().add("primary");
        submitButton.getStyleClass().add("button");
        submitButton.getStyleClass().add("primary");
        score.getStyleClass().add("bold");
        scoreLabel.getStyleClass().add("bold");
        
    }
    
    private void add() {
        grid2.getColumnConstraints().add(new ColumnConstraints(100));
        grid2.getColumnConstraints().add(new ColumnConstraints(100));
        grid2.getColumnConstraints().add(new ColumnConstraints(250));
        grid2.add(scoreLabel, 0, 0);
        grid2.add(score, 1, 0);
        grid2.add(mainMenuButton, 2, 0, 1, 3);
        grid2.setHalignment(mainMenuButton, HPos.RIGHT);
        grid2.add(inputName, 0, 1);
        grid2.add(submitButton, 1, 1);
        hideInput();
    }
    
    public void hideInput() {
        inputName.setVisible(false);
        submitButton.setVisible(false);
    }
    
    public void showInput() {
        inputName.setVisible(true);
        submitButton.setVisible(true);
        inputName.setText("");
    }
    
    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }
    
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }
}

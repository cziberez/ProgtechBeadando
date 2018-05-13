package hu.unideb.inf.snake.snakefx.model.context;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Zoli
 */
public class Context {

    private Scene scene;
    private Stage stage;

    public Context(Stage stage) {
        this.stage = stage;
    }

    public void switchScene(Parent root) {
        scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setResizable(false);
        stage.setTitle("SnakeFX");
        stage.show();
    }

    public Stage getStage() {
        return stage;
    }

}
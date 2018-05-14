package hu.unideb.inf.snake.snakefx;

import hu.unideb.inf.snake.snakefx.controller.MainSceneController;
import hu.unideb.inf.snake.snakefx.view.Context;
import hu.unideb.inf.snake.snakefx.view.MainSceneView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 * The main class.
 *
 * @author Zoli
 */
public class MainApp extends Application {

    /**
     * The entry point method of the Application.
     *
     * @param stage represents the first FXML stage.
     */
    @Override
    public void start(Stage stage) {
        Context context = new Context(stage);
        MainSceneView mainScreen = new MainSceneView(context);
        context.switchScene(mainScreen);
        MainSceneController.initAndStart(context, mainScreen);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

}

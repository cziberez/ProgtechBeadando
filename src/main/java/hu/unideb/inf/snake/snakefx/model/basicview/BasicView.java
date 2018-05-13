package hu.unideb.inf.snake.snakefx.model.basicview;

import hu.unideb.inf.snake.snakefx.model.context.Context;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Zoli
 */
public abstract class BasicView extends BorderPane {

    private final Context context;
    protected GridPane grid;
    protected GridPane grid2;

    public BasicView(Context context) {
        this.context = context;
        URL styleSheetUrl = getClass().getResource("/styles/bootstrap.css");
        getStylesheets().addAll(styleSheetUrl.toString());
        this.grid = new GridPane();
        this.grid2 = new GridPane();
        init();
    }

    public final Context getContext() {
        return context;
    }

    private void init() {
        grid.setPadding(new Insets(20));
        setCenter(grid);

        for (int i = 0; i < 9; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(50));
            grid.getRowConstraints().add(new RowConstraints(50));
        }
        grid2.getRowConstraints().add(new RowConstraints(60));
    }

}

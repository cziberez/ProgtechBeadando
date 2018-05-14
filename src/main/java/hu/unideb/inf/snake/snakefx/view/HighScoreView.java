package hu.unideb.inf.snake.snakefx.view;

import hu.unideb.inf.snake.snakefx.dao.DomImpl;
import hu.unideb.inf.snake.snakefx.controller.listeners.HighScoreSceneListener;
import hu.unideb.inf.snake.snakefx.model.dto.userdto.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Zoli
 */
public class HighScoreView extends BasicView {
    
    private MainSceneView mainScene;
    private HighScoreSceneListener highScoreSceneListener;
    private DomImpl dom;
    private SimpleStringProperty nameValue;
    private SimpleStringProperty scoreValue;
    private Button mainMenuButton;
    private TableView table;
    private TableColumn<User, String> nameCol;
    private TableColumn<User, String> scoreCol;
    private ObservableList<User> data = FXCollections.observableArrayList();
    
    public HighScoreView(Context context, HighScoreView highScoreScene) {
        super(context);
        init();
        add();
        mainMenuButton.setOnAction(e -> highScoreSceneListener.onMainMenuPressed());
        mainMenuButton.setVisible(false);
    }
    
    private void init() {
        mainMenuButton = new Button("Exit");
        mainMenuButton.getStyleClass().add("button");
        mainMenuButton.getStyleClass().add("primary");
        table = new TableView();
        nameCol = new TableColumn("Name");
        scoreCol = new TableColumn("Score");
        table.getColumns().addAll(nameCol, scoreCol);
        table.setEditable(false);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
        for (int i = 0; i < DomImpl.users.size(); i++) {
            data.add(new User(DomImpl.users.get(i).getName(), DomImpl.users.get(i).getScore()));
        }
        table.setItems(data);
    }
    
    private void add() {
        grid.add(mainMenuButton, 5, 0, 3, 1);
        grid.setHalignment(mainMenuButton, HPos.RIGHT);
        grid.add(table, 3, 2, 4, 10);
    }
    
    public void setHighScoreSceneListener(HighScoreSceneListener highScoreSceneListener) {
        this.highScoreSceneListener = highScoreSceneListener;
    }
}

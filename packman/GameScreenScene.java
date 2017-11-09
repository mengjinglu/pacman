package packman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * GameScreenScene generates GUI relating to gameplay
 * such as the maze.
 */
public class GameScreenScene extends Parent {

    VBox statusPane;
    Pane mazePane;
    Button pauseMenuButton;
    BorderPane gameScreen;

    /**
     * Constructor creates all necessary GUI components.
     */
     GameScreenScene() {

        //mazePanel generates a picture of the maze.
        //Work-in-progress and may undergo major changes.
        Pane mazePane = new Pane();
        Image mazeImage = new Image("images/TestPacmanLevel.png");
        ImageView viewMaze = new ImageView();
        //viewMaze.setImage(mazeImage);
//        mazePane.getChildren().add(viewMaze);

        //statusPanel holds the menu button and game information
        //such as score and current level.
        statusPane = new VBox();
        pauseMenuButton = new Button("Menu");
        statusPane.getChildren().add(pauseMenuButton);
        
        //gameScreen ties together mazePanel and statusPanel.
        gameScreen = new BorderPane();
        gameScreen.setRight(statusPane);
        gameScreen.setLeft(viewMaze);
    }

    /**
     * returns the pane to be added to a scene.
     */
    public Parent getView() {
        return gameScreen;
    }
}
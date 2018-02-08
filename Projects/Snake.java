import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Snake extends Application{

    Stage window = new Stage();
    Scene launchScreen, gameScreen;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //setting up window and launch screen


       Label welcome = new Label("Welcome to Snake.exe");
       Button start = new Button("Start Game");
       start.setOnAction(e -> {window.setScene(gameScreen);});
       VBox center = new VBox();
       center.setAlignment(Pos.BOTTOM_CENTER);
       center.getChildren().addAll(welcome, start);
       launchScreen = new Scene(center, 1920, 1040);


       window = primaryStage;
       window.setTitle("Snake.exe");
       window.setScene(launchScreen);
       window.show();
    }
}

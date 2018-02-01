import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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
        window = primaryStage;
        window.setTitle("Snake.exe");
        window.setScene(launchScreen);
        window.show();

        StackPane layout = new StackPane();
        launchScreen  = new Scene(layout, 1920, 1010);
        Label title = new Label("Welcome to Snake");
        layout.getChildren().add(title);
        /*
        //makes stage title
        //sets button text
        window.setTitle("Snake.exe");
        button.setText("Play Game");

        button.setOnAction(event -> {

        });

        //makes pane
        //makes button
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        //makes scene
        //scene dims: 614, 614
        Scene scene = new Scene(layout, 1920, 1010);
        */
    }
}

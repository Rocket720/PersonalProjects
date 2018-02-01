import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GraphicsTester extends Application{

    Stage window;
    Scene launch, testing;

    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label title = new Label("Welcome to the tester program");
        Button switchA = new Button("Go to other scene");
        switchA.setOnAction(e -> {
            window.setScene(testing);
        });
        VBox lay1 = new VBox(20);
        lay1.getChildren().addAll(title, switchA);
        launch = new Scene(lay1, 200, 200);

        Button switchB = new Button("Go to other scene");
        switchB.setOnAction(e -> {
            window.setScene(launch);
        });
        StackPane lay2 = new StackPane();
        lay2.getChildren().add(switchB);
        testing = new Scene(lay2, 600, 300);

        window.setScene(launch);
        window.setTitle("Switchin scenes baby");
        window.show();
    }
}

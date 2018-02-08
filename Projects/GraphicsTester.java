import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;

public class GraphicsTester extends Application{

    Stage window;
    Scene launch, testing;

    public static void main(String[] args) {
        launch(args);

        Scanner input = new Scanner(System.in);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //sets up the first scene
        Label title = new Label("Welcome to the tester program");                      //Label is a text
        Button switchA = new Button("Go to other scene");                              //Creates a button
        switchA.setOnAction(e -> {window.setScene(testing);});                              //switchOnAction method allows for the usage of a lambda "e ->" to switch to other scene
        VBox lay1 = new VBox(20);                                                   //VBox is a layout that stacks all elements vertically
        lay1.getChildren().addAll(title, switchA);                                          //adds all elements to layout
        launch = new Scene(lay1, 600, 600);                                   //sets scene "launch" to use lay1 and sets dimensions

        Button switchB = new Button("Go to other scene");                              //Button
        switchB.setOnAction(e -> {window.setScene(launch);});                               //Button with lambda
        StackPane lay2 = new StackPane();                                                   //StackPane is a layout that stacks all passed in objects
        lay2.getChildren().add(switchB);                                                    //adds button to StackPane
        testing = new Scene(lay2, 600, 600);                                  //sets scene "testing" to use lay2 and sets dimensions

        window.setScene(launch);                                                            //sets initial scene to "launch"
        window.setTitle("Switchin scenes baby");                                            //sets scene title
        window.show();                                                                      //makes window visible
        window.getIcons().add(new Image("file:logo.png"));
    }
}

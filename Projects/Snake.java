import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Snake extends Application{

    static boolean gameOn;
    static int yMod = 0;                //y Modulation
    static int xMod = 0;                //x Modulation
    static ArrayList<Coords> snake;
    static Stage window = new Stage();
    static Scene launchScreen, gameScreen;

    public static void main(String[] args) {
        launch(args);
    }

    public static void gameTick(Rectangle head) {
        head.setY(head.getY() + yMod);
        head.setX(head.getX() + xMod);

        if (head.getX() > 1920) {
            head.setX(0);
        } else if (head.getX() < 0) {
            head.setX(1920);
        } else if (head.getY() > 1080) {
            head.setY(0);
        } else if (head.getY() < 0) {
            head.setY(1060);
        }

    }

    public static void foodSpawn(Rectangle food) {
        food.setX((int) (Math.random() * (1920 / 20)) * 20);
        food.setY((int) (Math.random() * (1080 / 20)) * 20);
    }

    public static void tailTrail() {
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setX(snake.get(i - 1).getX());
            snake.get(i).setY(snake.get(i - 1).getY());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //setting up launch screen
        Label welcome = new Label("Welcome to Snake.exe");
        welcome.setMinWidth(100);
        welcome.setMinHeight(150);
        welcome.setScaleY(10);
        welcome.setScaleX(10);
        Button start = new Button("Start Game");
        start.setOnAction(e -> {
            window.setScene(gameScreen);
        });
        start.setPrefSize(200, 100);
        VBox centerScreen = new VBox();
        centerScreen.setAlignment(Pos.CENTER);
        centerScreen.getChildren().addAll(welcome, start);
        launchScreen = new Scene(centerScreen, 1920, 1010);

        //setting up gameScreen
        snake = new ArrayList<Coords>(Arrays.asList(new Coords(1, 1)));
        BorderPane game = new BorderPane();
        gameScreen = new Scene(game, 1920, 1010);
        Canvas field = new Canvas(1870, 960);
        field.setVisible(true);
        GraphicsContext paint = field.getGraphicsContext2D();
        Rectangle head = new Rectangle(20, 20, javafx.scene.paint.Color.ROYALBLUE);
        head.setX(960);
        head.setY(540);
        Rectangle food = new Rectangle(20, 20, Color.CRIMSON);
        food.setX(800);
        food.setY(800);
        gameScreen.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            Heading dir = Heading.right;
            if (key.getCode() == KeyCode.W) {
                dir = Heading.up;
            } else if (key.getCode() == KeyCode.A) {
                dir = Heading.left;
            } else if (key.getCode() == KeyCode.S) {
                dir = Heading.down;
            } else if (key.getCode() == KeyCode.D) {
                dir = Heading.right;
            } else if (key.getCode() == KeyCode.ESCAPE) {
                window.close();
            }

            switch (dir) {
                case up:
                    yMod = -20;
                    xMod = 0;
                    break;
                case down:
                    yMod = 20;
                    xMod = 0;
                    break;
                case left:
                    xMod = -20;
                    yMod = 0;
                    break;
                case right:
                    xMod = 20;
                    yMod = 0;
                    break;
            }

            System.out.println(key.getCode());

        });
        new AnimationTimer() {
            long lastTimeRan = 0;

            @Override
            public void handle(long now) {
                if (now - lastTimeRan >= 50000000) {
                    gameTick(head);
                    if (head.getX() == food.getX() && head.getY() == food.getY()) {
                        System.out.println("Score");
                        foodSpawn(food);
                    }

                    lastTimeRan = now;
                }
            }
        }.start();


        gameScreen.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
        });
        game.getChildren().addAll(head, food);


        //setting up stage
        window = primaryStage;
        window.setMaximized(true);
        window.setTitle("Snake.exe");
        window.setScene(launchScreen);
        window.getIcons().add(new Image("file:logo.png"));
        window.show();
    }
}

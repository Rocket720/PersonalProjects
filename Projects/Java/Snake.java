package Java;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
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

    static int yMod = 0;                //y Modulation
    static int xMod = 0;                //x Modulation
    static ArrayList<Coords> snake;
    static Stage window = new Stage();
    static Scene launchScreen, gameScreen, loseScreen;
    static int gameOn = 2;

    public static void main(String[] args) {
        launch(args);
    }

    public static void gameTick(Rectangle head, GraphicsContext paint) {
        head.setY(head.getY() + yMod);
        head.setX(head.getX() + xMod);

        if (head.getX() > 1880 || head.getX() < 0 || head.getY() > 980 || head.getY() < 0) {
            gameOn = 0;
        }
//        if (head.getX() > 1920) {
//            head.setX(0);
//        } else if (head.getX() < 0) {
//            head.setX(1920);
//        } else if (head.getY() > 1080) {
//            head.setY(0);
//        } else if (head.getY() < 0) {
//            head.setY(1060);
//        }
    }

    public static void snekCol(Rectangle head) {
        for (int i = 2; i < snake.size(); i++) {
            if (head.getX() == snake.get(i).getX() && head.getY() == snake.get(i).getY()) {
                gameOn = 0;
            }
        }
    }

    public static void body(Rectangle head, GraphicsContext paint) {
        paint.clearRect(0, 0, 1920, 1080);
        paint.setFill(Color.AQUAMARINE);
        for (int i = 1; i < snake.size(); i++) {
            paint.fillRect(snake.get(i).getX(), snake.get(i).getY(), 20, 20);
        }
        paint.setFill(Color.ROYALBLUE);
        paint.fillRect(snake.get(0).getX(), snake.get(0).getY(), 20, 20);
    }

    public static void foodSpawn(Rectangle food) {
        food.setX((int) (Math.random() * (1880 / 20)) * 20);
        food.setY((int) (Math.random() * (960 / 20)) * 20);
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
        Label welcome = new Label("Welcome to Java.Snake.exe");
        welcome.setMinWidth(100);
        welcome.setMinHeight(150);
        welcome.setScaleY(10);
        welcome.setScaleX(10);
        Button start = new Button("Start Game");
        start.setOnAction(e -> {
            window.setScene(gameScreen);
            gameOn = 1;
        });
        start.setPrefSize(200, 100);
        VBox centerScreen = new VBox();
        centerScreen.setAlignment(Pos.CENTER);
        centerScreen.getChildren().addAll(welcome, start);
        launchScreen = new Scene(centerScreen, 1920, 1080);

        //setting up loseScreen
        Label oof = new Label("O O F");
        oof.setMinWidth(100);
        oof.setMinHeight(150);
        oof.setScaleY(10);
        oof.setScaleX(10);
        oof.setAlignment(Pos.CENTER);
        Button restart = new Button("Restart Game");
        start.setOnAction(e -> {
            window.setScene(gameScreen);
            gameOn = 1;
        });
        start.setPrefSize(200, 100);
        VBox cS2 = new VBox();
        cS2.setAlignment(Pos.CENTER);
        Rectangle bgl = new Rectangle(1880, 980, Color.web("#282828"));
        bgl.setX(20);
        bgl.setY(20);
        Rectangle borderl = new Rectangle(1920, 1080, Color.web("#141414"));
        cS2.getChildren().addAll(borderl, bgl, oof, restart);
        loseScreen = new Scene(cS2, 1920, 1080);

        //setting up gameScreen
        snake = new ArrayList<>(Arrays.asList(new Coords(1, 1), new Coords(1, 2)));
        BorderPane game = new BorderPane();
        gameScreen = new Scene(game, 1920, 1080);
        Canvas field = new Canvas(1920, 1080);
        field.setVisible(true);
        GraphicsContext paint = field.getGraphicsContext2D();
        Rectangle head = new Rectangle(20, 20, javafx.scene.paint.Color.ROYALBLUE);
        head.setX(960);
        head.setY(540);
        Rectangle food = new Rectangle(20, 20, Color.CRIMSON);
        food.setX(800);
        food.setY(800);
        Rectangle bg = new Rectangle(1880, 980, Color.web("#282828"));
        bg.setX(20);
        bg.setY(20);
        Rectangle border = new Rectangle(1920, 1080, Color.web("#141414"));
        gameScreen.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            Heading dir = Heading.right;
            if (key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP) {
                dir = Heading.up;
            } else if (key.getCode() == KeyCode.A || key.getCode() == KeyCode.LEFT) {
                dir = Heading.left;
            } else if (key.getCode() == KeyCode.S || key.getCode() == KeyCode.DOWN) {
                dir = Heading.down;
            } else if (key.getCode() == KeyCode.D || key.getCode() == KeyCode.RIGHT) {
                dir = Heading.right;
            } else if (key.getCode() == KeyCode.ESCAPE) {
                window.close();
            } else if (key.getCode() == KeyCode.K) {
                snake.add(new Coords(1, 1));
            }

            switch (dir) {
                case up:
                    if (dir != Heading.down) {
                        yMod = -20;
                        xMod = 0;
                    }
                    break;
                case down:
                    if (dir != Heading.up) {
                        yMod = 20;
                        xMod = 0;
                    }
                    break;
                case left:
                    if (dir != Heading.right) {
                        xMod = -20;
                        yMod = 0;
                    }
                    break;
                case right:
                    if (dir != Heading.left) {
                        xMod = 20;
                        yMod = 0;
                    }
                    break;
            }

            System.out.println(key.getCode());

        });
        new AnimationTimer() {
            long lastTimeRan = 0;

            @Override
            public void handle(long now) {
                if (now - lastTimeRan >= 50000000 && gameOn == 1) {
                    gameTick(head, paint);
                    snake.get(0).setX((int) head.getX());
                    snake.get(0).setY((int) head.getY());
                    tailTrail();
                    body(head, paint);
                    snekCol(head);
                    if (head.getX() == food.getX() && head.getY() == food.getY()) {
                        foodSpawn(food);
                        snake.add(new Coords(1, 1));
                    }
                    if (gameOn == 0) {
                        window.setScene(loseScreen);
                    }
                    lastTimeRan = now;
                }
            }
        }.start();
        game.getChildren().addAll(border, bg, head, food, field);

        //setting up stage
        window = primaryStage;
        window.setMaximized(true);
        window.setTitle("Java.Snake.exe");
        window.setScene(launchScreen);
        window.getIcons().add(new Image("file:logo.png"));
        window.show();
    }
}

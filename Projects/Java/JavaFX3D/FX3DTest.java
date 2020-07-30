package JavaFX3D;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

public class FX3DTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();

        //Camera
        Camera camera = new PerspectiveCamera(true);
        camera.setTranslateX(640); camera.setTranslateY(360); camera.setTranslateZ(-800);
        camera.setNearClip(0); camera.setFarClip(1000);

        //Planet
//        Sphere planet = new Sphere(100);
//        planet.setTranslateX(640); planet.setTranslateY(360); planet.setTranslateZ(0);
//        group.getChildren().add(planet);

        //Planet Axes
        Box xAxis = new Box(500, 5, 5);
        xAxis.setTranslateX(640); xAxis.setTranslateY(360);
        group.getChildren().add(xAxis);
        Box yAxis = new Box(5, 500, 5);
        yAxis.setTranslateX(640); yAxis.setTranslateY(360);
        group.getChildren().add(yAxis);
        Box zAxis = new Box(5, 5, 500);
        zAxis.setTranslateX(640); zAxis.setTranslateY(360);
        group.getChildren().add(zAxis);

        System.out.println("Hello?");
        //Box
//        Box b = new Box(200, 200, 200);
//        b.setTranslateX(640); b.setTranslateY(360);
//        b.getTransforms().add(new Rotate(45, new Point3D(0, 100, 0))); b.getTransforms().add(new Rotate(45, new Point3D(100, 0, 100)));
//        group.getChildren().add(b);

//        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED , e -> {
//            double distance = Math.abs(camera.getTranslateZ() - b.getTranslateZ()) - 300, scale = scaleFunction(distance);
//            //System.out.println(distance + " " + scale);
//            switch (e.getCode()){
//                case EQUALS:
//                    camera.setTranslateZ(camera.getTranslateZ()+scale);
//                    break;
//                case MINUS:
//                    camera.setTranslateZ(camera.getTranslateZ()-scale);
//                    break;
//                case LEFT:
//                    b.getTransforms().add(new Rotate(5, new Point3D(0, 1, 0)));
//                    break;
//                case RIGHT:
//                    b.getTransforms().add(new Rotate(-5, new Point3D(0, 1, 0)));
//                    break;
//                case UP:
//                    b.getTransforms().add(new Rotate(-5, new Point3D(1, 0, 0)));
//                    break;
//                case DOWN:
//                    b.getTransforms().add(new Rotate(5, new Point3D(1, 0, 0)));
//                    break;
//                case ESCAPE:
//                    primaryStage.close();
//            }
//            //System.out.println(camera.getTranslateZ());
//        });




        //Window Setup
        Scene s = new Scene(group, 1280, 720);
        s.setFill(Color.SLATEGREY); s.setCamera(camera);
        primaryStage.setScene(s);
        primaryStage.setTitle("3D Test");
        primaryStage.show();

    }
    double scaleFunction(double x){
        if(x>100)
            return Math.pow(0.1*x-10, 0.5);
        return 0.5;
        //return 10/(1+Math.exp(-0.005*(x+200))); //Sigmoid
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Arkanoid extends Application {
    private Pane root;
    private Scene scene;
    private static final int SCENE_WIDTH = 1200;
    private static final int SCENE_HEIGHT = 650;

    public void start(Stage primaryStage) {
        this.root = new Pane();
        this.scene = new Scene(this.root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setTitle("Arkanoid Game");
        Rectangle paddle = new Rectangle(100, 20, Color.BLUE);
        paddle.setLayoutX(350);
        paddle.setLayoutY(560);

        Circle ball = new Circle(10, Color.RED);
        ball.setLayoutX(400);
        ball.setLayoutY(550);

        root.getChildren().addAll(paddle, ball);
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
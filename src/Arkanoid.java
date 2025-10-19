import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
        Paddle paddle = new Paddle();
        Ball ball = new Ball();
        root.getChildren().addAll(paddle.drawPaddle(), ball.drawBall());
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Arkanoid extends Application {
    private Pane root;
    private Scene scene;
    private Ball ball;
    private Paddle paddle;
    private static final int SCENE_WIDTH = 1200;
    private static final int SCENE_HEIGHT = 650;

    public void start(Stage primaryStage) {
        this.initializeGame();
        this.scene = new Scene(this.root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setTitle("Arkanoid Game");
        scene.setOnMouseMoved(e -> {
            paddle.setX((int) e.getX() - paddle.getWidth() / 2);
        });
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }

    private void initializeGame() {
        this.root = new Pane();
        this.paddle = new Paddle();
        this.paddle.setX((double)350.0F - this.paddle.getWidth() / (double)2.0F);
        this.paddle.setY((double)560.0F);
        this.root.getChildren().add(this.paddle.paddle_iv);
        this.ball = new Ball();
        this.ball.setX((double)400.0F);
        this.ball.setY((double)530.0F);
        this.root.getChildren().add(this.ball.ball_iv);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
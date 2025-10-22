import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class Arkanoid extends Application {
    private Pane root;
    private Scene scene;
    private Ball ball;
    private Paddle paddle;
    private static final int SCENE_WIDTH = 1200;
    private static final int SCENE_HEIGHT = 650;

    private boolean gameStarted = false;
    private AnimationTimer gameLoop;

    public void start(Stage primaryStage) {
        this.initializeGame();
        this.scene = new Scene(this.root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setTitle("Arkanoid Game");
        scene.setOnMouseMoved(e -> {
            paddle.setX((int) e.getX() - paddle.getWidth() / 2);
            if ( e.getX() >= SCENE_WIDTH - paddle.getWidth() / 2) {
                paddle.setX(SCENE_WIDTH - paddle.getWidth() );
            }
            if (paddle.getX() <= 0) {
                paddle.setX(0);
            }
            if (!gameStarted) {
                ball.setX(e.getX() - ball.getWidth() / 2);
            }
        });

        scene.setOnMouseClicked(e -> {
            if (!gameStarted) {
                gameStarted = true;

                ball.setDx(3.0);
                ball.setDy(-5.0);
            }
        });

        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        gameLoop.start();

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

    private void update() {
        if (gameStarted) {
            ball.setX(ball.getX() + ball.getDx());
            ball.setY(ball.getY() + ball.getDy());
            if (ball.getX() <= 0) {
                ball.setDx(-ball.getDx());
            }
            if (ball.getX() + ball.getWidth() >= SCENE_WIDTH) {
                ball.setDx(-ball.getDx());
            }
            if (ball.getY() <= 0) {
                ball.setDy(-ball.getDy());
            }
            if (ball.getDy() > 0 && ball.ball_iv.getBoundsInParent().intersects(paddle.paddle_iv.getBoundsInParent())) {
                ball.setDy(-ball.getDy());
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

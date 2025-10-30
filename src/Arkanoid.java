import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Arkanoid extends Application {

    private static final int SCENE_WIDTH = 1200;
    private static final int SCENE_HEIGHT = 650;

    private GameLogic gameLogic;
    private InputHandler inputHandler;
    private GameUI gameUI;

    private Ball ball;
    private Paddle paddle;

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setTitle("Arkanoid Game");

        ball = new Ball();
        paddle = new Paddle();

        gameUI = new GameUI(root);
        gameLogic = new GameLogic(ball, paddle, SCENE_WIDTH, SCENE_HEIGHT);
        inputHandler = new InputHandler(scene, paddle, ball, gameLogic);

        gameUI.addObject(paddle.paddle_iv);
        gameUI.addObject(ball.ball_iv);

        paddle.setX(SCENE_WIDTH / 2 - paddle.getWidth() / 2);
        paddle.setY(560);
        ball.setX(paddle.getX() + paddle.getWidth() / 2 - ball.getWidth() / 2);
        ball.setY(paddle.getY() - ball.getHeight());

        inputHandler.registerHandlers();

        gameLogic.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
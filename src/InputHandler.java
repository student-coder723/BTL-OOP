import javafx.scene.Scene;

public class InputHandler {

    private Scene scene;
    private Paddle paddle;
    private Ball ball;
    private GameLogic gameLogic;

    public InputHandler(Scene scene, Paddle paddle, Ball ball, GameLogic gameLogic) {
        this.scene = scene;
        this.paddle = paddle;
        this.ball = ball;
        this.gameLogic = gameLogic;
    }

    public void registerHandlers() {
        scene.setOnMouseMoved(e -> {
            double mouseX = e.getX();

            paddle.setX(mouseX - paddle.getWidth() / 2);

            if (mouseX <= paddle.getWidth() / 2) {
                paddle.setX(0);
            } else if (mouseX >= scene.getWidth() - paddle.getWidth() / 2) {
                paddle.setX(scene.getWidth() - paddle.getWidth());
            }

            if (!gameLogic.isGameStarted()) {
                ball.setX(paddle.getX() + (paddle.getWidth() / 2) - (ball.getWidth() / 2));
                ball.setY(paddle.getY() - ball.getHeight());
            }
        });

        scene.setOnMouseClicked(e -> {
            gameLogic.startGame();
        });
    }
}
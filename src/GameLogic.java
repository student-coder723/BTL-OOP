import javafx.animation.AnimationTimer;

public class GameLogic {

    private Ball ball;
    private Paddle paddle;
    private double sceneWidth;
    private double sceneHeight;

    private boolean gameStarted = false;
    private AnimationTimer gameLoop;

    public GameLogic(Ball ball, Paddle paddle, double sceneWidth, double sceneHeight) {
        this.ball = ball;
        this.paddle = paddle;
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;

        this.gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
    }

    public void start() {
        gameLoop.start();
    }

    public void stop() {
        gameLoop.stop();
    }

    public void startGame() {
        if (!gameStarted) {
            gameStarted = true;
            ball.setDx(1.0);
            ball.setDy(-5.0);
        }
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    private void update() {
        if (gameStarted) {

            ball.setX(ball.getX() + ball.getDx());
            ball.setY(ball.getY() + ball.getDy());

            if (ball.getX() <= 0 || ball.getX() + ball.getWidth() >= sceneWidth) {
                ball.setDx(-ball.getDx());
            }

            if (ball.getY() <= 0) {
                ball.setDy(-ball.getDy());
            }

            if (ball.ball_iv.getBoundsInParent().intersects(paddle.paddle_iv.getBoundsInParent())) {
                ball.setDy(-ball.getDy());
            }

            if (ball.getY() + ball.getHeight() >= sceneHeight) {
                gameStarted = false;
                ball.setX(paddle.getX() + paddle.getWidth() / 2 - ball.getWidth() / 2);
                ball.setY(paddle.getY() - ball.getHeight());
                ball.setDx(0);
                ball.setDy(0);
            }

        }
    }
}
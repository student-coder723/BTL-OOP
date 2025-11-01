import java.util.List;

public class GameLogic {
    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;

    public GameLogic(Ball ball, Paddle paddle, List<Brick> bricks) {
        this.ball = ball;
        this.paddle = paddle;
        this.bricks = bricks;
    }

    public void update() {
        ball.update();
        paddle.update();
        checkCollisions();
    }

    private void checkCollisions() {
        if (ball.checkCollision(paddle)) {
            if (ball.getDirectionY() > 0) {
                ball.reverseDirectionY();
                ball.setY(paddle.getY() - ball.getHeight() - 1);
            }
        }

        for (Brick brick : bricks) {
            if (!brick.isDestroyed() && ball.checkCollision(brick)) {
                ball.reverseDirectionY();
                brick.setDestroyed(true);
                break;
            }
        }
    }
}
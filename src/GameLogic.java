public class GameLogic {
    private Ball ball;
    private Paddle paddle;

    public GameLogic(Ball ball, Paddle paddle) {
        this.ball = ball;
        this.paddle = paddle;
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
    }
}
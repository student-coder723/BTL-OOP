import java.util.List;

public class GameLogic {
    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;

    private GameState gameState;
    private int sceneHeight;

    private int score;

    public GameLogic(Ball ball, Paddle paddle, List<Brick> bricks, int sceneHeight) {
        this.ball = ball;
        this.paddle = paddle;
        this.bricks = bricks;
        this.sceneHeight = sceneHeight;
        this.gameState = GameState.READY;
        this.score = 0;
    }

    public void update() {
        paddle.update();
        switch (gameState) {
            case READY:
                ball.stickToPaddle(paddle);
                break;
            case RUNNING:
                ball.update();
                checkCollisions();
                checkBallOut();
                break;
            case PAUSED:
            case GAME_OVER:
                break;
        }
    }

    public void startGame() {
        if (gameState == gameState.READY) {
            gameState = GameState.RUNNING;
        }
    }

    private void resetBall() {
        this.gameState = GameState.READY;
    }

    private void checkBallOut() {
        if (ball.getY() + ball.getHeight() >= this.sceneHeight) {
            resetBall();
        }
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
                this.score += 10;
                break;
            }
        }
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

}
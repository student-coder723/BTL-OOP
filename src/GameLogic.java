import java.util.List;

public class GameLogic {
    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;

    private GameState gameState;
    private int sceneHeight;

    private int score;
    private int lives;

    private SoundManager soundManager;

    public GameLogic(Ball ball, Paddle paddle, List<Brick> bricks, int sceneHeight, SoundManager soundManager) {
        this.ball = ball;
        this.paddle = paddle;
        this.bricks = bricks;
        this.sceneHeight = sceneHeight;
        this.gameState = GameState.READY;
        this.score = 0;
        this.lives = 3;
        this.soundManager = soundManager;
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

    public void resetGame() {
        this.lives = 3;
        this.score = 0;

        for (Brick brick : bricks) {
            brick.reset();
        }

        resetBall();
    }

    private void resetBall() {
        this.gameState = GameState.READY;
    }

    private void checkBallOut() {
        if (ball.getY() + ball.getHeight() >= this.sceneHeight) {
            this.lives--;

            if (lives <= 0){
                this.gameState = GameState.GAME_OVER;

                if (soundManager != null) {
                    soundManager.playGameOver();
                }
            }
            else {
                resetBall();
            }
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

                if (soundManager != null) {
                    soundManager.playBrickBreak();
                }
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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
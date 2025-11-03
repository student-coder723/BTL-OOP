import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameLogic {
    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;
    private GameState gameState;
    private int sceneHeight;
    private int score;
    private int lives;

    private SoundManager soundManager;

    private List<PowerUp> activePowerUps;
    private Random random;

    public GameLogic(Ball ball, Paddle paddle, List<Brick> bricks, int sceneHeight, SoundManager soundManager) {
        this.ball = ball;
        this.paddle = paddle;
        this.bricks = bricks;
        this.sceneHeight = sceneHeight;
        this.gameState = GameState.READY;
        this.score = 0;
        this.lives = 3;
        this.soundManager = soundManager;
        this.activePowerUps = new ArrayList<>();
        this.random = new Random();
    }

    public boolean update() {
        paddle.update();
        switch (gameState) {
            case READY:
                paddle.update();
                ball.stickToPaddle(paddle);
                break;
            case RUNNING:
                paddle.update();
                ball.update();
                updatePowerUps();
                checkCollisions();
                checkBallOut();

                if (checkWin()) {
                    resetBall();
                    return true;
                }
                break;
            case PAUSED:
            case GAME_OVER:
                break;
        }
        return false;
    }

    private boolean checkWin() {
        for (Brick brick : bricks) {
            if (!brick.isDestroyed()) {
                return false;
            }
        }
        return true;
    }

    private void updatePowerUps() {
        Iterator<PowerUp> iterator = activePowerUps.iterator();
        while (iterator.hasNext()) {
            PowerUp powerUp = iterator.next();
            powerUp.update();

            if (powerUp.getY() > this.sceneHeight) {
                iterator.remove();
            }
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

        activePowerUps.clear();

        resetBall();

        if (soundManager != null) {
            soundManager.playMusic();
        }
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
                    soundManager.stopMusic();
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
                int score_ = brick.handleCollision();
                ball.reverseDirectionY();

                this.score += score_;
                if (soundManager != null) {
                    soundManager.playBrickBreak();
                }
                if (random.nextInt(5) == 0) {
                    spawnPowerUp(brick.getX(), brick.getY());
                }
                break;
            }
        }
        Iterator<PowerUp> iterator = activePowerUps.iterator();
        while (iterator.hasNext()) {
            PowerUp powerUp = iterator.next();

            if (!powerUp.getIsEat() && powerUp.checkCollision(paddle)) {
                powerUp.applyEffect(this, paddle, ball);
                powerUp.setIsEat(true);
                iterator.remove();
            }
        }

    }

    private void spawnPowerUp(int x, int y) {
        int powerUpType = random.nextInt(2);

        switch (powerUpType) {
            case 0:
                activePowerUps.add(new AddLifePowerUp(x, y));
                break;
            case 1 :
                activePowerUps.add(new FastBallPowerUp(x, y));
                break;
        }
    }


    public void Pause() {
        if (this.gameState == GameState.RUNNING) {
            this.gameState = GameState.PAUSED;
        } else if (this.gameState == GameState.PAUSED) {
            this.gameState = GameState.RUNNING;
        }
    }

    public void addLife() {
        if (this.lives < 5) {
            this.lives++;
        }
    }

    public List<PowerUp> getActivePowerUps() {
        return activePowerUps;
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
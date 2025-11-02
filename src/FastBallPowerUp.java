import javafx.scene.image.Image;

public class FastBallPowerUp extends PowerUp {

    private static final int POWERUP_WIDTH = 20;
    private static final int POWERUP_HEIGHT = 20;

    private static Image fastBallImage;

    static {
        fastBallImage = ResourceLoader.loadImage("/Ball/Ball.png");
    }

    public FastBallPowerUp(int x, int y) {
        super(x, y, POWERUP_WIDTH, POWERUP_HEIGHT, fastBallImage, PowerUpType.FAST_BALL);
    }

    @Override
    public void applyEffect(GameLogic gameLogic, Paddle paddle, Ball ball) {
        ball.setSpeed(4);
    }
}

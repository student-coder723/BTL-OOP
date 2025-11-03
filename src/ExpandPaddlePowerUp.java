import javafx.scene.image.Image;

public class ExpandPaddlePowerUp extends PowerUp {
    private static final int POWERUP_WIDTH = 40;
    private static final int POWERUP_HEIGHT = 20;

    private static Image expandImage;

    static {
        expandImage = ResourceLoader.loadImage("/Paddle/a.png");
    }

    public ExpandPaddlePowerUp(int x, int y) {
        super(x, y, POWERUP_WIDTH, POWERUP_HEIGHT, expandImage, PowerUpType.EXPAND_PADDLE);
    }

    @Override
    public void applyEffect(GameLogic gameLogic, Paddle paddle, Ball ball) {
        paddle.setWidth(200);
    }
}

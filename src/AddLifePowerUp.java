import javafx.scene.image.Image;

public class AddLifePowerUp extends PowerUp {
    private static final int POWERUP_WIDTH = 30;
    private static final int POWERUP_HEIGHT = 30;
    private static Image heartImage;

    static {
        heartImage = ResourceLoader.loadImage("/Power Up/heart.png");
    }

    public AddLifePowerUp(int x, int y) {
        super(x, y, POWERUP_WIDTH, POWERUP_HEIGHT, heartImage, PowerUpType.ADD_LIFE);
    }

    @Override
    public void revertEffect(GameLogic gameLogic, Paddle paddle, Ball ball) {}

    @Override
    public void applyEffect(GameLogic gameLogic, Paddle paddle, Ball ball) {
        gameLogic.addLife();
    }
}

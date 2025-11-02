import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class PowerUp extends MovableObject {
    protected PowerUpType type;
    protected Image image;
    private boolean isEat;

    public PowerUp(int x, int y, int width, int height, Image image, PowerUpType type) {
        super(x, y, width, height, 0, 2);
        this.image = image;
        this.type = type;
        this.isEat = false;
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public void render(GraphicsContext gc) {
        if (!isEat && image != null) {
            gc.drawImage(image, x, y, width, height);
        }
    }

    public abstract void applyEffect(GameLogic gameLogic, Paddle paddle, Ball ball);

    public boolean getIsEat() {
        return isEat;
    }

    public void setIsEat(boolean isEat) {
        this.isEat = isEat;
    }
}

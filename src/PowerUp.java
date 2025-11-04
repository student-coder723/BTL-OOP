import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class PowerUp extends MovableObject {
    protected PowerUpType type;
    protected Image image;
    protected int durationInFrames;

    private int activeTimer;
    private boolean isEat;

    public PowerUp(int x, int y, int width, int height, Image image, PowerUpType type) {
        super(x, y, width, height, 0, 2);
        this.image = image;
        this.type = type;
        this.isEat = false;
        this.activeTimer = 0;
        this.durationInFrames = 0;
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

    public boolean isTemporary() {
        return durationInFrames > 0;
    }
    public boolean isExpired() {
        return activeTimer >= durationInFrames;
    }

    public void tick() {
        this.activeTimer++;
    }


    public abstract void revertEffect(GameLogic gameLogic, Paddle paddle, Ball ball);

    public abstract void applyEffect(GameLogic gameLogic, Paddle paddle, Ball ball);

    public boolean getIsEat() {
        return isEat;
    }

    public void setIsEat(boolean isEat) {
        this.isEat = isEat;
    }
}

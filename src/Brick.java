import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public abstract class Brick extends GameObject {
    private boolean isDestroyed;
    protected Image brickImage;

    public Brick(int x, int y, int width, int height, Image image) {
        super(x, y, width, height);
        this.brickImage = image;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(GraphicsContext gc) {
        if (!isDestroyed) {
            if (brickImage != null) {
                gc.drawImage(brickImage, x, y, width, height);
            } else {
                gc.setFill(Color.WHITE);
                gc.fillRect(x, y, width, height);
            }
        }
    }

    public abstract int handleCollision();

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public void reset() {
        this.isDestroyed = false;
    }
}

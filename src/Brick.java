import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Brick extends GameObject {
    private boolean isDestroyed = false;
    private Image brickImage;

    /**
     * Brick constructor.
     * @param x vị trí theo trục X
     * @param y vị trí theo trục Y
     * @param width chiều rộng của brick
     * @param height chiều cao của brick
     * @param image brickImage
     */
    public Brick(int x, int y, int width, int height, Image image) {
        super(x, y, width, height);
        this.brickImage = image;
    }

    @Override
    public void render(GraphicsContext g) {
        if (brickImage != null) {
            g.drawImage(brickImage, x, y, width, height);
        }
    }

    @Override
    public void update() {

    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}

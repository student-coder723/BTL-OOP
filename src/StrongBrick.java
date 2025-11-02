import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class StrongBrick extends Brick {
    private int hits;
    private Image strongImage;
    private Image brokenImage;

    public StrongBrick(int x, int y, int width, int height, Image strongImage, Image brokenImage) {
        super(x, y, width, height, strongImage);
        this.strongImage = strongImage;
        this.brokenImage = brokenImage;
        this.hits = 2;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
    }

    @Override
    public int handleCollision() {
        this.hits--;

        if (this.hits == 1) {
            this.brickImage = this.brokenImage;
        }

        if (this.hits <= 0) {
            setDestroyed(true);
        }

        return 10;
    }

    @Override
    public void reset() {
        super.reset();
        this.hits = 2;
        this.brickImage = this.strongImage;
    }

}

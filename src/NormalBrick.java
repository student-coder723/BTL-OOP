import javafx.scene.image.Image;

public class NormalBrick extends Brick {
    public NormalBrick(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
    }

    @Override
    public void update() {

    }

    @Override
    public void handleCollision(Ball ball) {
        setDestroyed(true);
    }
}

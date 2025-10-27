import javafx.scene.image.Image;

public class StrongBrick extends Brick {
    private int health;

    public StrongBrick(int x, int y, int width, int height, Image image) {
        super(x, y, width, height, image);
        this.health = 2;
    }

    @Override
    public void handleCollision(Ball ball) {
        this.health--;
        if (health <= 0) {
            setDestroyed(true);
        }
    }

    @Override
    public void update() {

    }
}
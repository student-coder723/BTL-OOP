import javafx.scene.image.Image;

public class StrongBrick extends Brick {
    private int health;

    public StrongBrick(int x, int y, int width, int height, int health, Image image) {
        super(x, y, width, height, image);
        this.health = 2;
    }
}
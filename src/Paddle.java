import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class Paddle extends MovableObject {
    protected int speed;
    private Image paddleImage;

    public static final int DEFAULT_WIDTH = 100;

    public Paddle(int x, int y, int width, int height, int speed, Image paddleImage) {
        super(x, y, width, height, 0, 0);
        this.speed = speed;
        this.paddleImage = paddleImage;
    }

    @Override
    public void update() {

    }

    @Override
    public void render (GraphicsContext gc) {
        if (paddleImage != null) {
            gc.drawImage(paddleImage, x, y, width, height);
        } else {
            gc.setFill(Color.WHITE);
            gc.fillRect(x, y, width, height);
        }
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

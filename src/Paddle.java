import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Paddle extends MovableObject {
    protected int speed;
    private Image paddleImage;

    /**
     * Paddle constructor.
     * @param x vị trí theo trục X
     * @param y vị trí theo trục Y
     * @param width chiều rộng của Paddle
     * @param height chiều cao của Paddle
     * @param speed tốc độ di chuyển của Paddle
     * @param image paddleImage
     */
    public Paddle(int x, int y, int width, int height, int speed, Image image) {
        super(x, y, width, height, 0, 0);
        this.speed = speed;
        this.paddleImage = image;
    }

    public void moveLeft() {
        dx = -speed;
    }

    public void moveRight() {
        dx = speed;
    }

    public void stop() {
        dx = 0;
    }

    @Override
    public void update() {
        super.update();

        if (x < 0) {
            x = 0;
        }

        if (x + getWidth() > 800) {
            x = 800 - getWidth();
        }
    }

    @Override
    public void render(GraphicsContext g) {
        if (paddleImage != null) {
            g.drawImage(paddleImage, x, y, width, height);
        } else {
            g.setFill(Color.YELLOW);
            g.fillRect(x, y, width, height);
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
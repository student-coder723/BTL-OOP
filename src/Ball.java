import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Ball extends MovableObject {
    private int speed;
    private int directionX;
    private int directionY;
    private Image ballImage;

    public Ball(int x, int y, int size, int speed, int directionX, int directionY, Image image) {
        super(x, y, size, size, 0, 0);
        this.speed = speed;
        this.directionX = directionX;
        this.directionY = directionY;
        this.ballImage = image;
    }



    @Override
    public void update() {
        x += speed * directionX;
        y += speed * directionY;
    }

    @Override
    public void render(GraphicsContext g) {
        if (ballImage != null) {
            g.drawImage(ballImage, x, y, width, height);
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

    public int getDirectionX() {
        return directionX;
    }
    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }
    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }
}

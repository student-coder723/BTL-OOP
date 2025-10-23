import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.Rectangle;

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

    private void updateVelocity() {
        this.dx = this.speed * this.directionX;
        this.dy = this.speed * this.directionY;
    }

    public boolean checkCollistion(GameObject other) {
        Rectangle ballBounds = new Rectangle(x, y, width, height);
        Rectangle otherBounds = new Rectangle(other.getX(), other.getY(), other.getWidth(), other.getHeight());
        return ballBounds.intersects(otherBounds);
    }

    public void reverseDirectionX() {
        setDirectionX(-this.directionX);
    }

    public void reverseDirectionY() {
        setDirectionY(-this.directionY);
    }

    @Override
    public void update() {
        x += speed * directionX;
        y += speed * directionY;

        if (x <= 0 || x + width >= Arkanoid.WIDTH) {
            reverseDirectionX();
        }

        if (y <= 0 || y + height >= Arkanoid.HEIGHT) {
            reverseDirectionY();
        }
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

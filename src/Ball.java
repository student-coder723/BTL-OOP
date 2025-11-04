import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Ball extends MovableObject {
    private int speed;
    private int directionX;
    private int directionY;
    private int sceneWidth;
    private int sceneHeight;
    private Image ballImage;

    public static final int DEFAULT_SPEED = 4;

    public Ball(int x, int y, int size, int speed, int directionX, int directionY, int sceneWidth, int sceneHeight, Image image) {
        super(x, y, size, size,0, 0);
        this.speed = speed;
        this.directionX = directionX;
        this.directionY = directionY;
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.ballImage = image;
    }

    private void updateVelocity() {
        this.dx = this.directionX * this.speed;
        this.dy = this.directionY * this.speed;
    }

    @Override
    public void update() {
        updateVelocity();
        super.update();
        checkWallCollision();
    }

    @Override
    public void render(GraphicsContext gc) {
        if (ballImage != null) {
            gc.drawImage(ballImage, x, y, width, height);
        } else {
            gc.setFill(Color.YELLOW);
            gc.fillOval(x, y, width, height);
        }
    }

    public void reverseDirectionX() {
        this.directionX = -this.directionX;
    }

    public void reverseDirectionY() {
        this.directionY = -this.directionY;
    }

    private void checkWallCollision() {
        if (x <= 0) {
            setX(0);
            reverseDirectionX();
        } else if (x + width >= sceneWidth) {
            setX(sceneWidth - width);
            reverseDirectionX();
        }
        if (y <= 0) {
            setY(0);
            reverseDirectionY();
        }
    }

    public void stickToPaddle(Paddle paddle) {
        this.x = paddle.getX() + (paddle.getWidth() / 2) - (this.width / 2);
        this.y = paddle.getY() - this.height;
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 2) {
            this.speed = 2;
        } else if (speed > 8) {
            this.speed = 8;
        } else {
            this.speed = speed;
        }
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

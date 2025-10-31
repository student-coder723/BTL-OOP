import javafx.scene.canvas.GraphicsContext;

public class Ball extends MovableObject {
    private int speed;
    private int directionX;
    private int directionY;

    public Ball(int x, int y, int size, int speed, int directionX, int directionY) {
        super(x, y, size, size, 0, 0);
        this.speed = speed;
        this.directionX = directionX;
        this.directionY = directionY;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(GraphicsContext g) {

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

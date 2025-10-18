public class Paddle extends MovableObject {
    protected int speed;

    public Paddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, 0, 0);
        this.speed = speed;
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
    public void render() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
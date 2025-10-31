
import javafx.scene.canvas.GraphicsContext;


public class Paddle extends MovableObject {
    protected int speed;
    public Paddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, 0, 0);
        this.speed = speed;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext gc) {

    }


    public double getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

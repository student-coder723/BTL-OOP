import javafx.scene.canvas.GraphicsContext;

public class Brick extends GameObject {
    private boolean isDestroyed;

    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void update() {


    }

    @Override
    public void render(GraphicsContext gc) {
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}

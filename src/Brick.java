import javafx.scene.canvas.GraphicsContext;

public abstract class Brick extends GameObject {
    private boolean isDestroyed = false;

    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(GraphicsContext g) {

    }

    @Override
    public void update() {

    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}

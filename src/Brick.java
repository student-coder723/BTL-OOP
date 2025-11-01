import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Brick extends GameObject {
    private boolean isDestroyed;

    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.isDestroyed = false;
    }

    @Override
    public void update() {


    }

    @Override
    public void render(GraphicsContext gc) {
        if (!isDestroyed) {
            gc.setFill(Color.WHITE);
            gc.fillRect(x, y, width, height);
        }
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}

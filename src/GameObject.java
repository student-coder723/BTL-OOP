import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    /**
     * GameObject constructor.
     * @param x vị trí theo trục X
     * @param y vị trí theo trục Y
     * @param width chiểu rộng của đối tượng
     * @param height chiều cao của dối tượng
     */
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update();

    public abstract void render(GraphicsContext g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

package arkanoid.model;

import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    /**
     * GameObject constructor.
     * @param x vị trí ban đầu theo trục x
     * @param y vị trí ban đầu theo trục y
     * @param width chiều rộn của đối tượng
     * @param height chiều cao của đối tượng
     */
    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update();

    /**
     * Vẽ các vật thể ra màn hình
     * @param g
     */
    public abstract void render(GraphicsContext g);

    /**
     * Kiểm tra va chạm.
     * @param other một đối tượng khác cần check
     * @return true nếu va chạm và ngược lại
     */
    public boolean checkCollision(GameObject other) {
        return this.x < other.x + other.width &&
                this.x + this.width > other.x &&
                this.y < other.y + other.height &&
                this.y + this.height > other.y;
    }

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

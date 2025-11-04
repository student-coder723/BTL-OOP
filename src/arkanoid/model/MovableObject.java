package arkanoid.model;

import javafx.scene.canvas.GraphicsContext;

public abstract class MovableObject extends GameObject {
    protected int dx;
    protected int dy;

    /**
     * MovableObject constructor.
     * @param x vị trí ban đầu theo trục x
     * @param y vị trí ban đầu theo trục y
     * @param width chiều rộng của đối tượng
     * @param height chiều cao của đối tượng
     * @param dx vận tốc ban đầu theo trục x
     * @param dy vận tốc ban đầu theo trục y
     */
    public MovableObject(int x, int y, int width, int height, int dx, int dy) {
        super(x, y, width, height);
        this.dx = dx;
        this.dy = dy;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    @Override
    public void update() {
        move();
    }

    @Override
    public abstract void render(GraphicsContext g);

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}

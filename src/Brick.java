public abstract class Brick extends GameObject {
    private boolean isDestroyed = false;

    public Brick(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render() {

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

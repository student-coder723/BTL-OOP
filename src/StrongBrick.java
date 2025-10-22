public class StrongBrick extends Brick {
    private int health;

    public StrongBrick(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.health = 2;
    }
}
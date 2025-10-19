import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Paddle {
    private double Height;
    private double Width;

    public Paddle() {
        this.Height = 25.0F;
        this.Width = 100.0F;
    }

    public Rectangle drawPaddle() {
        Rectangle paddle = new Rectangle(this.getWidth(), this.Height, Color.BLUE);
        paddle.setLayoutX(350);
        paddle.setLayoutY(560);
        return paddle;
    }

    public double getHeight() {
        return this.Height;
    }

    public void setHeight(double height) {
        this.Height = height;
    }

    public double getWidth() {
        return this.Width;
    }

    public void setWidth(double width) {
        this.Width = width;
    }
}

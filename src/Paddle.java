import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.net.URL;
import java.util.Objects;

public class Paddle {
    private double Height;
    private double Width;
    Image paddle = new Image(((URL) Objects.requireNonNull(this.getClass().getResource("/Paddle/a.png"))).toExternalForm(), (double)200.0F, (double)40.0F, false, false);
    ImageView paddle_iv;

    public Paddle() {
        this.Height = 40.0F;
        this.Width = 200.0F;
        this.paddle_iv = new ImageView(this.paddle);
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

    public double getX() {
        return this.paddle_iv.getX();
    }

    public void setX(double x) {
        this.paddle_iv.setX(x);
    }

    public double getY() {
        return this.paddle_iv.getY();
    }

    public void setY(double y) {
        this.paddle_iv.setY(y);
    }
}

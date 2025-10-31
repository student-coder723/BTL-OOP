import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ball {
    Image ballImage = new Image(this.getClass().getResource("/Ball/ball.png").toExternalForm(), (double)30.0F, (double)30.0F, false, false);
    ImageView ball_iv;
    private double Height;
    private double Width;
    private double dx;
    private double dy;

    public Ball() {
        this.ball_iv = new ImageView(this.ballImage);
        this.Height = (double)48.0F;
        this.Width = (double)50.0F;
        this.dx = 0;
        this.dy = 0;
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
        return this.ball_iv.getX();
    }

    public void setX(double x) {
        this.ball_iv.setX(x);
    }

    public double getY() {
        return this.ball_iv.getY();
    }

    public void setY(double y) {
        this.ball_iv.setY(y);
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}

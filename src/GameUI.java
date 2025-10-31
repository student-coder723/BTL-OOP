import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameUI {
    private Paddle paddle;
    private Ball ball;
    private Image backgroundImage;
    public GameUI() {

    }

    public void render(GraphicsContext gc, int width, int height) {
        if (backgroundImage != null) {
            gc.drawImage(backgroundImage, 0, 0, width, height);
        } else {
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, width, height);
        }

        if (paddle != null){
            paddle.render(gc);
        }

        if (ball != null) {
            ball.render(gc);
        }
    }

    public Paddle getPaddle(){
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
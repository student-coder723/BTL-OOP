import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.util.List;
import java.util.ArrayList;

public class GameUI {
    private Paddle paddle;
    private Ball ball;
    private Image backgroundImage;
    private List<Brick> bricks;
    public GameUI() {
        this.bricks = new ArrayList<>();
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

        for (Brick brick : bricks) {
            brick.render(gc);
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

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

}
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameUI {
    private Paddle paddle;
    public GameUI() {

    }

    public void render(GraphicsContext gc, int width, int height) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width, height);

        if (paddle != null){
            paddle.render(gc);
        }
    }

    public Paddle getPaddle(){
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }
}
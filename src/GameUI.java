import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import java.util.List;
import java.util.ArrayList;

public class GameUI {
    private Paddle paddle;
    private Ball ball;
    private Image backgroundImage;
    private List<Brick> bricks;
    private Font uiFont;
    private Font gameOverFont;

    public GameUI() {
        this.bricks = new ArrayList<>();

        try {
            this.uiFont = Font.font("Verdana", 20);
            this.gameOverFont = Font.font("Verdana", 40);
        } catch (Exception e) {
            System.err.println("Lỗi");
            this.uiFont = Font.font(20);
            this.gameOverFont = Font.font(40);
        }

    }

    public void render(GraphicsContext gc, int width, int height, int score, int lives, GameState state) {
        if (backgroundImage != null) {
            gc.drawImage(backgroundImage, 0, 0, width, height);
        } else {
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, width, height);
        }

        if (state == GameState.READY || state == GameState.RUNNING) {
            if (paddle != null) {
                paddle.render(gc);
            }

            if (ball != null) {
                ball.render(gc);
            }
        }
        for (Brick brick : bricks) {
            brick.render(gc);
        }

        gc.setFill(Color.WHITE);
        gc.setFont(uiFont);


        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText("Score: " + score, 10, 30);

        gc.setTextAlign(TextAlignment.RIGHT);
        gc.fillText("Lives: ".concat(String.valueOf(lives)), width - 10, 30);

        gc.setTextAlign(TextAlignment.CENTER);


        if (state == GameState.READY) {
            gc.setFill(Color.YELLOW);
            gc.fillText("Click to Start", width / 2.0, height / 2.0);
        }
        else if (state == GameState.GAME_OVER) {
            gc.setFont(gameOverFont);
            gc.setFill(Color.RED);
            gc.fillText("GAME OVER", width / 2.0, height / 2.0);
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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import java.util.List;
import java.util.ArrayList;
import javafx.scene.text.FontWeight;

public class GameUI {
    private Paddle paddle;
    private Ball ball;
    private Image backgroundImage;
    private Image heartImage;
    private List<Brick> bricks;
    private Font uiFont;
    private Font gameOverFont;
    private Font titleFont;
    private List<PowerUp> powerUps;

    public GameUI() {
        this.bricks = new ArrayList<>();

        try {
            this.uiFont = Font.font("Verdana", 20);
            this.gameOverFont = Font.font("Verdana", 40);
        } catch (Exception e) {
            System.err.println("Lỗi");
            this.uiFont = Font.font(20);
            this.gameOverFont = Font.font(40);
            this.titleFont = Font.font(60);
        }
    }

    public void render(GraphicsContext gc, int width, int height, int score, int lives, GameState state, boolean isMusicMuted) {
        if (backgroundImage != null) {
            gc.drawImage(backgroundImage, 0, 0, width, height);
        } else {
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, width, height);
        }
        switch (state) {
            case MENU:
                renderMenu(gc, width, height);
                break;
            case SETTINGS:
                renderSettings(gc, width, height, isMusicMuted);
                break;
            case HELPS:
                renderHelps(gc, width, height);
                break;
            default:
                renderGame(gc, width, height, score, lives, state);
                break;
        }
    }

    private void renderMenu(GraphicsContext gc, int width, int height) {
        double centerX = width / 2.0;

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(titleFont); // (Sử dụng font lớn đã sửa)
        gc.setFill(Color.WHITE);
        gc.fillText("ARKANOID", centerX, 150);

        gc.setFont(uiFont);

        gc.setFill(Color.WHITE);
        gc.fillText("START ARKANOID", centerX, 300);

        gc.setFill(Color.WHITE);
        gc.fillText("HELPS", centerX, 350);

        gc.setFill(Color.WHITE);
        gc.fillText("SETTINGS", centerX, 400);

        gc.setFill(Color.WHITE);
        gc.fillText("EXIT", centerX, 450);
    }

    private void renderGame(GraphicsContext gc, int width, int height, int score, int lives, GameState state) {
        if (state == GameState.READY || state == GameState.RUNNING || state == GameState.PAUSED) {
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

        for (PowerUp powerUp : powerUps) {
            powerUp.render(gc);
        }

        gc.setFill(Color.WHITE);
        gc.setFont(uiFont);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText("Score: " + score, 10, 30);
        if (heartImage != null) {
            int heartWidth = 25, heartHeight = 25, padding = 5;
            int startX = width - 10 - heartWidth;
            int yPos = 10;
            for (int i = 0; i < lives; i++) {
                int xPos = startX - (i * (heartWidth + padding));
                gc.drawImage(heartImage, xPos, yPos, heartWidth, heartHeight);
            }
        } else {
            gc.setTextAlign(TextAlignment.RIGHT);
            gc.fillText("Lives: ".concat(String.valueOf(lives)), width - 10, 30);
        }

        gc.setTextAlign(TextAlignment.CENTER);
        if (state == GameState.READY) {
            gc.setFill(Color.YELLOW);
            gc.fillText("Click to Start", width / 2.0, height / 2.0);
        } else if (state == GameState.GAME_OVER) {
            gc.setFont(gameOverFont);
            gc.setFill(Color.RED);
            gc.fillText("GAME OVER", width / 2.0, height / 2.0);
        } else if (state == GameState.PAUSED) {
            gc.setFont(gameOverFont);
            gc.setFill(Color.CYAN);
            gc.fillText("PAUSED", width / 2.0, height / 2.0);
        }
    }

    private void renderSettings(GraphicsContext gc, int width, int height, boolean isMusicMuted) {
        double centerX = width / 2.0;

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(gameOverFont);
        gc.setFill(Color.WHITE);
        gc.fillText("SETTINGS", centerX, 150);

        gc.setFont(uiFont);
        String musicStatus = isMusicMuted ? "[ OFF ]" : "[ ON ]";
        gc.fillText("Music: " + musicStatus, centerX, 300);

        gc.setFont(uiFont);
        gc.setFill(Color.YELLOW);
        gc.fillText("BACK", centerX, 450);
    }

    private void renderHelps(GraphicsContext gc, int width, int height) {
        double centerX = width / 2.0;

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(gameOverFont); // Dùng font lớn
        gc.setFill(Color.WHITE);
        gc.fillText("HELPS", centerX, 150);

        gc.setFont(uiFont);
        gc.setFill(Color.WHITE);
        gc.fillText("Move mouse to control the paddle", centerX, 250);
        gc.fillText("Click mouse to launch ball", centerX, 300);
        gc.fillText("Press 'P' to pause the game", centerX, 350);

        gc.setFont(uiFont);
        gc.setFill(Color.YELLOW);
        gc.fillText("BACK", centerX, 450);
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
    }

    public void setHeartImage(Image image) {
        this.heartImage = image;
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
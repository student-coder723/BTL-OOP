import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Arkanoid extends Application {
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

    private List<Brick> bricksList;

    private GameUI gameUI;
    private Paddle paddle;
    private Ball ball;
    private Image backgroundImage;
    private Image paddleImage;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Arkanoid Game");

        Pane root = new Pane();
        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        backgroundImage = ResourceLoader.loadImage("/Background/Background.png");
        paddleImage = ResourceLoader.loadImage("/Paddle/a.png");

        gameUI = new GameUI();
        paddle = new Paddle(SCENE_WIDTH / 2 - 50, SCENE_HEIGHT - 40, 100, 20, 5, paddleImage);
        ball = new Ball(SCENE_WIDTH / 2, SCENE_HEIGHT / 2, 20, 1, 1, -1);

        bricksList = new ArrayList<>();
        initBricks();

        gameUI.setBackgroundImage(backgroundImage);
        gameUI.setPaddle(paddle);
        gameUI.setBall(ball);
        gameUI.setBricks(bricksList);

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                ball.update();
                gameUI.render(gc, SCENE_WIDTH, SCENE_HEIGHT);
            }
        };

        gameLoop.start();
        primaryStage.show();
    }

    private void initBricks() {
        int brickRows = 5;
        int brickCols = 10;
        int brickWidth = 60;
        int brickHeight = 20;
        int padding = 10;
        int offsetTop = 50;
        int offsetLeft = 60;

        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {

                int x = offsetLeft + j * (brickWidth + padding);
                int y = offsetTop + i * (brickHeight + padding);

                if ((i + j) % 2 == 0) {
                    bricksList.add(new NormalBrick(x, y, brickWidth, brickHeight));
                } else {
                    bricksList.add(new StrongBrick(x, y, brickWidth, brickHeight));
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

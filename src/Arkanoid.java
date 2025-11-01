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
    private GameLogic gameLogic;
    private InputHandler inputHandler;
    private Paddle paddle;
    private Ball ball;
    private Image backgroundImage;
    private Image paddleImage;
    private Image ballImage;

    private Image brickImage1;
    private Image brickImage2;
    private Image brickImage3;
    private Image brickImage4;
    private Image brickImage5;

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

        loadResources();

        gameUI = new GameUI();
        paddle = new Paddle(SCENE_WIDTH / 2 - 50, SCENE_HEIGHT - 40, 100, 20, 5, paddleImage);
        ball = new Ball(SCENE_WIDTH / 2, SCENE_HEIGHT / 2, 20, 2, 1, -1, SCENE_WIDTH, SCENE_HEIGHT, ballImage);
        bricksList = new ArrayList<>();

        gameLogic = new GameLogic(ball, paddle, bricksList, SCENE_HEIGHT);
        inputHandler = new InputHandler(scene, paddle, SCENE_WIDTH, gameLogic);

        initBricks();

        gameUI.setBackgroundImage(backgroundImage);
        gameUI.setPaddle(paddle);
        gameUI.setBall(ball);
        gameUI.setBricks(bricksList);

        inputHandler.registerHandlers();

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameLogic.update();
                gameUI.render(gc, SCENE_WIDTH, SCENE_HEIGHT);
            }
        };

        gameLoop.start();
        primaryStage.show();
    }

    private void loadResources() {
        backgroundImage = ResourceLoader.loadImage("/Background/Background.png");
        paddleImage = ResourceLoader.loadImage("/Paddle/a.png");
        ballImage = ResourceLoader.loadImage("/Ball/ball.png");

        brickImage1 = ResourceLoader.loadImage("/Brick/normal brick1.png");
        brickImage2 = ResourceLoader.loadImage("/Brick/normal brick2.png");
        brickImage3 = ResourceLoader.loadImage("/Brick/normal brick3.png");
        brickImage4 = ResourceLoader.loadImage("/Brick/normal brick4.png");
        brickImage5 = ResourceLoader.loadImage("/Brick/normal brick5.png");
    }

    private void initBricks() {
        int brickRows = 5;
        int brickCols = 7;
        int brickWidth = 60;
        int brickHeight = 20;
        int padding = 5;
        int offsetTop = 50;
        int offsetLeft = 60;

        Image[] brickImages = {brickImage1, brickImage2, brickImage3, brickImage4, brickImage5};

        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {

                int x = offsetLeft + j * (brickWidth + padding);
                int y = offsetTop + i * (brickHeight + padding);

                Image currentImage = brickImages[i % 5];

                bricksList.add(new NormalBrick(x, y, brickWidth, brickHeight, currentImage));
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

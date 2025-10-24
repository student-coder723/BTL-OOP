import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arkanoid extends Application {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private List<Brick> bricks = new ArrayList<>();

    private Paddle paddle;
    private Ball ball;
    private Image background;
    private Image paddleImage;
    private Image ballImage;
    private Image brickImage1;
    private Image brickImage2;
    private Image brickImage3;
    private Image brickImage4;
    private Image brickImage5;

    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Arkanoid Game");

        try {
            background = new Image(getClass().getResourceAsStream("/Background.jpg"));
            paddleImage = new Image(getClass().getResourceAsStream("/Paddle.png"));
            ballImage = new Image(getClass().getResourceAsStream("/Ball.png"));
            brickImage1 = new Image(getClass().getResourceAsStream("/Brick_1.png"));
            brickImage2 = new Image(getClass().getResourceAsStream("/Brick_2.png"));
            brickImage3 = new Image(getClass().getResourceAsStream("/Brick_3.png"));
            brickImage4 = new Image(getClass().getResourceAsStream("/Brick_4.png"));
            brickImage5 = new Image(getClass().getResourceAsStream("/Brick_5.png"));
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        Pane root = new Pane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        paddle = new Paddle(WIDTH/2 - 50, HEIGHT- 50,100, 20, 10, paddleImage);
        ball = new Ball(WIDTH/2 - 10, HEIGHT/2- 10, 20,2, 1, -1, ballImage);
        initBrick();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        renderGame(gc);

        scene.setOnMouseMoved(e -> {
            paddle.setX((int) e.getX() - paddle.getWidth() / 2);
        });

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateGame();
                renderGame(gc);
            }
        };

        gameLoop.start();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void updateGame() {
        paddle.update();
        ball.update();

        checkCollisions();
    }

    private void checkCollisions() {
        if (ball.checkCollision(paddle) && ball.getDirectionY() > 0) {
            ball.reverseDirectionY();
            ball.setY(paddle.getY() - ball.getHeight());
        }
        for (Brick brick : bricks) {
            if (!brick.isDestroyed() && ball.checkCollision(brick)) {
                ball.reverseDirectionY();
                break;
            }
        }
    }

    private void initBrick() {
        int brickWidth = 70;
        int brickHeight = 25;
        int padding = 0;
        int setTop = 50;
        int setLeft = 50;

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 10; col++) {
                int x = setLeft + col * (brickWidth + padding);
                int y = setTop + row * (brickHeight + padding);

                int type = random.nextInt(5);

                switch (type) {
                    case 0:
                        bricks.add(new NormalBrick(x, y, brickWidth, brickHeight, brickImage1));
                        break;
                    case 1:
                        bricks.add(new NormalBrick(x, y, brickWidth, brickHeight, brickImage2));
                        break;
                    case 2:
                        bricks.add(new NormalBrick(x, y, brickWidth, brickHeight, brickImage3));
                        break;
                    case 3:
                        bricks.add(new NormalBrick(x, y, brickWidth, brickHeight, brickImage4));
                        break;
                    case 4:
                        bricks.add(new NormalBrick(x, y, brickWidth, brickHeight, brickImage5));
                        break;
                }
            }
        }
    }

    private void renderGame(GraphicsContext gc) {
        if (background != null) {
            gc.drawImage(background, 0, 0, WIDTH, HEIGHT);
        } else {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0 ,WIDTH, HEIGHT);
        }

        paddle.render(gc);
        ball.render(gc);

        for (Brick brick : bricks) {
            brick.render(gc);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
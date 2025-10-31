import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

    private GameUI gameUI;
    private Paddle paddle;

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

        gameUI = new GameUI();
        paddle = new Paddle(SCENE_WIDTH / 2 - 50, SCENE_HEIGHT - 40, 100, 20, 5);

        gameUI.setPaddle(paddle);

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameUI.render(gc, SCENE_WIDTH, SCENE_HEIGHT);
            }
        };

        gameLoop.start();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

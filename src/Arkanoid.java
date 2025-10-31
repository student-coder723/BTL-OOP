import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Arkanoid extends Application {


    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 600;

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

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, SCENE_WIDTH, SCENE_WIDTH);
            }
        };

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

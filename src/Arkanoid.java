import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Arkanoid extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Image background;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Arkanoid Game");

        try {
            background = new Image(getClass().getResourceAsStream("/background.jpg"));
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
            background = null;
        }

        Pane root = new Pane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        renderGame(gc);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void renderGame(GraphicsContext gc) {
        if (background != null) {
            gc.drawImage(background, 0, 0, WIDTH, HEIGHT);
        } else {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0 ,WIDTH, HEIGHT);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
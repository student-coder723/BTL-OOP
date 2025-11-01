import javafx.scene.Scene;

public class InputHandler {
    private final Scene scene;
    private final Paddle paddle;
    private final int sceneWidth;
    private final GameLogic gameLogic;

    public InputHandler(Scene scene, Paddle paddle, int sceneWidth, GameLogic gameLogic) {
        this.scene = scene;
        this.paddle = paddle;
        this.sceneWidth = sceneWidth;
        this.gameLogic = gameLogic;
    }

    public void registerHandlers() {
        scene.setOnMouseMoved(event -> {
            double mouseX = event.getX();
            int newX = (int) (mouseX - (paddle.getWidth() / 2));
            if (newX < 0) {
                newX = 0;
            }
            int maxPaddleX = (int) (this.sceneWidth - paddle.getWidth());
            if (newX > maxPaddleX) {
                newX = maxPaddleX;
            }
            paddle.setX(newX);
        });

        scene.setOnMouseClicked(event -> {
            gameLogic.startGame();
        });
    }
}

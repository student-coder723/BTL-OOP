package arkanoid.controller;

import arkanoid.model.GameState;
import arkanoid.model.Paddle;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;
import javafx.stage.Stage;

public class InputHandler {
    private final Scene scene;
    private final Paddle paddle;
    private final int sceneWidth;
    private final GameLogic gameLogic;

    private final Stage stage;

    public InputHandler(Scene scene, Stage stage, Paddle paddle, int sceneWidth, GameLogic gameLogic) {
        this.scene = scene;
        this.stage = stage;
        this.paddle = paddle;
        this.sceneWidth = sceneWidth;
        this.gameLogic = gameLogic;
    }

    public void registerHandlers() {
        scene.setOnMouseMoved(event -> {
            GameState gameState = gameLogic.getGameState();
            if (gameState == GameState.RUNNING || gameState == GameState.READY) {
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
            }
        });

        scene.setOnMouseClicked(event -> {
            GameState gameState = gameLogic.getGameState();
            double x = event.getX();
            double y = event.getY();

            switch (gameState) {
                case MENU:
                    handleMenuClick(x, y);
                    break;
                case SETTINGS:
                    handleSettingsClick(x, y);
                    break;
                case HELPS:
                    handleHelpsClick(x, y);
                    break;
                case READY:
                    gameLogic.startGame();
                    break;
                case GAME_OVER:
                    gameLogic.resetGame();
                    break;
            }
        });

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.P) {
                gameLogic.Pause();
            }
        });
    }

    private void handleMenuClick(double x, double y) {
        int centerX = 400;
        int buttonWidth = 200;

        if (x > centerX - (buttonWidth/2) && x < centerX + (buttonWidth/2) && y > 280 && y < 310) {
            gameLogic.switchToReady();
        }

        if (x > centerX - (buttonWidth/2) && x < centerX + (buttonWidth/2) && y > 330 && y < 360) {
            gameLogic.switchToHelps();
        }

        if (x > centerX - (buttonWidth/2) && x < centerX + (buttonWidth/2) && y > 380 && y < 410) {
            gameLogic.switchToSettings();
        }

        if (x > centerX - (buttonWidth/2) && x < centerX + (buttonWidth/2) && y > 430 && y < 460) {
            Platform.exit();
        }
    }

    private void handleSettingsClick(double x, double y) {
        int centerX = 400;
        int buttonWidth = 200;

        if (x > centerX - (buttonWidth/2) && x < centerX + (buttonWidth/2) && y > 280 && y < 310) {
            gameLogic.toggleBackgroundMusic();
        }

        if (x > centerX - (buttonWidth/2) && x < centerX + (buttonWidth/2) && y > 430 && y < 460) {
            gameLogic.switchToMenu();
        }
    }

    private void handleHelpsClick(double x, double y) {
        int centerX = 400;
        int buttonWidth = 200;

        if (x > centerX - (buttonWidth/2) && x < centerX + (buttonWidth/2) && y > 430 && y < 460) {
            gameLogic.switchToMenu();
        }
    }
}
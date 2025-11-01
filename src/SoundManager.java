import javafx.scene.media.AudioClip;

import java.net.URL;

public class SoundManager {
    private AudioClip brickBreakSound;

    private AudioClip gameOverSound;

    public SoundManager() {
        brickBreakSound = ResourceLoader.loadAudioClip("/Sounds/hit.mp3");
        gameOverSound = ResourceLoader.loadAudioClip("/Sounds/losing sounds.mp3");
    }

    public void playBrickBreak() {
        if (brickBreakSound != null) {
            brickBreakSound.play();
        }
    }

    public void playGameOver() {
        if (gameOverSound != null) {
            gameOverSound.play();
        }
    }
}

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class SoundManager {
    private AudioClip brickBreakSound;

    private AudioClip gameOverSound;

    private MediaPlayer backgroundMusicPlayer;

    public SoundManager() {
        brickBreakSound = ResourceLoader.loadAudioClip("/Sounds/hit.mp3");
        gameOverSound = ResourceLoader.loadAudioClip("/Sounds/losing sounds.mp3");

        try {
            Media bgMusicMedia = ResourceLoader.loadMedia("/Sounds/background.mp3");
            if (bgMusicMedia != null) {
                backgroundMusicPlayer = new MediaPlayer(bgMusicMedia);
                backgroundMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            }
        }
        catch (Exception e) {
            System.err.println("Lỗi.");
            backgroundMusicPlayer = null;
        }
    }

    public void playMusic() {
        if (backgroundMusicPlayer != null) {
            backgroundMusicPlayer.play();
        }
    }

    public void stopMusic() {
        if (backgroundMusicPlayer != null) {
            backgroundMusicPlayer.stop();
        }
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
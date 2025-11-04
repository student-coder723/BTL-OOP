import javafx.scene.image.Image;
import java.io.InputStream;
import javafx.scene.media.AudioClip;
import java.net.URL;
import javafx.scene.media.Media;

public class ResourceLoader {
    public static Image loadImage(String path) {
        try {
            InputStream imageStream = ResourceLoader.class.getResourceAsStream(path);
            if (imageStream == null) {
                throw new NullPointerException("Error " + path);
            }
            return new Image(imageStream);
        } catch (Exception e) {
            System.err.println("Error");
            e.printStackTrace();
            return null;
        }
    }

    public static AudioClip loadAudioClip(String path) {
        try {
            URL resourceUrl = ResourceLoader.class.getResource(path);
            if (resourceUrl == null) {
                throw new NullPointerException("lỗi " + path);
            }
            return new AudioClip(resourceUrl.toExternalForm());
        }
        catch (Exception e) {
            System.err.println("Lỗi" + path);
            e.printStackTrace();
            return null;
        }
    }

    public static Media loadMedia(String path) {
        try {
            URL resourceUrl = ResourceLoader.class.getResource(path);
            if (resourceUrl == null) {
                throw new NullPointerException("lỖI: " + path);
            }
            return new Media(resourceUrl.toExternalForm());
        } catch (Exception e) {
            System.err.println("LỖI: " + path);
            e.printStackTrace();
            return null;
        }
    }
}
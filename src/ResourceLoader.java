import javafx.scene.image.Image;
import java.io.InputStream;

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
}
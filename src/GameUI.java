import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class GameUI {

    private Pane rootPane;

    public GameUI(Pane root) {
        this.rootPane = root;
    }

    public void addObject(Node node) {
        rootPane.getChildren().add(node);
    }

    public void removeObject(Node node) {
        rootPane.getChildren().remove(node);
    }
}
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Objects;

public class Ball {
    private double radius;

    public Ball() {
        this.radius = 10.0F;
    }

    public Circle drawBall() {
        Circle ball = new Circle(this.radius, Color.RED);
        ball.setLayoutX(400);
        ball.setLayoutY(550);
        return ball;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}

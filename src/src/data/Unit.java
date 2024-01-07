package data;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;

public class Unit extends Rectangle {
    private final int value;

    public Unit(int height) {
        this.value = height;
    }
    public int getValue() {
        return value;
    }
    public TranslateTransition move(double x) {
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(this);
        tt.setByX(x);
        tt.setDuration(javafx.util.Duration.minutes(0.2));
        return tt;
    }
}
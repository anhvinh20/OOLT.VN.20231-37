package data;

import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;

public class Unit extends Rectangle {
    private final int value;

    public Unit(int value, double width, double height) {
        this.value = value;
        // Đặt chiều cao và chiều rộng của hình chữ nhật
        this.setHeight(height);
        this.setWidth(width);

        // Đặt màu sắc hoặc các thuộc tính khác của hình chữ nhật nếu bạn muốn
        // this.setFill(Color.BLUE); // ví dụ, đặt màu là xanh
    }
    public int getValue() {
        return value;
    }
    public TranslateTransition move(double x) {
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(this);
        tt.setByX(x);
        tt.setDuration(javafx.util.Duration.millis(1000));
        return tt;
    }
}
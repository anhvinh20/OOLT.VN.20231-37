package algorithm;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import data.Unit;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    private double width;
    public static Color START_COLOR = Color.web("#2A3950");
    public static Color SELECT_COLOR = Color.web("#84B7FD");
    public static Color SORTED_COLOR = Color.web("#C6CEFF");
    
    ParallelTransition colorUnit(Unit[] arr, Color color, int...a) {
	    ParallelTransition pt = new ParallelTransition();
	    
	    for (int i = 0; i < a.length; i++) {
	      FillTransition ft = new FillTransition();
	      ft.setShape(arr[a[i]]);
	      ft.setToValue(color);
	      ft.setDuration(Duration.minutes(0.5));
	      pt.getChildren().add(ft);
	    }
	    return pt;
	  }
    
    ParallelTransition colorUnit(List<Unit> list, Color color) {
	    ParallelTransition pt = new ParallelTransition();
	    
	    for (Unit c : list) {
	      FillTransition ft = new FillTransition();
	      ft.setShape(c);
	      ft.setToValue(color);
	      ft.setDuration(Duration.minutes(0.5));
	      pt.getChildren().add(ft);
	    }

	    return pt;
	  }
    
    public Sort(double width) {
        this.width = width;
    }
    
    public double getWidth() {
        return width;
    }


    ParallelTransition swap(Unit[] arr, int i, int j) {
        ParallelTransition pt = new ParallelTransition();
        
        Unit tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        pt.getChildren().addAll(arr[i].move(width*(i - j)), arr[j].move(width*(j - i)));
        
        return pt;
    }
    public ArrayList<Transition> sorting(Unit[] arr) {
    	 return new ArrayList<>();
    }
}

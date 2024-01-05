import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ShellSort extends Sort{
	private static final Color SUB_COLOR = Color.GOLD;
	private ArrayList<Transition> transitions;
	
	public ShellSort(double DX) {
		super(DX);
		this.transitions = new ArrayList<>();
	}
	
	 private ParallelTransition colorCNodes(CNode[] arr, Color color, int end, int gap) {
		    ParallelTransition pt = new ParallelTransition();
		    
		    while(end >= 0) {
		    	  FillTransition ft = new FillTransition();
			      ft.setShape(arr[end]);
			      ft.setToValue(color);
			      ft.setDuration(Duration.millis(100));
			      pt.getChildren().add(ft);
			      end -= gap;
		    }
		    return pt;
		  }
	
	private void shellSort(CNode[] arr) {
		// Start with a big gap, then reduce the gap 
		for(int gap = arr.length/2; gap > 0; gap /= 2) {
			// Do a gapped insertion sort for this gap size. 
	        // The first gap elements a[0..gap-1] are already in gapped order 
	        // keep adding one more element until the entire array is 
	        // gap sorted  
			for(int i = gap; i < arr.length; i++) {
				 transitions.add(colorCNodes(arr, SUB_COLOR, i, gap));
				 for(int j = i;j >= gap; j -= gap) {
					 transitions.add(colorCNode(arr, SELECT_COLOR, j - gap, j));
					 if(arr[j-gap].getValue() > arr[j].getValue()) {
						 transitions.add(swap(arr,j-gap,j));
						 transitions.add(colorCNode(arr, SUB_COLOR, j - gap, j));
					 }
					 else {
						 transitions.add(colorCNode(arr, SUB_COLOR, j - gap, j));
						 break;
					 }
				 }
				 transitions.add(colorCNodes(arr, START_COLOR, i, gap));
			}
		}
	}
	
	@Override
	public ArrayList<Transition> sorting(CNode[] arr) {
		shellSort(arr);
		this.transitions.add(colorCNode(Arrays.asList(arr), SORTED_COLOR));
		return this.transitions;
	}

}

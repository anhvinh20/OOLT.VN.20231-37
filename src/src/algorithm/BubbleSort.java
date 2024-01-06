package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

import data.Unit;
import javafx.animation.Transition;

public class BubbleSort extends Sort {

  private boolean swapped;
  private ArrayList<Transition> transitions;

  public BubbleSort(double DX) {
	super(DX);  
    this.transitions = new ArrayList<>();
  }

  private ArrayList<Transition> compareUnit(Unit[] arr, int a, int b) {
    ArrayList<Transition> transitions = new ArrayList<>();

    transitions.add(colorUnit(arr, SELECT_COLOR, a, b));

    if (arr[a].getValue() > arr[b].getValue()) {
      transitions.add(swap(arr, a, b));
      swapped = true;
    } 

    transitions.add(colorUnit(arr, START_COLOR, a, b));

    return transitions;
  }

  private void bubbleSort(Unit[] arr) {
    for (int i = 0; i < arr.length; i++) {
      swapped = false;
      for (int j = 0; j < arr.length - 1 - i; j++) {
        this.transitions.addAll(compareUnit(arr, j, j + 1));
      }

      if (!swapped) {
        break;
      }
    }

  }

  @Override
  public ArrayList<Transition> sorting(Unit[] arr) {
    bubbleSort(arr);

    this.transitions.add(colorUnit(Arrays.asList(arr), SORTED_COLOR));

    return this.transitions;

  }

}

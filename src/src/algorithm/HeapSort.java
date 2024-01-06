package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

import data.Unit;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

public class HeapSort extends Sort {
  
  private static final Color ROOT_COLOR = Color.GOLD;
  private ArrayList<Transition> transitions;

  public HeapSort(double DX) {
	super(DX);  
    this.transitions = new ArrayList<>();
  }

  private void heapify(Unit[] arr, int i, int n) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int max = i;

    if (left < n && arr[max].getValue() < arr[left].getValue()) {
      max = left;
    }

    if (right < n && arr[max].getValue() < arr[right].getValue()) {
      max = right;
    }

    if (max != i) {
      transitions.add(swap(arr, i, max));
      heapify(arr, max, n);
    }

  }

  private void heapSort(Unit[] arr) {
    //build initial max heap
    transitions.add(colorUnit(selectSubTree(arr, arr.length), SELECT_COLOR));
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
      heapify(arr, i, arr.length);
    }
    transitions.add(colorUnit(selectSubTree(arr, arr.length), START_COLOR));

    //swap root node with final elt, heapify subarray
    for (int i = arr.length - 1; i > 0; i--) {
      transitions.add(colorUnit(arr, ROOT_COLOR, 0));
      transitions.add(swap(arr, 0, i));
      transitions.add(colorUnit(arr, START_COLOR, i));
      transitions.add(colorUnit(selectSubTree(arr, i), SELECT_COLOR));
      heapify(arr, 0, i);
      transitions.add(colorUnit(selectSubTree(arr, i), START_COLOR));
    }
  }

  private ArrayList<Unit> selectSubTree(Unit[] arr, int n) {
    ArrayList<Unit> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(arr[i]);
    }

    return list;
  }

  @Override
  public ArrayList<Transition> sorting(Unit[] arr) {
    heapSort(arr);

    transitions.add(colorUnit(Arrays.asList(arr), SORTED_COLOR));
    return transitions;
  }
}

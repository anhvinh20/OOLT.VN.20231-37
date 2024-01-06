package data;

import java.util.Random;

public class DataController {
    public Unit[] randomArr(int len) {
        Unit[] narr = new Unit[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            narr[i] = new Unit(rand.nextInt(500));
        }
        return narr;
    }
    public Unit[] createArr(int[] arr) {
        Unit[] narr = new Unit[arr.length];
        for (int i = 0; i < arr.length; i++) {
            narr[i] = new Unit(arr[i]);
        }
        return narr;
    }
}

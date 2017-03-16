package Arraysort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Created by alica on 2017-03-05.
 * Good luck, Commander!
 */
public class ArraysortTask extends RecursiveAction{
    private final float[] array;
    private final int low;
    private final int high;
    private static final int THRESHOLD = 10000;

    /**
     * Creates a {@code MergeSortTask} containing the array and the bounds of the array
     *
     * @param array the array to sort
     * @param low the lower element to start sorting at
     * @param high the non-inclusive high element to sort to
     */
    public ArraysortTask(float[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if(high - low <= THRESHOLD){
            //System.out.println(Thread.currentThread().getName() + ": Threshold met, sorting");
            Arrays.sort(array);
        } else {
            //System.out.println(Thread.currentThread().getName() + ": Threshold not met, forking");
            int middle = low + ((high - low) >> 1);
            // Execute the sub tasks and wait for them to finish
            invokeAll(new ArraysortTask(array, low, middle), new ArraysortTask(array, middle, high));
            // Then merge the results
            //merge(middle);
        }
    }

    /**
     * Merges the two sorted arrays this.low, middle - 1 and middle, this.high - 1
     * @param middle the index in the array where the second sorted list begins
     */
    private void merge(int middle){
        if(array[middle - 1] < array[middle]){
            //the arrays are already correctly sorted, so we can skip the merge
            return;
        }//if

        float[] copy = new float[high - low];
        System.arraycopy(array, low, copy, 0, copy.length);
        int copyLow = 0;
        int copyHigh = high - low;
        int copyMiddle = middle - low;

        for (int i = low, p = copyLow, q = copyMiddle; i < high; i++) {
            if(q >= copyHigh || (p < copyMiddle && copy[p] < copy[q]))
                array[i] = copy[p++];
            else
                array[i] = copy[q++];
        }//for
    }//merge
}//ArraysortTask

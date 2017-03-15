package Mergesort;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class MergesortTask extends RecursiveTask<float[]> {
    private float[] array;
    private int low;
    private int high;
    private static final int THRESHOLD = 10000;

    /**
     * Creates a {@code MergeSortTask} containing the array and the bounds of the array
     *
     * @param array the array to sort
     * @param low the lower element to start sorting at
     * @param high the non-inclusive high element to sort to
     */
    public MergesortTask(float[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected float[] compute() {
        if(high - low <= THRESHOLD)
            Arrays.sort(array);
        else{
            int middle = low + ((high - low) >> 1);

            // Execute the sub tasks and wait for them to finish
            //invokeAll(new MergesortTask(array, low, middle), new MergesortTask(array, middle, high));

            MergesortTask t1 = new MergesortTask(array, low, middle);
            MergesortTask t2 = new MergesortTask(array, middle, high);

            t1.fork();
            t2.compute();
            t1.join();

            // Then merge the results
            merge(middle);
        }//else
        return array;
    }//compute

    /**
     * Merges the two sorted arrays this.low, middle - 1 and middle, this.high - 1
     * @param middle the index in the array where the second sorted list begins
     */
    private void merge(int middle) {
        if (array[middle - 1] < array[middle])
            return; // the arrays are already correctly sorted, so we can skip the merge

        float[] copy = new float[high - low];
        System.arraycopy(array, low, copy, 0, copy.length);

        for(int i = low, p = 0, q = high - low; i < high; i++){
            if(q >= high - low || (p < high - low && copy[p] < copy[q]))
                array[i] = copy[p++];
            else
                array[i] = copy[q++];
        }//for
    }//merge
}//class
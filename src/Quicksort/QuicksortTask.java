package Quicksort;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class QuicksortTask extends RecursiveTask<float[]>{
    private float[] array;
    private int left;
    private int right;
    private static final int THRESHOLD = 10000;

    QuicksortTask(float[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }//Fork

    @Override
    protected float[] compute() {
        if(right - left < THRESHOLD){
            Arrays.sort(array, left, right + 1);
        }//if
        else{
            int pivotIndex = partition(array, left, right);
            //int middle = low + ((high - low) >> 1);

            QuicksortTask t1 = new QuicksortTask(array, left, pivotIndex);
            QuicksortTask t2 = new QuicksortTask(array, pivotIndex + 1, right);

            t1.fork();
            t2.compute();
            t1.join();
        }//else
        return array;
    }//compute

    private int partition(float[] a, int p, int r) {
        float x = a[p];
        int i = p-1;
        int j = r+1;

        while (true) {
            while (++i < r && a[i] < x);
            while (--j > p && a[j] > x);

            if (i < j) {
                float tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            } else {
                return j;
            }
        }
    }

    private int partition(int first, int last){
        float pivot = array[first];
        int up = first;
        int down = last;

        while(up < down){
            while(up < last && pivot >= array[up])
                up++;

            while(pivot < array[down])
                down--;

            if(up < down){
                float t = array[up];
                array[up] = array[down];
                array[down] = t;
            }
                //swap(up, down);
        }//while

        float t = array[up];
        array[up] = array[down];
        array[down] = t;
        //swap(first, down);
        return down;
    }//partition

    private void swap(int first, int last) {
        float t = array[first];
        array[first] = array[last];
        array[last] = t;
    }//swap
}//class

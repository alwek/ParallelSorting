package Quicksort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class QuicksortTask extends RecursiveAction{
    private float[] a;
    private int left;
    private int right;
    private static final int THRESHOLD = 10000;

    QuicksortTask(float[] a, int left, int right) {
        this.a = a;
        this.left = left;
        this.right = right;
    }//Fork

    @Override
    protected void compute() {
        if(right - left < THRESHOLD){
            Arrays.sort(a, left, right + 1);
        }//if
        else{
            int pivotIndex = partition(a, left, right);

            QuicksortTask t1 = new QuicksortTask(a, left, pivotIndex - 1);
            QuicksortTask t2 = new QuicksortTask(a, pivotIndex + 1, right);

            t1.fork();
            t2.compute();
            t1.join();
        }//else
    }//compute

    private int partition(float[] table, int first, int last){
        //System.out.println(table.length + " " + first + " " + last);
        float pivot = table[first];
        int up = first;
        int down = last;

        do{
            while(up < last && pivot >= table[up]){// pivot.compareTo(table[up])>= 0){ //Float.compare(pivot, table[up]) >= 0
                up++;
            }

            while(pivot < table[down]){// pivot.compareTo(table[down]) < 0){ //Float.compare(pivot, table[down]) < 0
                down--;
            }

            if(up < down)
                swap(up, down);

        }while(up < down);

        swap(first, down);
        return down;
    }//partition

    int partition2(float[] a, int p, int r) {
        int i = p - 1;
        float x = a[r];
        for (int j = p; j < r; j++) {
            if (a[j] < x) {
                i++;
                swap(a, i, j);
            }
        }
        i++;
        swap(a, i, r);
        return i;
    }

    void swap(float[] a, int p, int r) {
        float t = a[p];
        a[p] = a[r];
        a[r] = t;
    }

    private void swap(int first, int last) {
        float t = a[first];
        a[first] = a[last];
        a[last] = t;
    }//swap
}//class

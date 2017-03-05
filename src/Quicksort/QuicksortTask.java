package Quicksort;

import java.util.concurrent.RecursiveAction;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class QuicksortTask extends RecursiveAction{
    private float[] a;
    private int left;
    private int right;
    private static final int THRESHOLD = 1000000;

    QuicksortTask(float[] a, int left, int right) {
        this.a = a;
        this.left = left;
        this.right = right;
    }//Fork

    @Override
    protected void compute() {
        if(right - left < THRESHOLD){
            System.out.println(Thread.currentThread().getName() + ": Threshold met, sorting");
            Quicksort qSort = new Quicksort();
            qSort.sort(a);//(a, left, right + 1);
        }//if
        else{
            System.out.println(Thread.currentThread().getName() + ": Threshold not met, forking");
            int pivotIndex = partition(a, left, right);

            QuicksortTask t1 = new QuicksortTask(a, left, pivotIndex - 1);
            QuicksortTask t2 = new QuicksortTask(a, pivotIndex + 1, right);

            t1.fork();
            t2.compute();
            t1.join();
        }//else
    }//compute

    private int partition(float[] a, int p, int r) {
        int i = p - 1;
        float x = a[r];

        for(int j = p; j < r; j++){
            if(a[j] < x){
                i++;
                swap(a, i, j);
            }//if
        }//for

        i++;
        swap(a, i, r);
        return i;
    }//partition

    private void swap(float[] a, int p, int r) {
        float t = a[p];
        a[p] = a[r];
        a[r] = t;
    }//swap
}//class

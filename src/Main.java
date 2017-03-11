import Arraysort.ArraysortTest;
import Mergesort.MergesortTest;
import Quicksort.QuicksortTest;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class Main{
    public static void main(String[] args){
        /*
        QuicksortTest test = new QuicksortTest();
        test.testQuickSort();

        MergesortTest test2 = new MergesortTest();
        test2.testMergeSort();

        System.exit(0);
        */
        try{
            System.out.println("Calling garbage collection and waiting 2 seconds");
            System.gc();
            System.out.println("Starting tests");
            System.out.println();

            QuicksortTest qTest = new QuicksortTest();
            qTest.testQuickSortParallelism();

            /*
            System.out.println();
            System.out.println("Calling garbage collection and waiting 2 seconds");
            System.gc();
            System.out.println("Next test");
            System.out.println();

            MergesortTest mTest = new MergesortTest();
            mTest.testMergesortParallelism();

            System.out.println();
            System.out.println("Calling garbage collection and waiting 2 seconds");
            System.gc();
            System.out.println("Next test");
            System.out.println();

            ArraysortTest aTest = new ArraysortTest();
            aTest.testArraysortParallelism();
            */
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main

}//class

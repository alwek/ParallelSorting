import Arraysort.ArraysortTest;
import Mergesort.MergesortTest;
import Quicksort.QuicksortTest;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class Main{
    public static void main(String[] args){
        try{
            QuicksortTest qTest = new QuicksortTest();
            qTest.testQuickSortParallelism();

            System.out.println();
            System.out.println("Next test");
            System.out.println();

            MergesortTest mTest = new MergesortTest();
            mTest.testMergesortParallelism();

            System.out.println();
            System.out.println("Next test");
            System.out.println();

            ArraysortTest aTest = new ArraysortTest();
            aTest.testArraysortParallelism();
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main

}//class

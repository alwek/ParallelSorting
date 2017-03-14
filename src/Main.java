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
            //QuicksortTest qTest = new QuicksortTest();
            //qTest.testQuickSortParallelism();

            MergesortTest mTest = new MergesortTest();
            mTest.testMergesortParallelism();

            /*
            ArraysortTest aTest = new ArraysortTest();
            aTest.testArraysortParallelism();
            */
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main

}//class

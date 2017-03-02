package Quicksort;

import java.util.concurrent.Callable;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class QuicksortTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        try{
            QuicksortTest qTest = new QuicksortTest();
            qTest.setUp();

            System.out.println("Testing QuickSort");
            qTest.testNull();
            qTest.testEmpty();
            qTest.testSimpleElement();
            qTest.testSpecial();
            qTest.testQuickSort();
            qTest.testStandardSort();
        }//try
        catch(Exception e){
            System.out.println(e);
        }//catch
        return "Task Done";
    }//call
}//class

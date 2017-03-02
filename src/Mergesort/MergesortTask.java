package Mergesort;

import java.util.concurrent.Callable;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class MergesortTask implements Callable<String> {

    @Override
    public String call() throws Exception{
        try{
            MergesortTest mTest = new MergesortTest();
            mTest.setUp();

            System.out.println("Testing MergeSort");
            mTest.testNull();
            mTest.testEmpty();
            mTest.testSimpleElement();
            mTest.testSpecial();
            mTest.testMergeSort();
            mTest.testStandardSort();
        }//try
        catch(InterruptedException e){
            System.out.println(e);
        }//catch
        return "Task Done";
    }//call
}//class

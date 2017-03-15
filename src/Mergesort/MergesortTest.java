package Mergesort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class MergesortTest {
    private float[] numbers;
    private final static int SIZE = 100000000;

    public MergesortTest(){
        numbers = new float[SIZE];

        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = generator.nextFloat();
    }//setUp

    private boolean validate(float[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]){
                return false;
            }
        }
        return true;
    }//validate

    public void testMergesortParallelism() throws InterruptedException {
        ForkJoinPool fjPool = new ForkJoinPool(4);

        // Warm up, to get the JIT compiler going
        System.out.println("Preparing warm up");
        long start = System.currentTimeMillis();
        MergesortTask mergesortTask = new MergesortTask(numbers, 0, numbers.length - 1);
        fjPool.invoke(mergesortTask);
        System.out.println("Warm up completed, time: " + (System.currentTimeMillis() - start) + " ms");

        // Measuring
        for(int i = 0; i < 10; i++) {
            System.gc();
            Thread.sleep(500);

            System.out.println("Starting test " + (i+1));
            start = System.currentTimeMillis();
            mergesortTask = new MergesortTask(numbers, 0, numbers.length - 1);
            fjPool.invoke(mergesortTask);
            System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
        }//for
    }//testParallell
}//class
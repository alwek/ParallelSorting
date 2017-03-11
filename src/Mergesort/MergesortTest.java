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
    private final static int MAX = 100;

    public MergesortTest(){
        numbers = new float[SIZE];

        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = generator.nextInt(MAX);

    }//setUp

    public void testMergeSort() {
        long startTime = System.currentTimeMillis();

        Mergesort sorter = new Mergesort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1])
                System.out.println("Should not happen");
        }//for
    }//testMergeSort

    private boolean validate(float[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++)
            if (numbers[i] > numbers[i + 1])
                return false;

        return true;
    }//validate

    public void testMergesortParallelism(){
        ForkJoinPool fjPool = new ForkJoinPool();

        MergesortTask mergesortTask = new MergesortTask(numbers, 0, numbers.length - 1);
        System.out.println(Thread.currentThread().getName() + ": Starting FJP");

        long start = System.currentTimeMillis();
        fjPool.invoke(mergesortTask);

        System.out.println(Thread.currentThread().getName() + ": Time (ms): " + (System.currentTimeMillis() - start));
        System.out.println("Validated: " + validate(numbers));
        System.out.println("First: " + numbers[0] + " Middle: " + numbers[numbers.length/2] +" Last: " + numbers[numbers.length-1]);
    }
}//class
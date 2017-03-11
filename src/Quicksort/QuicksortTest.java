package Quicksort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class QuicksortTest{
    private float[] numbers;
    private final static int SIZE = 100000000;
    private final static int MAX = 100;

    public QuicksortTest(){
        numbers = new float[SIZE];
        Random generator = new Random();

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = generator.nextInt(MAX);
    }//quicksort

    public void testQuickSort() {
        long startTime = System.currentTimeMillis();

        Quicksort sorter = new Quicksort();
        sorter.sort(numbers);

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Quicksort " + elapsedTime);

        if (!validate(numbers))
            System.out.println("Should not happen");
    }//testQuickSort

    private boolean validate(float[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++)
            if (numbers[i] > numbers[i + 1])
                return false;

        return true;
    }//validate

    public void testQuickSortParallelism(){
        ForkJoinPool fjPool = new ForkJoinPool();

        QuicksortTask quicksortTask = new QuicksortTask(numbers, 0, numbers.length - 1);
        //QuicksortTask quicksortTask = new QuicksortTask(numbers);
        System.out.println(Thread.currentThread().getName() + ": Starting FJP");

        long start = System.currentTimeMillis();
        fjPool.invoke(quicksortTask);

        System.out.println(Thread.currentThread().getName() + ": Time (ms): " + (System.currentTimeMillis() - start));
        System.out.println("Validated: " + validate(numbers));
        System.out.println("First: " + numbers[0] + " Middle: " + numbers[numbers.length/2] + " Last: " + numbers[numbers.length-1]);
    }
}//class
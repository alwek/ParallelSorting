package Quicksort;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class QuicksortTest{
    private float[] numbers, numbers2;
    private final static int SIZE = 10000000;
    private final static int MAX = 100;

    public QuicksortTest(){
        numbers = new float[SIZE];
        numbers2 = new float[SIZE];

        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = generator.nextInt(MAX);
    }//quicksort

    public void testNull() {
        Quicksort sorter = new Quicksort();
        sorter.sort(null);
        System.out.println("Null test done");
    }//testNull

    public void testEmpty() {
        Quicksort sorter = new Quicksort();
        sorter.sort(new float[0]);
        System.out.println("Empty test done");
    }//testEmpty

    public void testSimpleElement() {
        Quicksort sorter = new Quicksort();
        float[] test = new float[1];
        test[0] = 5;
        sorter.sort(test);
        System.out.println("Simple Element test done");
    }//testSimpleElement

    public void testSpecial() {
        Quicksort sorter = new Quicksort();
        float[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        sorter.sort(test);
        if (!validate(test))
            System.out.println("Should not happen");

        System.out.println("Special test done");
    }//testSpecial

    public void testQuickSort() {
        long startTime = System.currentTimeMillis();
        numbers2 = numbers;

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
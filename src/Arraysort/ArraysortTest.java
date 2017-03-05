package Arraysort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by alica on 2017-03-05.
 * Good luck, Commander!
 */
public class ArraysortTest {
    private float[] numbers, numbers2;
    private final static int SIZE = 1000000;//00;
    private final static int MAX = 100;

    public ArraysortTest(){
        numbers = new float[SIZE];
        numbers2 = new float[SIZE];

        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = generator.nextInt(MAX);

        numbers2 = numbers;
    }//setUp

    public void testNull() {
        float[] nullArray = null;
        Arrays.sort(nullArray);
        System.out.println("Null test done");
    }//testNull

    public void testEmpty() {
        Arrays.sort(new float[0]);
        System.out.println("Empty test done");
    }//testEmpty

    public void testSimpleElement() {
        float[] test = new float[1];
        test[0] = 5;
        Arrays.sort(test);
        System.out.println("Simple Element test done");
    }//testSimpleElement

    public void testSpecial() {
        float[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        Arrays.sort(test);
        if(!validate(test))
            System.out.println("Should not happen");

        System.out.println("Special test done");
    }//testSpecial

    public void testArraySort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers2[i] > numbers2[i + 1])
                System.out.println("Should not happen");
        }//for
    }//testStandardSort

    private boolean validate(float[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++)
            if (numbers[i] > numbers[i + 1])
                return false;

        return true;
    }//validate

    public void testArraysortParallelism(){
        ForkJoinPool fjPool = new ForkJoinPool();

        ArraysortTask arraysortTask = new ArraysortTask(numbers, 0, numbers.length - 1);
        System.out.println(Thread.currentThread().getName() + ": Starting FJP");

        long start = System.currentTimeMillis();
        fjPool.invoke(arraysortTask);

        System.out.println(Thread.currentThread().getName() + ": Time (ms): " + (System.currentTimeMillis() - start));
        System.out.println("Validated: " + validate(numbers));
        System.out.println("First: " + numbers[0] + " Middle: " + numbers[numbers.length/2] +" Last: " + numbers[numbers.length-1]);
    }
}

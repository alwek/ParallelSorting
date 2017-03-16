package Quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class QuicksortTest{
    private float[] numbers, control;
    private final static int SIZE = 100000000;
    private final static int MAX = 100;

    public QuicksortTest(){
        numbers = new float[SIZE];
        Random generator = new Random();

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = generator.nextInt(MAX);//generator.nextFloat() * 100;

        control = numbers;
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
        for (int i = 0; i < numbers.length - 1; i++){
            if (numbers[i] > numbers[i + 1]){
                return false;
            }//if
        }//for

        return true;
    }//validate

    public void testQuickSortParallelism() throws InterruptedException {
        ForkJoinPool fjPool = new ForkJoinPool(4);
        QuicksortTask quicksortTask = new QuicksortTask(numbers, 0, numbers.length - 1);
        System.out.println(Thread.currentThread().getName() + ": Starting FJP QuickSort");

        long start = System.currentTimeMillis();
        fjPool.invoke(quicksortTask);

        System.out.println(Thread.currentThread().getName() + ": Time (ms): " + (System.currentTimeMillis() - start));
        System.out.println("Validated: " + validate(numbers));
        //System.out.println("First: " + numbers[0] + " Middle: " + numbers[numbers.length/2] + " Last: " + numbers[numbers.length-1]);

        Arrays.sort(control);
        if(control.equals(numbers))
            System.out.println("IT IS DEFINITYL SORTED");
        else
            System.out.println("IT IS NOT SORTED!!!!");
    }
}//class
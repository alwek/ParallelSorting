package Quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class QuicksortTest {
    private float[] numbers, numbers2;
    private final static int SIZE = 100000000;
    private final static int MAX = 100;

    public void setUp() throws Exception {
        numbers = new float[SIZE];
        numbers2 = new float[SIZE];

        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = generator.nextInt(MAX);
    }//setUp

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

    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers2);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Standard Java sort " + elapsedTime);
        if (!validate(numbers2))
            System.out.println("Should not happen");
    }//testStandardSort

    private boolean validate(float[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++)
            if (numbers[i] > numbers[i + 1])
                return false;

        return true;
    }//validate
}//class
package Mergesort;

import com.sun.scenario.effect.Merge;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class MergesortTest {
    private float[] numbers, numbers2;
    private final static int SIZE = 100000000;
    private final static int MAX = 100;

    public void setUp() throws Exception {
        numbers = new float[SIZE];
        numbers2 = new float[SIZE];

        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = generator.nextInt(MAX);

        numbers2 = numbers;
    }//setUp

    public void testNull() {
        Mergesort sorter = new Mergesort();
        sorter.sort(null);
        System.out.println("Null test done");
    }//testNull

    public void testEmpty() {
        Mergesort sorter = new Mergesort();
        sorter.sort(new float[0]);
        System.out.println("Empty test done");
    }//testEmpty

    public void testSimpleElement() {
        Mergesort sorter = new Mergesort();
        float[] test = new float[1];
        test[0] = 5;
        sorter.sort(test);
        System.out.println("Simple Element test done");
    }//testSimpleElement

    public void testSpecial() {
        Mergesort sorter = new Mergesort();
        float[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
        sorter.sort(test);
        if (!validate(test))
            System.out.println("Should not happen");

        System.out.println("Special test done");
    }//testSpecial

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

    public void testStandardSort() {
        long startTime = System.currentTimeMillis();
        Arrays.sort(numbers2);
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
}//class
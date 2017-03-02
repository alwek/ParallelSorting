package Quicksort;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class Quicksort{
    private float[] numbers;

    public void sort(float[] values){
        // check for empty or null array
        if (values == null || values.length == 0)
            return;

        this.numbers = values;
        quicksort(0, values.length - 1);
    }//sort

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        float pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }//if
        }//while

        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }//quicksort

    private void exchange(int i, int j) {
        float temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }//exchange
}//class
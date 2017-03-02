import Mergesort.MergesortTask;
import Quicksort.QuicksortTask;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */
public class Main{
    public static void main(String[] args){
        try{
            ForkJoinPool fjp = new ForkJoinPool();

            MergesortTask task1 = new MergesortTask();
            ForkJoinTask<String> fjt = ForkJoinTask.adapt(task1);
            fjp.invoke(fjt);
            System.out.println("Test is done: " + fjt.isDone());

            System.out.println();

            QuicksortTask task2 = new QuicksortTask();
            fjt = ForkJoinTask.adapt(task2);
            fjp.invoke(fjt);
            System.out.println("Test is done: " + fjt.isDone());
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main

}//class

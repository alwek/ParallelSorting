import Arraysort.ArraysortTest;
import Mergesort.MergesortTest;
import Quicksort.QuicksortTest;

/**
 * Created by alica on 2017-03-02.
 * Good luck, Commander!
 */

/**
 * The following code involved in this project is inspired by and based on
 * other tests and examples done before us.
 * http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
 * http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
 * http://www.concretepage.com/java/jdk7/example-of-forkjointask-in-java
 * http://www.java2s.com/Tutorials/Java/Java_Thread_How_to/Concurrent/Do_quick_sort_with_ForkJoinPool_and_RecursiveAction.htm
 * http://alvinalexander.com/java/jwarehouse/openjdk-8/jdk/src/share/sample/forkjoin/mergesort/MergeSort.java.shtml
 * http://softwareengineering.stackexchange.com/questions/146173/merge-sort-versus-quick-sort-performance
 * http://stackoverflow.com/questions/3425126/java-parallelizing-quick-sort-via-multi-threading
 * http://stackoverflow.com/questions/33884057/quick-sort-stackoverflow-error-for-large-arrays
 *
 * The testing structure is based on the given resources from the KTH Canvas page.
 */
public class Main{
    public static void main(String[] args){
        try{
            QuicksortTest qTest = new QuicksortTest();
            qTest.testQuickSortParallelism();

            //MergesortTest mTest = new MergesortTest();
            //mTest.testMergesortParallelism();

            //ArraysortTest aTest = new ArraysortTest();
            //aTest.testArraysortParallelism();
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//main

}//class
/*
referera till Amdahl's law i abstract, analys och slutsats.
Ta upp formel för den i bakgrunden.
byt bakgrund till theory, nämn principiellt hur varje sort fungerar
antal cores i tabellen
visa medelvärdet för varje test på kärna 1, 2 ...
bättre figurtext
ta inte med warmup i graferna och tabellerna

 */
package org.example.Utils;

import org.example.sort.InsertionSort.InsertionSort;
import org.example.sort.MergeSort.MergeSort;
import org.example.sort.MergeSort.MergeSort_Bottom_Up;
import org.example.sort.QuickSort.QuickSort;
import org.example.sort.SelectionSort;

public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for(int i = 1; i < arr.length; i ++)
            if(arr[i - 1].compareTo(arr[i]) > 0)
                return false;
        return true;
    }


    public static void sortTest(String sortname, Integer[] arr){

        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if(sortname.equals("InsertionSort")) {
            InsertionSort.insertionSort(arr);
        }
        else if(sortname.equals("InsertionSortBetter")) {
            InsertionSort.insertionSortBetter(arr);
        } else if (sortname.equals("MergeSort")) {
            MergeSort.mergeSort(arr);
        }
        else if (sortname.equals("MergeSort_Bottom_Up")) {
            MergeSort_Bottom_Up.mergeSortBottomUp(arr);
        } else if (sortname.equals("QuickSort")) {
            QuickSort.quickSort(arr);
            
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if(!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname + " failed");
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }
}

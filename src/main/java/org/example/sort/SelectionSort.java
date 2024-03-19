package org.example.sort;

import java.util.Arrays;

// 选择排序法
// 选择排序每次把最小的元素拿出来，再把剩余元素中最小的元素拿出来，为了不使用额外空间，可以进行原地排序。
public class SelectionSort {
    private SelectionSort(){}

    public static void sort(Integer[] arr) {
        // arr[0...i) 是有序的；arr[i...n) 是无序的
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;

            }

            swap(arr, i, minIndex);
        }
    }

    // 类型必须是可比较的
    public static <E extends Comparable<E>> void sortGeneric(E[] arr) {
        // arr[0...i) 是有序的；arr[i...n) 是无序的
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }


    private static <E> void swap(E[] arr, int i, int j){
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args) {
        Integer[] arrayNumber = { 2,8,5,9 };
        SelectionSort.sortGeneric(arrayNumber);
        Arrays.stream(arrayNumber).forEach(number -> System.out.print(number + " "));
    }
}

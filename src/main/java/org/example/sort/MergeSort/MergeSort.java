package org.example.sort.MergeSort;

import java.util.Arrays;
import org.example.Utils.ArrayGenerator;
import org.example.Utils.SortingHelper;

public class MergeSort {

    public static void mergeSort(Integer[] arr) {

        sort(arr, 0 , arr.length - 1);
    }

    private static void sort(Integer[] arr, int s, int e) {
        if(s >= e) return;
        // 加法可能会超出 int 类型能表达的范围
        int mid = s + (e - s) / 2;
        sort(arr, s, mid);
        sort(arr, mid + 1, e);
        merge(arr, s, mid, e);

    }

    // 优化1: 如果arr[mid] <= arr[mid + 1] 说明数组已经有序，不需要再次合并， 对于大部分有序的数组可以起到很大的优化
    private static void sortBetter(Integer[] arr, int s, int e) {
        if(s >= e) return;
        // 加法可能会超出 int 类型能表达的范围
        int mid = s + (e - s) / 2;
        sort(arr, s, mid);
        sort(arr, mid + 1, e);
        // 比较 如果左侧部分的最后一个元素小于右侧部分的第一个元素，说明数组已经有序
        if(arr[mid] > arr[mid + 1])
            merge(arr, s, mid, e);

    }

    // 合并两个有序的数组 arr[s ,mid] arr[mid + 1, e]
    private static void merge(Integer[] arr, int s, int mid, int e) {
        Integer[] temArray = Arrays.copyOfRange(arr, s, e + 1);
        // 指向临时数组两部分的起始点
        int i = s, j = mid + 1;
        // 注意临时数组是从 0 开始的，所以对比arr 有 s位置的偏移

        // 遍历整个数组，每次比较两部分较小的值给arr数组赋值
        for(int index = s; index <=e; index++) {
            int tempIndexLeft = i - s;
            int tempIndexRight = j - s;
            // 左侧部分遍历完了, 直接把右侧剩余的元素赋值给arr
            if( i > mid) {
                arr[index] = temArray[tempIndexRight]; j++;
            } else if ( j > e) {
                // 右侧部分遍历完了,直接把左侧剩余的的元素赋值给arr
                arr[index] = temArray[tempIndexLeft]; i++;
            } else if (temArray[tempIndexLeft] < temArray[tempIndexRight]) {
                arr[index] = temArray[tempIndexLeft]; i++;
            } else {
                arr[index] = temArray[tempIndexRight]; j++;
            }

        }

//        System.out.println("merge("+s+"，"+ mid+", "+ e +")：" + Arrays.toString(arr));
    }

    public static void main(String[] args){

        // 对比不同排序法的时间
        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOfRange(arr,0, arr.length);
        Integer[] arr3 = Arrays.copyOfRange(arr,0, arr.length);

        SortingHelper.sortTest("SelectionSort", arr);
        SortingHelper.sortTest("InsertionSort", arr2);
        SortingHelper.sortTest("MergeSort", arr3);

//        Integer[] arr = new Integer[]{8, 1, 5, 3, 2};

//        mergeSort(arr);

//        System.out.println(Arrays.toString(arr)); // 结果为0， 整数相除小数部分会被截掉。
    }
}

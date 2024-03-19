package org.example.sort.QuickSort;

import java.util.Arrays;
import org.example.Utils.ArrayGenerator;
import org.example.Utils.SortingHelper;

public class QuickSort {

    public static void quickSort(Integer[] arr) {
        sort(arr, 0, arr.length - 1);

    }


    private static void sort(Integer[] arr, int l, int r) {
        if(l >= r) return;
        // arr[l, p-1] <= arr[p] arr[p+1, r] > arr[p]

        int p = partitiion(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    private static int partitiion(Integer[] arr, int l, int r) {
        // arr[l +1, j] <= v; arr[j+1, i] >v

        int j = l; // j指向小于等于 l指向的元素的区间结尾
        // 注意从下一个开始比较
        for(int i = l + 1 ; i <= r; i ++) {
            if(arr[i] <= arr[l]) {
                // j 后移一位然后换位置，此时j 指向的元素仍然小于= l 指向的元素
                j ++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        // 返回标定点位置
        return j;
    }

    private static  void swap(Integer[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
//        int n = 10000;
//        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        Integer[] arr = {3,2,1,1,3,4,5,6,6,7,8,9,10};
        SortingHelper.sortTest("QuickSort", arr);
        System.out.println(Arrays.toString(arr));

    }
}

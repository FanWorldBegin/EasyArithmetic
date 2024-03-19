package org.example.sort.MergeSort;

import java.util.Arrays;
import org.example.Utils.ArrayGenerator;
import org.example.Utils.SortingHelper;

public class MergeSort_Bottom_Up {


    public static void mergeSortBottomUp(Integer[] arr) {

        sort(arr, 0 , arr.length - 1);

    }


    private static void sort(Integer[] arr, int s, int e) {
        // 第一步两个两个结合，然后比较大小，然后翻倍，四个四个结合比较大小
        for(int size = 1; size < arr.length; size += size ) {
            // 合并 [i, i + size - 1] 和 [i + sz, Math.min(i + sz + sz - 1, n - 1)]
            // i 每次向后移两个size的长度
            for(int i = 0; i < arr.length; i += size + size) {
                int maxLength = Math.min(i + size + size - 1, arr.length - 1);
                merge(arr, i, i + size - 1,  maxLength);
            }
            System.out.println("");
        }

    }


    // 合并两个有序的数组 arr[s ,mid] arr[mid + 1, e]
    private static void merge(Integer[] arr, int s, int mid, int e) {
        Integer[] temArray = Arrays.copyOfRange(arr, s, e + 1);
        // 指向临时数组两部分的起始点
        int i = s, j = mid + 1;
        // 注意临时数组是从 0 开始的，所以对比arr 有 s位置的偏移

        System.out.println("arr:" + Arrays.toString(arr) + " s：" + s + " mid: " + mid + " e：" + e);

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
    }


    // 自底向上的归并算法
    public static void main(String[] args) {
//        int n = 100000;
//        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//        SortingHelper.sortTest("MergeSort_Bottom_Up", arr);

          Integer[] arr = new Integer[]{8, 1, 5, 3, 2};

          mergeSortBottomUp(arr);

        System.out.println(Arrays.toString(arr));

    }
}

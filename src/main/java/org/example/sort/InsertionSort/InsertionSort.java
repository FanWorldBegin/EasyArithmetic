package org.example.sort.InsertionSort;

import org.example.Utils.ArrayGenerator;
import org.example.Utils.SortingHelper;
import org.example.Utils.Utils;

// 插入排序法
//插入排序法的思想是将一个元素逐个插入到已经排好序的序列中，最终得到一个有序序列
public class InsertionSort {
    public static void main(String[] args) {
//        Integer[] arr = {3,2,1};
        Integer[] arr = ArrayGenerator.generateRandomArray(10000, 10000);
        insertionSortBetter(arr);
        System.out.println("排序后的数组:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println("\n");
        SortingHelper.sortTest("InsertionSortBetter", arr);
//        SortingHelper.sortTest("InsertionSort", arr);
    }

    public static void insertionSort(Integer[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j >= 1; j--) {
                if(arr[j - 1] > arr[j])
                    Utils.swap(arr, j-1, j);
                else break;
            }
        }
    }

//    public static void insertionSortBetter(Integer[] arr) {
//        int n = arr.length;
//        for(int i = 0; i < n; i++) {
//            for(int j = i; j >= 1 && arr[j - 1] > arr[j]; j--) {
//                Utils.swap(arr, j-1, j);
//            }
//        }
//    }

    // 优化后的插入排序 : 找到应该插入的位置，其余的数据向后平移.
    // 优化2减少交换操作,改为赋值操作**
    // 把当前位置j 处的数据存下来 a， 和 j-- 比较，如果 j-- 处的数据比 a 大，
    // 则把 j - - 的数据赋值给 j, 查看 j -- -- 处的数据，
    // 如果 j --  -- 的数据比 j -- 大，则 把a 的值赋值给 j --
    public static void insertionSortBetter(Integer[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int currentValue = arr[i];
            int j = i;
            for(; j >= 1; j--) {
                if(arr[j-1] > currentValue) {
                    arr[j] = arr[j-1]; // 把 j-1 处的数据赋值给 j
                }
                else break; // 当前就是需要插入的位置
            }
            arr[j] = currentValue;
        }
    }

    public static void insertionSortBetter2(Integer[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int currentValue = arr[i];
            int j = i;
            for(; j >= 1 && arr[j-1] > currentValue; j--) {
                arr[j] = arr[j-1]; // 把 j-1 位置元素向后移动一位
            }
            arr[j] = currentValue;
        }
    }

}

package org.example.sort.MergeSort;

import java.util.Arrays;
import org.example.Utils.ArrayGenerator;
import org.example.Utils.SortingHelper;
// Merge中创建了一个临时数组，每次递归都会创建一个新的临时数组，这样会造成大量的内存开销
public class MergeSort_memory {

    public static void mergeSort(Integer[] arr) {
        // 优化： 申请一个临时数组，避免在递归中重复申请空间
        Integer[] temArray = Arrays.copyOf(arr, arr.length);
        sort(arr, 0 , arr.length - 1, temArray);
    }

    private static void sort(Integer[] arr, int s, int e, Integer[] temArray) {
        if(s >= e) return;
        // 加法可能会超出 int 类型能表达的范围
        int mid = s + (e - s) / 2;
        sort(arr, s, mid, temArray);
        sort(arr, mid + 1, e, temArray);
        merge(arr, s, mid, e, temArray);

    }

    // 合并两个有序的数组 arr[s ,mid] arr[mid + 1, e]
    private static void merge(Integer[] arr, int s, int mid, int e, Integer[] temArray) {
        // System.arraycopy 方法的参数：源数组，源数组的起始位置，目标数组，目标数组的起始位置，要复制的数组元素的数量
        System.arraycopy(arr, s, temArray, s, e - s + 1);
        // 把arr[s, e] 复制到temArray[s, e]， 此时在临时数组中就不存在偏移量了，位置和arr一样

        // 指向临时数组两部分的起始点
        int i = s, j = mid + 1;

        // 遍历整个数组，每次比较两部分较小的值给arr数组赋值
        for(int index = s; index <=e; index++) {
            int tempIndexLeft = i - s;
            int tempIndexRight = j - s;
            // 左侧部分遍历完了, 直接把右侧剩余的元素赋值给arr
            if( i > mid) {
                arr[index] = temArray[j]; j++;
            } else if ( j > e) {
                // 右侧部分遍历完了,直接把左侧剩余的的元素赋值给arr
                arr[index] = temArray[i]; i++;
            } else if (temArray[i] < temArray[j]) {
                arr[index] = temArray[i]; i++;
            } else {
                arr[index] = temArray[j]; j++;
            }

        }

//        System.out.println("merge("+s+"，"+ mid+", "+ e +")：" + Arrays.toString(arr));
    }

    public static void main(String[] args){

        Integer[] arr = new Integer[]{8, 1, 5, 3, 2};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr)); // 结果为0， 整数相除小数部分会被截掉。


    }
}

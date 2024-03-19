package org.example.sort.MergeSort.Leetcode;


//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
public class Solution {
    // 两次 for 循环，时间复杂度 O(n^2)
    private int reverseNumber = 0;
    public int reversePairEasy(int[] nums) {
        int res = 0;
        for(int i =0; i < nums.length; i++)
            for(int j = i + 1; j < nums.length; j++)
                if(nums[i] > nums[j]) res ++;

        return res;
    }
//
    // 使用归并排序法思路来解决问题
    public int reversePairWithMerge(int[] nums) {
        // 开辟存放临时数组的空间
        int[] tem = new int[nums.length];
        reverseNumber = 0;
        sort(nums, 0, nums.length - 1, tem);
        return reverseNumber;
    }


    private void sort(int[] arr, int s, int e, int[] tem) {
        // 递归结束条件，分割到只有一个元素
        if(s >= e) return;

        int mid = s + (e - s) /2;

        sort(arr, s, mid, tem);
        sort(arr,mid + 1, e, tem);
        merge(arr, s, mid, e, tem);
    }

    private void merge(int[] arr, int s, int mid, int e,  int[] tem) {
        // arrcopy 方法的参数：源数组，源数组的起始位置，目标数组，目标数组的起始位置，要复制的数组元素的数量
        System.arraycopy(arr, s, tem, s, e - s + 1);

        int i = s, j = mid + 1;
        for(int k = s; k <= e; k++) {

            if(i > mid) {
                arr[k] = tem[j]; j++;
            } else if (j > e ) {
                arr[k] = tem[i]; i++;
            } else if (tem[i] > tem[j]) {
                arr[k] = tem[j]; j++;
                //左侧数据比右侧的大， 形成逆序对
                reverseNumber += mid - i + 1;
            } else {
                arr[k] = tem[i]; i++;
            }

        }

    }




    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        Solution solution = new Solution();
        System.out.println("逆序对的个数：" + solution.reversePairWithMerge(nums));
    }

}


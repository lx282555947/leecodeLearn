package com.learn.leecode.algorithm.sort;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    /**
     * 以一个基准点将数据分成两部分，小于基准点的部分和大于基准点的部分
     */
    public static int partition(int[] nums, int left, int right) {
        //采用第一个点，作为基准点
//        final int point = nums[left];
        //随机用一个数据作为基准点
        final int length = right - left;
        Random random = new Random();
        int pivot = left + random.nextInt(length);
        int point = nums[pivot];
        nums[pivot] = nums[left];
        while (left < right) {
            //首先从尾部开始，如果尾部元素大于基准点，则和移动至首部元素
            //如果尾部元素小于基准点，则尾部元素索引减一
            while (left < right) {
                if (nums[right] < point) {
                    nums[left] = nums[right];
                    left++;
                    break;
                } else {
                    right--;
                }
            }
            //如果尾部元素移动到了首部，则首部开始进行同样的校验
            //如果首部元素小于基准点，则加一，否则将首部元素移动至尾部
            while (left < right) {
                if (nums[left] > point) {
                    nums[right] = nums[left];
                    right--;
                    break;
                } else {
                    left++;
                }
            }
        }
        nums[left] = point;
        return left;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left < 0 || right < 0 || left >= right) {
            return;
        }
        //分治
        final int partition = partition(nums, left, right);
        //左边快排
        quickSort(nums, left, partition - 1);
        //右边快排
        quickSort(nums, partition + 1, right);
    }
}

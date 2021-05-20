package com.learn.leecode.algorithm.findKthLargest;

import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {3,2,1,5,6,4};
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
//        int max = findKthLargest(nums, 2);
//        System.out.println(m
//        ax);
        final int kthLargest = findKthLargest(nums1, 2);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static void compareMax(int i, int j, int[] nums) {
        if (nums[i] < nums[j]) {
            final int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void compareMin(int i, int j, int[] nums) {
        if (nums[i] > nums[j]) {
            final int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static int quickSelect(int[] nums, int low, int high, int index) {
        //分而治之
        final int partionIndex = partion(nums, low, high);
        if (partionIndex == index) {
            return nums[index];
        } else {
            return partionIndex < index ? quickSelect(nums, partionIndex + 1, high, index) : quickSelect(nums, low, partionIndex - 1, index);
        }
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low < 0 || high < 0 || low >= high) {
            return;
        }
        //分而治之
        final int partionIndex = partion(nums, low, high);
        // 前半部分递归
        quickSort(nums, low, partionIndex - 1);
        // 后半部分递归
        quickSort(nums, partionIndex + 1, high);
    }

    public static int partion(int[] nums, int low, int high) {
        final int length = high - low + 1;
        //随机一个分界点
        Random random = new Random();
//        System.out.println(low);
//        System.out.println(high);
        if (length == 1) {
            return low;
        }
        final int randomIndex = random.nextInt(length-1) + low;
        int point = nums[randomIndex];
        nums[randomIndex] = nums[low];
        while (low < high) {
            //从尾部开始，如果尾部的数值比零界点要大，则high--
            while (low < high) {
                if (nums[high] >= point) {
                    high--;
                } else {
                    nums[low] = nums[high];
                    low++;
                    break;
                }
            }
            while (low < high) {
                if (nums[low] <= point) {
                    low++;
                } else {
                    nums[high] = nums[low];
                    high--;
                    break;
                }
            }
        }
        nums[low] = point;
        return high;
    }
}

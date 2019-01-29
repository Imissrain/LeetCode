package Array;

import java.util.Random;

/**
 * 384. 打乱数组
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
/*
* 用一个辅助数组来存初始值 shuffle的时候 在原地用倒序 每次都是用当前i和后面的i swap 每次swap的i都是不一样的
* */
public class ShuffleanArray {
    private int[] arr;
    private int[] template;
    public ShuffleanArray(int[] nums) {
        template=nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return template;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random=new Random();
        arr=new int[template.length];
        for(int i=0;i<template.length;i++){
            arr[i]=template[i];
        }
        for(int i=0;i<arr.length;i++){
            //nextInt生成一个介于[0,i+1)的随机值 包含0而不包含i+1
            swap(arr,i,random.nextInt(i+1));
        }
        return arr;
    }
    private void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}

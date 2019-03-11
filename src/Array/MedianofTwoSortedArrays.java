package Array;

/**
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
@SuppressWarnings("all")
/*
    倒序归并 然后在数组里求中位数即可 记得求中位数要除2.0 否则会当成int返回
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int index = arr.length - 1;
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        double ans = 0.0;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                arr[index--] = nums1[i--];
            } else {
                arr[index--] = nums2[j--];
            }
        }
        while (i >= 0) {
            arr[index--] = nums1[i--];
        }
        while (j >= 0) {
            arr[index--] = nums2[j--];
        }
        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return (arr[0] + arr[1]) / 2.0;
        } else {
            int idx = arr.length / 2;
            if (arr.length % 2 == 0) {
                return (arr[idx] + arr[idx - 1]) / 2.0;
            } else {
                return arr[idx];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}

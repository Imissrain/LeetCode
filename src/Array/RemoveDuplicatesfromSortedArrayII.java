package Array;

/**
 * 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定 nums = [1,1,1,2,2,3],
 * <p>
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * <p>
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
/*
把问题不要想的太复杂，很多问题其实可以很巧妙的解决，刚开始走了弯路 这道题维护一个从0
开始的i，然后遍历数组 因为给定了有序数组 当我们当前的val大于了前两位的i则说明是刚好出现两次的
或者是当i小于2的时候 就向数组中添加  最后return i即可
*/
public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums){
            if(i<2 || num>nums[i-2]){
                nums[i++]=num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(removeDuplicates(nums));
    }
}

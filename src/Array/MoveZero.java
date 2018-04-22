package Array;
/**
 *移动零
 * 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
 *
 * 例如， 定义 nums = [0, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
 *
 * 注意事项:
 *
 * 必须在原数组上操作，不要为一个新数组分配额外空间。
 * 尽量减少操作总数。
 */

@SuppressWarnings("all")
public class MoveZero {
    //index=0 从头开始遍历 如果非0则插入 count记录插入次数
    public void moveZeroes(int[] nums) {
        if(nums.length==0)
            return;
        int index=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];
                count++;
            }
            continue;
        }
        for(int i=count;i<nums.length;i++)
            nums[i]=0;
    }
}

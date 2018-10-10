package Greedy;

/**
 * 55. 跳跃游戏
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * @author gkyan
 */
@SuppressWarnings("all")
public class canJump {
    public static boolean canJump(int[] nums) {
        //贪心策略 数组长度唯1返回true 声明一个跳跃步数值 每跳一次步数减一 nums[i+1]值大于当前pos时 更新pos=nums[i]+1 补偿消耗
        if(nums.length==1)
            return true;
        int len = nums.length-1;
        int pos=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length;) {
            if(nums[i]>pos)
                pos=nums[i];
            if(pos==0)
                return false;
            if(pos<nums[i+1])
                pos=nums[i+1]+1;
            i++;
            pos--;
            if(i==len)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int num[]={1};
        System.out.println(canJump(num));
    }
}

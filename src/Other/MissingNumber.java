package Other;
/**
 * 缺失数字
 * 给出一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 案例 1
 *
 * 输入: [3,0,1]
 * 输出: 2
 *
 *
 * 案例 2
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 *
 * 注意事项:
 * 您的算法应该以线性复杂度运行。你能否仅使用恒定的额外空间复杂度来实现它？
 * */
@SuppressWarnings("all")
public class MissingNumber {
    //有点傻逼说实话
    public static int missingNumber(int[] nums) {
//        if(nums.length==1&&nums[0]==0)
//            return 1;
//        if(nums.length==1&&nums[0]==1)
//            return 0;
        int sum=0;
        int max=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int Max=0;
        for(int i=0;i<=max;i++){
            Max+=i;
        }
        return Max-sum;
    }
    //求和公式减去当前sum
    public int missingNumber1(int[] nums) {
        int sum = 0;
        int length = nums.length;
        for(int i=0; i<length; i++) {
            sum += nums[i];
        }
        return (length*(length+1))/2-sum;
    }
    public static void main(String[] args) {
        int arr[]={0,1};
        System.out.println(missingNumber(arr));
    }
}

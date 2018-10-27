package BackTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 78. 子集
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 * @author gkyan
 */
@SuppressWarnings("all")
public class Subsets {
    //dfs 从0开始 申请一个标记数组 来确定当前index是否加入 然后dfs  因为ans是静态的 每次调用要clear
    public static List<List<Integer>> ans=new ArrayList<List<Integer>>();
    public static boolean[]v =new boolean[100];
    public static void dfs(int index,int nums[]){
        if(index>=nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(v[i]){
                    list.add(nums[i]);
                }
            }
            ans.add(list);
            return;
        }
        v[index]=true;
        dfs(index+1,nums);
        v[index]=false;
        dfs(index+1,nums);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ans.clear();
        dfs(0,nums);
        return ans;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets.toString());
    }
}

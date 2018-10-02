package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个没有重复数字的序列，返回其所有可能的全排列。

 示例:

 输入: [1,2,3]
 输出:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 * @author gkyan
 */
@SuppressWarnings("all")
public class permute {
    //先将nums[0]加入到List<List<Integer>>中 然后从i=1开始 每次都建立一个新的临时tmpans 将nums[0]到nums[i]的值分别插入到每个List<List<Integer>>中
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(nums.length==0 || nums==null)
            return ans;
        List<Integer>  fuck=new ArrayList<>();
        fuck.add(nums[0]);
        ans.add(fuck);
        for(int i=1;i<nums.length;i++){
            List<List<Integer>> tmpans=new ArrayList<>();
            for(int j=0;j<=i;j++){
                for(List<Integer> integers:ans){
                    List<Integer> tmplist=new ArrayList<>(integers);
                    tmplist.add(j,nums[i]);
                    tmpans.add(tmplist);
                }
            }
            ans=tmpans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        System.out.println(permute(arr));
    }
}

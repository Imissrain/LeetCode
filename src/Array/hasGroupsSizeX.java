package Array;

import java.util.Arrays;

/**
 * 914. 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。

 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

 每组都有 X 张牌。
 组内所有的牌上都写着相同的整数。
 仅当你可选的 X >= 2 时返回 true。



 示例 1：

 输入：[1,2,3,4,4,3,2,1]
 输出：true
 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 示例 2：

 输入：[1,1,1,2,2,2,3,3]
 输出：false
 解释：没有满足要求的分组。
 示例 3：

 输入：[1]
 输出：false
 解释：没有满足要求的分组。
 示例 4：

 输入：[1,1]
 输出：true
 解释：可行的分组是 [1,1]
 示例 5：

 输入：[1,1,2,2,2,2]
 输出：true
 解释：可行的分组是 [1,1]，[2,2]，[2,2]

 提示：

 1 <= deck.length <= 10000
 0 <= deck[i] < 10000
 * @author gkyan
 */
@SuppressWarnings("all")
public class hasGroupsSizeX {
    //周赛A题 先桶然后找出最小的 然后桶中每个元素和min进行GCD 看结果是否小于2
    public static int GCD(int a, int b) {
        if(b==0)
            return a;
        return a % b == 0 ? b : GCD(b, a % b);
    }
    public static boolean hasGroupsSizeX(int[] deck) {
        int arr[]=new int[10005];
        for(int i=0;i<deck.length;i++){
            arr[deck[i]]++;
        }
        boolean flag=true;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                min=Math.min(arr[i],min);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                if(arr[i]<2)
                    return false;
                if(GCD(min,arr[i])<2){
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int []arr={1,1,1,1,2,2,2,2,2,2};
        System.out.println(hasGroupsSizeX(arr));
    }
}

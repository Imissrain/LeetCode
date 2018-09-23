package Array;

import java.util.Arrays;

/**
 *908. 最小差值 I
 *给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。

 在此过程之后，我们得到一些数组 B。

 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。



 示例 1：

 输入：A = [1], K = 0
 输出：0
 解释：B = [1]
 示例 2：

 输入：A = [0,10], K = 2
 输出：6
 解释：B = [2,8]
 示例 3：

 输入：A = [1,3,6], K = 3
 输出：0
 解释：B = [3,3,3] 或 B = [4,4,4]


 提示：

 1 <= A.length <= 10000
 0 <= A[i] <= 10000
 0 <= K <= 10000
 * @author gkyan
 */
@SuppressWarnings("all")
public class smallestRangeI {
    //- -周赛去晚了 就剩20分钟了  先排序 看他最大最小值差如果小于2K 说明可以通过K来让他平衡 返回0 如果大于2k 那么最后的最小差就是数组差减去2K
    public int smallestRangeI(int[] A, int K) {
        int arr[]=A;
        Arrays.sort(arr);
        if(arr[arr.length-1]-arr[0]>K*2)
            return arr[arr.length-1]-arr[0]-K*2;
        return 0;
    }

}

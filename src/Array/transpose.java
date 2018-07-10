package Array;
/**
 * 868. 转置矩阵
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * */
@SuppressWarnings("all")
public class transpose {
    public int[][] transpose(int[][] A) {
        //如果是n*n的矩阵 直接转置即可
        if(A.length==A[0].length){
            for(int i=0;i<A.length;i++){
                for(int j=i+1;j<A[0].length;j++){
                    A[i][j]^=A[j][i];
                    A[j][i]^=A[i][j];
                    A[i][j]^=A[j][i];
                }
            }
            return A;
        }

        //如果行列不等 申请新数组 行列重新调换 将其重新反转即可
        else {
            int B[][]=new int[A[0].length][A.length];
            for(int i=0;i<B.length;i++){
                for(int j=0;j<B[0].length;j++){
                    B[i][j]=A[j][i];
                }
            }
            return B;
        }
    }
}

package Array;

/**
 * 59. 螺旋矩阵 II
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

 示例:

 输入: 3
 输出:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 * @author gkyan
 */
public class generateMatrix {
    public int[][] generateMatrix(int n) {
        //控制上下左右边界
        int ans[][]=new int[n][n];
        int maxVal=n*n;
        int val=1;
        int rowBegin=0;
        int rowEnd=n-1;
        int colBegin=0;
        int colEnd=n-1;
        while(val<=maxVal){
            for(int i=colBegin;i<=colEnd;i++)
                ans[rowBegin][i]=val++;
            rowBegin++;
            for(int i=rowBegin;i<=rowEnd;i++)
                ans[i][colEnd]=val++;
            colEnd--;
            for(int i=colEnd;i>=colBegin;i--)
                ans[rowEnd][i]=val++;
            rowEnd--;
            for(int i=rowEnd;i>=rowBegin;i--)
                ans[i][colBegin]=val++;
            colBegin++;
        }
        return ans;
    }
}

package DynamicProgromming;

import java.util.Arrays;

/**
 * 64. 最小路径和
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * */
@SuppressWarnings("all")
public class minPathSum {
    public static int minPathSum(int[][] grid) {
        //根据 i j取值的不同 判断 ij都大于0时 等于上方和左方的最小值
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i>0&&j>0)
                    grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
                else if(i>0&&j==0)
                    grid[i][j]+=grid[i-1][j];
                else if(i==0&&j>0)
                    grid[i][j]+=grid[i][j-1];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int grid[][]={
                {1,3,1},{1,5,1},{4,2,1}
        };
        System.out.println(minPathSum(grid));
    }
}

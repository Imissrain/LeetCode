package Array;

/**
 * 240. 搜索二维矩阵 II
 *
 *
 *
 *
 * 题目描述
 * 评论 (23)
 * 官方题解
 * 提交记录
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
/*
    因为每行是递增的 每列也是递增的 从左下角开始搜索 如果matrix[i][j]比target大，则向上走一行 如果俾target小就向右走一行 找到return
 */
@SuppressWarnings("all")
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
            int row=matrix.length;
            int col=matrix[0].length-1;
            int i=row-1,j=0;
            while(i>=0&&j<=col){
                if(matrix[i][j]==target)
                    return true;
                else if(matrix[i][j]>target)
                    i--;
                else if(matrix[i][j]<target)
                    j++;
            }
            return false;
    }

    public static void main(String[] args) {
        int arr[][]={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.err.println(new Searcha2DMatrixII().searchMatrix(arr,5));
    }
}

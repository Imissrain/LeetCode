package Array;

/**
 * 74. 搜索二维矩阵
 *
 *
 *
 *
 * 题目描述
 * 评论 (58)
 * 官方题解
 * 提交记录
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
/*
    先找到区间 然后在区间中进行二分
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int index=0;
        int row=matrix.length;
        int col=matrix[0].length;
        boolean isRow=false,isCol=false;
        for(;index<row;){
            if(target>matrix[index][col-1]){
                index++;
            }else {
                isRow=true;
                break;
            }
        }
        if(isRow){
            int left=0;
            int right=col-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(target>matrix[index][mid]){
                    left=mid+1;
                }else if(target<matrix[index][mid]){
                    right=mid-1;
                }else {
                    isCol=true;
                    break;
                }
            }
        }
        if(isRow&&isCol)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int arr[][]={
                {1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}
        };
        System.err.println(new Searcha2DMatrix().searchMatrix(arr,3));
    }
}

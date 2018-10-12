package Greedy;

/**
 * 861. 翻转矩阵后的得分
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * <p>
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * <p>
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * <p>
 * 返回尽可能高的分数。
 * 示例：
 * <p>
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 *
 * @author gkyan
 */
@SuppressWarnings("all")
public class matrixScore {
    //这个贪心思路就是 先保证最高位尽可能的大 把高位置1 然后判断每列 0的个数大于1的个数就reverse 最后计算二进制value要注意下标和指数对应关系
    public static int matrixScore(int[][] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0)
                reverse(A[i]);
        }
        for (int j = 0; j < A[0].length; j++) {
            int tmp[] = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                tmp[i] = A[i][j];
            }
            if (isNeedReverse(tmp)) {
                for (int k = 0; k < A.length; k++) {
                    if (A[k][j] == 0)
                        A[k][j] = 1;
                    else
                        A[k][j] = 0;
                }
            }
        }
        return getAns(A);
    }

    public static int getAns(int[][] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += getValue(A[i]);
        }
        return sum;
    }

    //计算每一行的二进制value
    public static int getValue(int[] A) {
        int value = 0;
        int len = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                len--;
                continue;
            } else {
                value += Math.pow(2, len);
                len--;
            }

        }
        return value;
    }

    //翻转
    public static void reverse(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1)
                A[i] = 0;
            else
                A[i] = 1;
        }
    }

    //是否需要翻转
    public static boolean isNeedReverse(int[] A) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                zero++;
            else
                one++;
        }
        return zero > one;
    }

    public static void main(String[] args) {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(new matrixScore().matrixScore(A));
    }
}

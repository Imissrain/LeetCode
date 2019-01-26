package Array;

/**
 * 11. 盛最多水的容器
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * @author gkyan
 */
@SuppressWarnings("all")
public class ContainerWithMostWater {
    /*
    暴力算面积 长为 ij 差值 高为ij中小的那一个
     */
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    /*
    双指针
     */
    public int maxArea2(int[] heighet) {
        int i = 0;
        int j = heighet.length - 1;
        int maxArea = (j - i) * Math.min(heighet[i], heighet[j]);
        while (i < j) {
            if (heighet[j] > heighet[i])
                i++;
            else
                j--;
            maxArea = Math.max(maxArea, (j - i) * Math.min(heighet[i], heighet[j]));
        }
        return maxArea;
    }
}

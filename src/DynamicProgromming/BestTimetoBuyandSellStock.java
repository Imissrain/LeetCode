package DynamicProgromming;

/**
 * 121. 买卖股票的最佳时机
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
@SuppressWarnings("all")
public class BestTimetoBuyandSellStock {
    /*
    version1:On2 暴力
     */
    public int maxProfit(int[] prices) {
        int max = -1;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max == -1 ? 0 : max;
    }

    /*
    version2: O1 一次扫描 记录最低谷  之后出现的最大峰即可
     */
    public int maxProfit2(int[] prices) {
        int minprice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minprice){
                //找到最小峰
                minprice=prices[i];
                //更新最大值
            }else if(prices[i]-minprice>maxProfit){
                maxProfit=prices[i]-minprice;
            }
        }
        return maxProfit;
    }
}

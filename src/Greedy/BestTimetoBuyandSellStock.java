package Greedy;

/**
 * 121. 买卖股票的最佳时机
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

 注意你不能在买入股票前卖出股票。

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 示例 2:

 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * @author gkyan
 */
@SuppressWarnings("all")
public class BestTimetoBuyandSellStock {
    //O(n2)
    public static int maxProfit1(int[] prices) {
        if(prices.length==0 || prices==null)
            return 0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                max=Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }

    //O(n) 维护min和max min从prices[0]开始
    public static int maxProfit(int[] prices) {
        if(prices.length==0 || prices==null)
            return 0;
        int max=0;
        int min=prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min)
                min=prices[i];
            else {
                if(max<prices[i]-min){
                    max=prices[i]-min;
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int []arr={7,1,7,2,10,4};
        System.out.println(maxProfit(arr));
    }
}

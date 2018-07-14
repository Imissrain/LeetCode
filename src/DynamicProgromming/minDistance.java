package DynamicProgromming;
/**
 * 72. 编辑距离
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * */
@SuppressWarnings("all")
public class minDistance {
    public static int minDistance(String word1, String word2) {
        //dp[i][j]代表第一个字符串从0带i  到第二个字符串从0到j  形成的子串的编辑距离 相等的话无需操作 不等的话 插入:dp[i][j-1]+1 替换:dp[i-1][j-1]+1 删除:dp[i-1][j]+1 取最小值
        if(word1.length()==0)
            return word2.length();
        if(word2.length()==0)
            return word1.length();
        int dp[][]=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;
        for(int i=1;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=word2.length();j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1="abc";
        String word2="bbc";
        System.out.println(minDistance(word1,word2));
    }
}

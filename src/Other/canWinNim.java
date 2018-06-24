package Other;
/**
 * 292. Nim游戏
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 你和你的朋友，两个人一起玩 Nim游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
 *
 * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: false
 * 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * */
@SuppressWarnings("all")
public class canWinNim {
    public boolean canWinNim(int n) {
        if(n<4)
            return true;
        if(n%4==0)
            return false;
        else
            return true;
    }
}

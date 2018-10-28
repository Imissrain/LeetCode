package Other;
/**
 * 657. 判断路线成圈
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。
 *
 * 移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。输出应为 true 或 false，表示机器人移动路线是否成圈。
 *
 * 示例 1:
 *
 * 输入: "UD"
 * 输出: true
 * 示例 2:
 *
 * 输入: "LL"
 * 输出: false
 * */
@SuppressWarnings("all")
public class RobotReturntoOrigin {
    public static boolean judgeCircle(String moves) {
        if(moves==null)
            return true;
        int u=0,d=0,l=0,r=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U')
                u++;
            if(moves.charAt(i)=='D')
                u--;
            if(moves.charAt(i)=='L')
                l++;
            if(moves.charAt(i)=='R')
                l--;

        }
        return u==0&&l==0;
    }

    public static void main(String[] args) {
        String s="UD";
        System.out.println(judgeCircle(s));
    }
}

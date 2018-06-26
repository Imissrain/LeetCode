package String;
/**
 *
 New Playground
 Imissrain

 557. 反转字符串中的单词 III
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 示例 1:

 输入: "Let's take LeetCode contest"
 输出: "s'teL ekat edoCteeL tsetnoc"
 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 * */
@SuppressWarnings("all")
public class reverseWordsIII {
    //自定义交换函数 然后将字符串分割成数组 逐个反转 当最后一个元素的时候跳出 再加上空格
    public static String reverseWords(String s) {
        String sb="";
        String[] split = s.split(" ");
        for(int i=0;i<split.length-1;i++){
            char[] chars = split[i].toCharArray();
            sb+=(revsers(chars,0,chars.length-1));
            sb+=" ";
        }
        sb+=(revsers(split[split.length-1].toCharArray(),0,split[split.length-1].length()-1));
        return sb;
    }
    //自定义交换函数
    public static String revsers(char []arr,int i,int j){
        while(i<j){
            char tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s="Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}

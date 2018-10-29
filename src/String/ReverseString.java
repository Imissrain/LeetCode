package String;
/**
 * 反转字符串
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 *
 * 示例：
 *
 * 输入：s = "hello"
 * 返回："olleh"
 * */
@SuppressWarnings("all")
public class ReverseString {
    //Stringbuffer直接反转
    public String reverseString(String s) {
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }
    //转换成char数组 两边反转 位运算
    public String reverseString1(String s){
        char[] chars = s.toCharArray();
        int i=0,j=chars.length-1;
        while(i<j){
           chars[i]^=chars[j];
           chars[j]^=chars[i];
           chars[i]^=chars[j];
           i++;
           j--;
        }
        return String.valueOf(chars);
    }
}

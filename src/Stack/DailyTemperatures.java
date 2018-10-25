package Stack;

import java.util.Arrays;

/**
 *
 * 739. 每日温度
 题目描述提示帮助提交记录社区讨论阅读解答
 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。

 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 * @author gkyan
 */
@SuppressWarnings("all")
public class DailyTemperatures {
    //On3 超时
    public int[] dailyTemperatures1(int[] temperatures) {
        if(temperatures.length==0)
            return temperatures;
        int []ans=new int[temperatures.length];
        boolean flag=false;
        for(int i=0;i<temperatures.length;i++){
            int temp=temperatures[i];
            int count=0;
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[j]>temp) {
                    count++;
                    ans[i]=count;
                    break;
                }
                else if(temperatures[j]<=temp){
                    for(int k=j;k<temperatures.length;k++){
                        flag=false;
                        if(temperatures[k]>temp){
                            flag=true;
                            break;
                        }
                        else
                            count++;
                    }
                        if(flag){
                            ans[i]=count+1;
                            break;
                        }
                        else{
                            ans[i]=0;
                        }
                }
            }
        }
        return ans;
    }
//On2 找不到大的就++ 找到就赋值然后break
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length==0)
            return temperatures;
        int[] results = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            int days = 0;
            for(int j=i+1;j<temperatures.length;j++) {
                days++;
                if(temperatures[j]>temperatures[i]) {
                    results[i]=days;
                    break;
                }
            }
        }
        return results;
    }
    public static void main(String[] args) {
        int[] ints = new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
}

package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

/*
    找规律呗 第一行和第二行特殊处理 从第三行开始 首尾都是1 然后对应index的值是上一层list的index和index-1的值 注意取上层list的时候值要填对
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<0)
            return null;
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=1;i<=numRows;i++){
            List<Integer> list=new ArrayList<>(i);
            if(i==1){
                list.add(1);
                ans.add(list);
                continue;
            }else if(i==2){
                list.add(1);
                list.add(1);
                ans.add(list);
                continue;
            }else {
                for(int k=0;k<i;k++){
                    if(k==0|| k==i-1){
                        list.add(1);
                        continue;
                    }else {
                        System.out.println(ans.get(i-2).get(k));
                        System.out.println(ans.get(i-2).get(k-1));
                        list.add(k,ans.get(i-2).get(k)+ans.get(i-2).get(k-1));
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        int num=5;
        System.out.println(new PascalsTriangle().generate(num));
    }
}

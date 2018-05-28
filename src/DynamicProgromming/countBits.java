package DynamicProgromming;

import java.util.ArrayList;
import java.util.List;

/**
 * 338. Bit位计数
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个非负整数 num。 对于范围 0 ≤ i ≤ num 中的每个数字 i ，计算其二进制数中的1的数目并将它们作为数组返回。
 *
 * 示例：
 * 比如给定 num = 5 ，应该返回 [0,1,1,2,1,2].
 *
 * 进阶：
 *
 * 给出时间复杂度为O(n * sizeof(integer)) 的解答非常容易。 但是你可以在线性时间O(n)内用一次遍历做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？ 在c ++或任何其他语言中不使用任何内置函数（如c++里的 __builtin_popcount）来执行此操作。
 * */
@SuppressWarnings("all")
public class countBits {
    //n&=(n-1) 计算有多少个二进制1

    public int[] countBits(int num) {
        List<Integer> integerList=new ArrayList<>();
        for(int i=0;i<=num;i++){
            integerList.add(get_One(i));
        }
        int arr[]=new int[integerList.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=integerList.get(i);
        }
        return arr;
    }
    public int get_One(int num){
        int count=0;
        while (num>0){
            num&=(num-1);
            count++;
        }
        return count;
    }
}

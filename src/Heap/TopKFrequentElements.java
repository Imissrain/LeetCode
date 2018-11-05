package Heap;

import java.util.*;

/**
 * 347. 前K个高频元素
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]
 * @author gkyan
 */
@SuppressWarnings("all")
public class TopKFrequentElements {
    //先treemap 去重算出频率 然后用优先队列(即小顶堆) 进行判断 每次的key的value 大于根顶元素 就删除根顶元素然后 添加key  这里重写了compareaTo 创建优先队列如果不指定排序规则 默认的是排序key 因此我们要指定根据其value来排序 所以在构造方法中要声明排序规则
    public List<Integer> topKFrequent(int[] nums, int k) {
       TreeMap <Integer,Integer> map=new TreeMap<>();
       for(int num: nums){
           if(map.containsKey(num)){
               map.put(num,map.get(num)+1);
           }else {
               map.put(num,1);
           }
       }
       System.out.println(map.toString());
       PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
       for(int key: map.keySet()){
           if(priorityQueue.size()<k){
               priorityQueue.add(key);
           }else if(map.get(key)>map.get(priorityQueue.peek())){
               priorityQueue.remove();
               priorityQueue.add(key);
           }
       }
       List<Integer> ans=new ArrayList<>();
       while(!priorityQueue.isEmpty()){
           ans.add(priorityQueue.remove());
       }
       return ans;
    }

    public static void main(String[] args) {
        int nums[]={7,8,78,6,56,6,1,1,1,1,2,2,2,3,4,4,4,4,4,4,4,1,2,4,5,7,7,7,7,7,7,9,7,45};
        int k=5;
        System.out.println(new TopKFrequentElements().topKFrequent(nums,k));
    }
}

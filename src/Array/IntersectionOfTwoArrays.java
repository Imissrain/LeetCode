package Array;

import java.util.*;

/**
 * 两个数组的交集 II
 * 给定两个数组，写一个方法来计算它们的交集。
 *
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 *
 * 注意：
 *    输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *    我们可以不考虑输出结果的顺序。
 * 跟进:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
 * */
@SuppressWarnings("all")
public class IntersectionOfTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);//排序
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> list =new ArrayList<>();
        while(i<nums1.length&&j<nums2.length){//逐个比较 小了往前走
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        int arr[]=new int[list.size()];
        int index=0;
        for(Integer integer : list){
            arr[index++]=integer;
        }
        return arr;
    }
    public static void main(String[] args) {
        int nums1[]={1,2,2,1};
        int nums2[]={2,2};
        int[] intersect = intersect(nums1, nums2);
        for(int i=0;i<intersect.length;i++){
            System.out.println(intersect[i]);
        }
    }
}

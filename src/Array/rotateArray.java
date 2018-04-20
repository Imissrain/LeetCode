package Array;
/**将包含 n 个元素的数组向右旋转 k 步。

 例如，如果  n = 7,  k =3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。

 注意:

 尽可能找到更多的解决方案，这里最少有三种不同的方法解决这个问题。

 [显示提示]

 提示:

 要求空间复杂度为 O(1)
 * */
@SuppressWarnings("all")
public class rotateArray {
    //我tm把空间复杂度看成了时间复杂度
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reserve(nums,0,nums.length-1);
        reserve(nums,0,k-1);
        reserve(nums,k,nums.length-1);
    }
    public void reserve(int nums[],int i,int j){
        while(i<j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
    }

}

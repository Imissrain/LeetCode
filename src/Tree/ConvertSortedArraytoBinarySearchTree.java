package Tree;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
/*
    一颗二分搜索树的中序遍历结果刚好就是有序的 因此有序数组转换成二分搜索树并且还要是平衡的 所以想到二分法来取根节点
 */
public class ConvertSortedArraytoBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if(left>right)
            return null;
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,left,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,right);
        return root;
    }
}

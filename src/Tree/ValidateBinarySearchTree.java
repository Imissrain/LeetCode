package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*
    version1: 搜索树的概念 左右子树也是一个搜索树 并且都比当前节点的值小/大 因此需要维护左右子树的上下界 对左子树来说 上界时root.val 对右子树来说下界时root.val
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if(root==null)
            return true;
        if(min!=null&&root.val<=min.val||max!=null&&root.val>=max.val)
            return false;
        return isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);
    }


    /*
    version2：中序遍历 左根右 大小和搜索树大小排序一致 可以存到list中再进行判断
     */
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1))
                return false;
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}

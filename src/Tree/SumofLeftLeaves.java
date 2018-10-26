package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 404. 左叶子之和
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * */
public class SumofLeftLeaves {
    //难点在于左叶子节点的判断 当一个节点的左子树不为空 并且这个左子树的左右字数都为空即为叶子节点
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //递归
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    //层序非递归
    public int sumOfLeftLeaves1(TreeNode root) {
        if(root==null)
            return 0;
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.offer(root);
        TreeNode tmp;
        int ans=0;
        while(!linkedList.isEmpty()){
            tmp=linkedList.poll();
            if(tmp.left!=null&&tmp.left.left==null&&tmp.left.right==null)
                ans+=tmp.left.val;
            if(tmp.left!=null)
                linkedList.offer(tmp.left);
            if(tmp.right!=null)
                linkedList.offer(tmp.right);
            System.out.println(ans);
        }
        return ans;
    }
}

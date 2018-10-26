package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * */
@SuppressWarnings("all")
public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode tmp=null;
        int size=0;
        queue.offer(root);
        while(queue.isEmpty()==false){
            List<Integer> list=new ArrayList<>();
            size=queue.size();
            for(int i=0;i<size;i++){
                tmp=queue.poll();
                list.add(tmp.val);
                if(tmp.left!=null)
                    queue.offer(tmp.left);
                if(tmp.right!=null)
                    queue.offer(tmp.right);
            }
            res.add(list);
        }
       return res;
    }
}

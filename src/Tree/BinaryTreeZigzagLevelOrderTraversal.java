package Tree;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回锯齿形层次遍历如下：

 [
 [3],
 [20,9],
 [15,7]
 ]
 * @author gkyan
 */
@SuppressWarnings("all")
public class BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //先层序 然后根据相应的层reverse
        if(root==null)
            return Collections.emptyList();
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(queue.isEmpty()==false){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
            }
            ans.add(list);
        }
        for(int i=0;i<ans.size();i++){
            if(i%2==0){
                ;
            }else {
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
}

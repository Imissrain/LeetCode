package Tree;

import java.util.LinkedList;

/**
 *
 513. 找树左下角的值
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个二叉树，在树的最后一行找到最左边的值。

 示例 1:

 输入:

 2
 / \
 1   3

 输出:
 1


 示例 2:

 输入:

 1
 / \
 2   3
 /   / \
 4   5   6
 /
 7

 输出:
 7
 * */
@SuppressWarnings("all")
public class FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int findBottomLeftValue(TreeNode root) {
        //层序遍历 更新每层第一个节点的val
        if(root.left==null && root.right==null)
            return root.val;
        int ans=0;
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.offer(root);
        TreeNode tmp=null;
        while(linkedList.isEmpty()==false){
            int size=linkedList.size();
            for(int i=0;i<size;i++){
                tmp=linkedList.pop();
                if(i==0)
                    ans=tmp.val;
                if(tmp.left!=null)
                    linkedList.offer(tmp.left);
                if(tmp.right!=null)
                    linkedList.offer(tmp.right);
            }
        }
        return ans;
    }
}

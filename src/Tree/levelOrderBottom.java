package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * */
@SuppressWarnings("all")
public class levelOrderBottom {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //层序结果
        if(root==null)
            return new ArrayList<>();
        List <List<Integer>> lists=new ArrayList<List<Integer>>();
        LinkedList<TreeNode>linkedList=new LinkedList<>();
        linkedList.offer(root);
        TreeNode tmp;
        while(!linkedList.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=linkedList.size();
            for(int i=0;i<size;i++){
                tmp=linkedList.poll();
                list.add(tmp.val);
                if(tmp.left!=null)
                    linkedList.offer(tmp.left);
                if(tmp.right!=null)
                    linkedList.offer(tmp.right);
            }
            lists.add(list);
        }
        List <List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=lists.size()-1;i>=0;i--){
            ans.add(lists.get(i));
        }
        return ans;
    }

}

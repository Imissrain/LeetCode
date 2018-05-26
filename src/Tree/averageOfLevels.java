package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * */
@SuppressWarnings("all")
public class averageOfLevels {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //层序遍历的时候 维护每层的结果 然后返回List即可
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        if(root.left==null && root.right==null){
            List<Double> doubleList=new ArrayList<>();
            doubleList.add(root.val*1.0);
            return doubleList;
        }
        List<Double> doubleList=new ArrayList<>();
        LinkedList<TreeNode> treeNodeLinkedList=new LinkedList<>();
        treeNodeLinkedList.offer(root);
        TreeNode tmp=null;
        int count=0;
        double res=0;
        while(treeNodeLinkedList.isEmpty()==false){
          int size=treeNodeLinkedList.size();
            count=0;
            res=0;
          for(int i=0;i<size;i++){
              tmp=treeNodeLinkedList.pop();
              res+=tmp.val;
              count++;
              if(tmp.left!=null){
                  treeNodeLinkedList.offer(tmp.left);
              }
              if(tmp.right!=null){
                  treeNodeLinkedList.offer(tmp.right);
              }
          }
          doubleList.add(res/count);
        }
        return doubleList;
    }
}

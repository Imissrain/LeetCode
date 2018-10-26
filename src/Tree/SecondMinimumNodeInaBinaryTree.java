package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 671. 二叉树中第二小的节点
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 * */
@SuppressWarnings("all")
public class SecondMinimumNodeInaBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int findSecondMinimumValue(TreeNode root) {
        //先将所有节点保存到TreeSet中 然后输出第二个
        if(root==null)
            return -1;
        TreeSet<Integer> treeSet=new TreeSet<>();
        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.offer(root);
        while(!linkedList.isEmpty()){
            int size=linkedList.size();
            for(int i=0;i<size;i++){
                TreeNode tmp=linkedList.poll();
                treeSet.add(tmp.val);
                if(tmp.left!=null)
                    linkedList.offer(tmp.left);
                if(tmp.right!=null)
                    linkedList.offer(tmp.right);
            }
        }
        if(treeSet.size()==1)
            return -1;
        int count=0;
        for(Integer integer :treeSet){
            count++;
            if(count==1)
                return integer;
            System.out.println(integer);
        }
        return 0;
    }
}

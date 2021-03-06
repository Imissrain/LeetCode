package LinkList;

import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;

import java.util.*;

/**
 * 109. 有序链表转换二叉搜索树
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
@SuppressWarnings("all")

public class ConvertSortedListtoBinarySearchTree {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST(ListNode head) {
        return buildBinarySearchTree(head,null);
    }
    public TreeNode buildBinarySearchTree(ListNode start,ListNode end){
        //二叉搜索树的左右子树高度差绝对值不能大于1 所以根节点一定是链表的中间节点 先找根节点 然后左边右边分别递归即可
        if(start==end)
            return null;
        ListNode slow=start;
        ListNode fast=start;
        while(fast!=end && fast.next!=end){
            slow=slow.next;
            fast=fast.next.next;
        }
        TreeNode node =new TreeNode(slow.val);
        node.left=buildBinarySearchTree(start,slow);
        node.right=buildBinarySearchTree(slow.next,end);
        return node;
    }

}

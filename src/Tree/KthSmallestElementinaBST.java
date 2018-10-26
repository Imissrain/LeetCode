package Tree;

import java.util.*;

/**
 * 230. 二叉搜索树中第K小的元素
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个二叉搜索树，编写一个函数 KthSmallestElementinaBST 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 KthSmallestElementinaBST 函数？
 *
 * @author gkyan
 */
@SuppressWarnings("all")
public class KthSmallestElementinaBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        //二叉搜索树中序遍历结果就是他的顺序结果
        if (root == null || k == 0)
            return 0;
        List<Integer> integerList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || stack.isEmpty() == false) {
            while(tmp!=null){
                stack.push(tmp);
                tmp=tmp.left;
            }
            if(stack.isEmpty()==false){
                tmp= stack.pop();
                integerList.add(tmp.val);
                tmp=tmp.right;
            }
        }
        return integerList.get(k-1);
    }
}

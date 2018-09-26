package Tree;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 题目描述提示帮助提交记录社区讨论阅读解答
 根据一棵树的中序遍历与后序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 中序遍历 inorder = [9,3,15,20,7]
 后序遍历 postorder = [9,15,7,20,3]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7
 * @author gkyan
 */
@SuppressWarnings("all")
public class inorderPostorderBuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //和前中类似 递归解决
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0)
            return null;
        return build(inorder,postorder,postorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int[] inorder,int[] postorder,int postorderStart,int inorderStart,int inorderEnd){
        if(postorderStart<0 || inorderStart>inorderEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postorderStart]);
        int index=root.val;
        for(int i=inorderStart;i<=inorderEnd;i++){
            if(index==inorder[i]){
                index=i;
                break;
            }
        }
        root.left=build(inorder,postorder,postorderStart-(inorderEnd-index)-1,inorderStart,index-1);
        root.right=build(inorder,postorder,postorderStart-1,index+1,inorderEnd);
        return root;
    }
}

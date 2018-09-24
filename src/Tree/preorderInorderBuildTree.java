package Tree;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 题目描述提示帮助提交记录社区讨论阅读解答
 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]
 返回如下的二叉树：

 3
 / \
 9  20
 /  \
 15   7
 * @author gkyan
 */
@SuppressWarnings("all")
public class preorderInorderBuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //没咋看懂- -明天研究吧
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0)
            return null;
        return build(preorder,inorder,0,0,preorder.length-1);
    }
    public TreeNode build(int []preorder,int []inorder,int preStart,int inStart,int inEnd){
        if(preStart>preorder.length-1 || inStart>inEnd)
            return null;
        int index=0;
        TreeNode node=new TreeNode(preorder[preStart]);
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i]==node.val){
                index=i;
                break;
            }
        }
        node.left=build(preorder,inorder,preStart+1,inStart,index-1);
        node.right=build(preorder,inorder,preStart+index-inStart+1,index+1,inEnd);
        return node;
    }
}

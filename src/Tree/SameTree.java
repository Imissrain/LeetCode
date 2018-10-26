package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**100. 相同的树
 题目描述提示帮助提交记录社区讨论阅读解答
 给定两个二叉树，编写一个函数来检验它们是否相同。

 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

 示例 1:

 输入:       1         1
 / \       / \
 2   3     2   3

 [1,2,3],   [1,2,3]

 输出: true
 示例 2:

 输入:      1          1
 /           \
 2             2

 [1,2],     [1,null,2]

 输出: false
 示例 3:

 输入:       1         1
 / \       / \
 2   1     1   2

 [1,2,1],   [1,1,2]

 输出: false
 * */
@SuppressWarnings("all")
public class SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null && q!=null || p!=null && q==null)
            return false;
        //对两棵树同时进行层序遍历操作  分别判断两棵树的左右为空否
        LinkedList<TreeNode> ptree=new LinkedList();
        LinkedList<TreeNode> qtree=new LinkedList();
        ptree.offer(p);
        qtree.offer(q);
        while(!ptree.isEmpty() && !qtree.isEmpty()){
            TreeNode tmpp=ptree.poll();
            TreeNode tmpq=qtree.poll();
            if(tmpp.val!=tmpq.val)
                return false;
            else {
                if(tmpp.left==null && tmpq.left!=null || tmpp.right==null && tmpq.right!=null)
                    return false;
                if(tmpp.left!=null)
                    ptree.offer(tmpp.left);
                if(tmpp.right!=null)
                    ptree.offer(tmpp.right);
                if(tmpq.left!=null)
                    qtree.offer(tmpq.left);
                if(tmpq.right!=null)
                    qtree.offer(tmpq.right);
                if(ptree.size()!=qtree.size())
                    return false;
            }
        }
        return true;

    }

    //层序失败
//    public List<List<Integer>> getTreeNodeVal(TreeNode treeNode){
//        List<List<Integer>> list=new ArrayList<List<Integer>>();
//        LinkedList<TreeNode> queue=new LinkedList();
//        queue.offer(treeNode);
//        TreeNode tmp=null;
//        int size=0;
//        while(queue.isEmpty()==false){
//            List<Integer> tmplist=new ArrayList<>();
//            size=queue.size();
//            for(int i=0;i<size;i++){
//                tmp=queue.poll();
//                tmplist.add(tmp.val);
//                if(tmp.left!=null)
//                    queue.offer(tmp.left);
//                else
//                    queue.offer(tmp);
//
//                if(tmp.right!=null)
//                    queue.offer(tmp.right);
//                else
//                    queue.offer(tmp);
//            }
//            list.add(tmplist);
//        }
//        return list;
//    }
}

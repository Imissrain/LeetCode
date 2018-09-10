package Tree;

import java.util.Arrays;

/**
 * 307. 区域和检索 - 数组可修改
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * <p>
 * 示例:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 * <p>
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 *
 * @author gkyan
 */
@SuppressWarnings("all")
public class NumArray {
    //使用线段树 查询和修改都是Ologn的操作 btw线段树真恶心
    private SegmentTree<Integer> segmentTree;
    private interface Merger<E> {
        E merge(E a, E b);
    }

    //线段树模板
    private static class SegmentTree<E> {
        private E data[];
        private E tree[];
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger) {
            this.merger = merger;
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < data.length; i++)
                data[i] = arr[i];//复制数据
            /**
             * 对于一个叶节点为n的满二叉树来说 树的高度为x=log2n+1
             * 根据等比数列求出节点总和 sum=(1*(1-2^(log2n+2)))/1-2
             * 化简等于4n-1 约等于4n
             */
            tree = (E[]) new Object[arr.length * 4];//区间为n的数组 tree存储需要开4倍空间防止溢出
            buildSegmentTree(0, 0, data.length - 1);
        }

        /**
         * 在treeIndex的位置创建表示区间[l...r]的线段树
         *
         * @param treeIndex tree中的下标
         * @param l         左边界
         * @param r         右边界
         */
        private void buildSegmentTree(int treeIndex, int l, int r) {
            //区间长度为1 递归出口
            if (l == r) {
                tree[treeIndex] = data[l];
                return;
            }
            //计算左节点下标
            int leftTreeIndex = leftChild(treeIndex);
            //计算右节点下标
            int rightTreeIndex = rightChild(treeIndex);
            int mid = l + (r - l) / 2;
            //递归创建左节点
            buildSegmentTree(leftTreeIndex, l, mid);
            //递归创建右节点
            buildSegmentTree(rightTreeIndex, mid + 1, r);
            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        //get长度
        public int getSize() {
            return data.length;
        }

        //get值
        public E get(int index) {
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("Index is illegal");
            return data[index];
        }

        //左节点
        private int leftChild(int index) {
            return 2 * index + 1;
        }

        //右节点
        private int rightChild(int index) {
            return 2 * index + 2;
        }

        //查询
        public E query(int queryL, int queryR) {
            if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR)
                throw new IllegalArgumentException("Index is Illegal");

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        /**
         * 在ID为treeIndex为根的线段树中[l...r]的范围里查询区间queryL到queryR的值
         *
         * @param treeIndex tree中的节点
         * @param l         左区间
         * @param r         右区间
         * @param queryL    左查询端点
         * @param queryR    右查询端点
         * @return
         */
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {
            if (l == queryL && r == queryR)
                return tree[treeIndex];
            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (queryL >= mid + 1)
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            else if (queryR <= mid)
                return query(leftTreeIndex, l, mid, queryL, queryR);
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }

        public void set(int index, E e) {
            if (index < 0 || index >= data.length)
                throw new IllegalArgumentException("Index is illegal");
            data[index] = e;
            set(0, 0, data.length - 1, index, e);
        }

        /**
         * 线段树的区间更新 在更新后要记得重新计算父节点的值
         *
         * @param treeIndex tree中的节点
         * @param l         左区间
         * @param r         右区间
         * @param index     下标
         * @param e         值
         */
        private void set(int treeIndex, int l, int r, int index, E e) {
            if (l == r) {
                tree[treeIndex] = e;
                return;
            }
            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if (index >= mid + 1) {
                set(rightTreeIndex, mid + 1, r, index, e);
            } else {
                set(leftTreeIndex, l, mid, index, e);
            }
            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }
    }

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};

        NumArray numArray = new NumArray(nums);
        numArray.update(0, 1);
        System.out.println(numArray.sumRange(0, 1));

    }
}

package Array;

import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class KthLargestElementinanArray {


    /*
    version1: 用堆做 将数组转化成一个最大堆 然后取k-1次堆顶操作 最后返回堆顶元素即可
     */
    public int findKthLargest(int[] nums, int k) {
        class Array<E> {
            private E[] data;
            private int size;

            /**
             * 构造函数
             *
             * @param capacity
             */
            public Array(int capacity) {
                data = (E[]) new Object[capacity];
                size = 0;
            }

            public Array() {
                this(10);
            }

            public Array(E[] arr) {
                data = (E[]) new Object[arr.length];
                for (int i = 0; i < arr.length; i++) {
                    data[i] = arr[i];
                }
                size = arr.length;
            }

            public int getSize() {
                return size;
            }

            public int getCapacity() {
                return data.length;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public E get(int index) {
                if (index < 0 || index >= size) {
                    throw new IllegalArgumentException("越界访问");
                }
                return data[index];
            }

            public void set(int index, E e) {
                if (index < 0 || index >= size) {
                    throw new IllegalArgumentException("越界访问");
                }
                data[index] = e;
            }

            public boolean contains(E e) {
                for (int i = 0; i < size; i++) {
                    if (data[i].equals(e))
                        return true;
                }
                return false;
            }

            //找不到返回-1
            public int find(E e) {
                for (int i = 0; i < size; i++) {
                    if (data[i].equals(e))
                        return i;
                }
                return -1;
            }

            //返回删除元素
            public E remove(int index) {
                if (index < 0 || index >= size) {
                    throw new IllegalArgumentException("越界访问");
                }
                E ret = data[index];
                for (int i = index + 1; i < size; i++) {
                    data[i - 1] = data[i];
                }
                size--;
                data[size] = null;


                if (size == data.length / 4 && data.length / 2 != 0) {
                    resize(data.length / 2);
                }
                return ret;

            }

            public E removeFirst() {
                return remove(0);
            }

            public E getLast() {
                return get(size - 1);
            }

            public E getFirst() {
                return get(0);
            }

            public E removeLast() {
                return remove(size - 1);
            }

            public void addLast(E e) {
                add(size, e);
            }

            public void removeElement(E e) {
                int i = find(e);
                if (i != -1) {
                    remove(i);
                }
            }

            public void addFirst(E e) {
                add(0, e);
            }

            //定位插入
            public void add(int index, E e) {
                if (size == data.length) {
                    // TODO
                    resize(2 * data.length);
                }
                if (index < 0 || index > size) {
                    throw new IllegalArgumentException("插入失败");
                }
                for (int i = size - 1; i >= index; i--) {
                    data[i + 1] = data[i];
                }
                data[index] = e;
                size++;
            }

            private void resize(int newCapacity) {
                E[] newData = (E[]) new Object[newCapacity];
                for (int i = 0; i < size; i++) {
                    newData[i] = data[i];
                }
                data = newData;

            }

            @Override
            public String toString() {
                StringBuilder res = new StringBuilder();
                res.append(String.format("Array: size= %d,capacity= %d\n", size, data.length));
                res.append('[');
                for (int i = 0; i < size; i++) {
                    res.append(data[i]);
                    if (i != size - 1) {
                        res.append(", ");
                    }
                }
                res.append(']');
                return res.toString();
            }

            public void swap(int i, int j) {
                if (i < 0 || i >= size || j < 0 || j >= size)
                    throw new IllegalArgumentException("illeagal");
                E t = data[i];
                data[i] = data[j];
                data[j] = t;
            }
        }
        class MaxHeap<E extends Comparable<E>> {
            private Array<E> data;

            public MaxHeap(int capacity) {
                data = new Array<E>(capacity);
            }

            public MaxHeap() {
                data = new Array<E>();
            }

            public MaxHeap(E[] arr) {
                data = new Array<E>(arr);
                //找到最后一个非叶子节点
                for (int i = getParent(arr.length - 1); i >= 0; i--) {
                    siftDown(i);
                }
            }

            public int getSize() {
                return data.getSize();
            }

            public boolean isEmpty() {
                return data.isEmpty();
            }

            //返回index索引元素的父亲索引
            private int getParent(int index) {
                if (index == 0) {
                    throw new IllegalArgumentException("没有父亲");
                }
                return (index - 1) / 2;
            }

            //左孩子
            private int leftChild(int index) {
                return index * 2 + 1;
            }

            //右孩子
            private int rightChild(int index) {
                return index * 2 + 2;
            }

            public void add(E e) {
                data.addLast(e);
                siftUp(data.getSize() - 1);
            }

            private void siftUp(int k) {
                while (k > 0 && data.get(getParent(k)).compareTo(data.get(k)) < 0) {
                    data.swap(k, getParent(k));
                    k = getParent(k);
                }
            }

            //取出堆中最大值
            public E extractMax() {
                if (data.getSize() == 0) {
                    throw new IllegalArgumentException("empty");
                }
                E ret = findMax();
                data.swap(0, data.getSize() - 1);
                data.removeLast();
                siftDown(0);
                return ret;
            }

            private void siftDown(int k) {
                while (leftChild(k) < data.getSize()) {
                    int j = leftChild(k);
                    if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                        j = rightChild(k);
                        //data[j]是leftchile和rightchild中的最大值
                    }
                    if (data.get(k).compareTo(data.get(j)) >= 0)
                        break;
                    data.swap(k, j);
                    k = j;
                }
            }

            public E findMax() {
                return data.get(0);
            }

            //取出堆中的最大元素 并且替换成元素e
            public E replace(E e) {
                E ret = findMax();
                data.set(0, e);
                siftDown(0);
                return ret;
            }
        }
        if (nums.length == 1)
            return nums[0];

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        MaxHeap<Integer> integerMaxHeap = new MaxHeap<Integer>(arr);
        for (int i = 0; i < k-1; i++) {
            integerMaxHeap.extractMax();
        }
        return integerMaxHeap.findMax();
    }
}

package Other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 146. LRU缓存机制
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache(2);/* 缓存容量
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
/*
    这道题细节比较多 要注意每次put必须要放在最前面 每次get了也要更新位置 每次put要注意覆盖相同key的节点 并且覆盖之后也要放在最前面
 */
public class LRUCache {

    class Node {
        Integer key;
        Integer value;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private static int size = 0;
    private Node[] arr;

    public LRUCache(int capacity) {
        arr = new Node[capacity];
        Arrays.fill(arr,new Node(null,null));
        this.capacity = capacity;
    }

    public int get(int key) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i].key != null && arr[i].key == key) {
                Node newNode=new Node(arr[i].key,arr[i].value);
                for (int j = i; j >=1 ; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0]=newNode;
                return arr[0].value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i].key != null && arr[i].key == key) {
                Node newNode=new Node(key,value);
                for(int j=i;j>=1;j--){
                    arr[j]=arr[j-1];
                }
                arr[0]=newNode;
                return;
            }
        }
        Node newNode = new Node(key, value);
        for (int i = arr.length - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newNode;

    }
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(1,1);
        lruCache.put(2,3);
        lruCache.put(4,1);
        System.out.println(lruCache.get(1)+"  "+lruCache.get(2));
    }

}

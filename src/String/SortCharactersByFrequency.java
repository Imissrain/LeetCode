package String;

import java.util.*;

/**
 * 451. 根据字符出现频率排序
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 * <p>
 * 输出:
 * "cccaaa"
 * <p>
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * <p>
 * 输入:
 * "Aabb"
 * <p>
 * 输出:
 * "bbAa"
 * <p>
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */

/*
 * 造个Node节点 封装字符Character和Count 然后扔进对象数组 自定义排序规则逆序排列 然后遍历数组 按照count次数拼接
 */
@SuppressWarnings("all")
public class SortCharactersByFrequency {
    class Node {
        Character character;
        Integer count;

        public Node(Character character, Integer count) {
            this.character = character;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            return "";
        Node[] arr = new Node[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Node node = new Node(s.charAt(i), 1);
            arr = addNode(arr, node);
        }
        int index = 0;
        for (index = 0; index < arr.length; index++) {
            if (arr[index] == null)
                break;
        }
        Arrays.sort(arr, 0, index, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (Integer.compare(o2.count - o1.count, 0));
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                while (arr[i].count > 0) {
                    stringBuilder.append(arr[i].character);
                    arr[i].count--;
                }
            }
        }
        return stringBuilder.toString();
    }

    private Node[] addNode(Node[] arr, Node val) {
        for (int i = 0; i < arr.length; ) {
            if (arr[i] != null && arr[i].character == val.character) {
                arr[i].count += val.count;
                i++;
                break;
            } else if (arr[i] != null && arr[i].character != val.character) {
                i++;
            } else {
                arr[i] = val;
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(new SortCharactersByFrequency().frequencySort(s));
    }
}

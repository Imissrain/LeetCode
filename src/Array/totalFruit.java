package Array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 904. 水果成篮
 * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 * <p>
 * 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 * 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 * <p>
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * 用这个程序你能收集的水果总量是多少？
 * 示例 1：
 * <p>
 * 输入：[1,2,1]
 * 输出：3
 * 解释：我们可以收集 [1,2,1]。
 * 示例 2：
 * <p>
 * 输入：[0,1,2,2]
 * 输出：3
 * 解释：我们可以收集 [1,2,2].
 * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
 * 示例 3：
 * <p>
 * 输入：[1,2,3,2,2]
 * 输出：4
 * 解释：我们可以收集 [2,3,2,2].
 * 如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
 * 示例 4：
 * <p>
 * 输入：[3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：我们可以收集 [1,2,1,1,2].
 * 如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 个水果。
 *
 * @author gkyan
 */
@SuppressWarnings("all")
public class totalFruit {
    //周赛b题
    //超时
    public static int totalFrui1t(int[] tree) {
        if (tree.length == 0)
            return 0;
        int ans = 0;
        int max = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < tree.length; i++) {
            for (int j = i; j < tree.length; j++) {
                if (map.size() <= 2) {
                    Integer integer = map.get(tree[j]);
                    map.put(tree[j], integer == null ? 1 : map.get(tree[j]) + 1);
                    if (map.size() > 2) {
                        map.remove(tree[j]);
                        break;
                    }

                }
            }
            for (Map.Entry entry : map.entrySet()) {
                ans += (int) entry.getValue();
            }
            if (ans > max) {
                max = ans;
            }
            ans = 0;
            map.clear();
        }
        return max;
    }
    //区间模拟
    public static int totalFruit(int[] tree) {

        int n = tree.length;
        int[] count = new int[n + 1];

        int total = 0;
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            count[tree[i]]++;
            if (count[tree[i]] == 1) {
                total++;
            }

            while (total > 2) {
                int t = --count[tree[j]];
                j++;

                if (t == 0) {
                    --total;
                }
            }

            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(nums));
    }
}

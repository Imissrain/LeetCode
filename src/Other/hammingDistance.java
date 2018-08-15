package Other;
/**
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 * */
@SuppressWarnings("all")
public class hammingDistance {
    public int hammingDistance(int x, int y) {
        //
        //Integer.toBinaryString(x^y).replaceAll("0","").length();
//        return Integer.toBinaryString(x^y).replaceAll("0","").length();

//        Integer.bitCount(x^y);
//        return Integer.bitCount(x^y);

        //n&=(n-1)
        int count =0;
        int n=x^y;
        while(n!=0){
            count++;
            n&=(n-1);
        }
        return count;
    }
}

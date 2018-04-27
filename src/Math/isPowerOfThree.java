package Math;
@SuppressWarnings("all")
public class isPowerOfThree {

    public boolean isPowerOfThree(int n) {
        //抖机灵
        return ( n>0 &&  1162261467%n==0);

    }
    //常规操作
    public boolean isPowerOfThree1(int n) {
        if (n < 1)
            return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}

package Math;
/**
 * 计数质数
 * 计算所有小于非负数整数 n 的质数数量。
 *
 * */
@SuppressWarnings("all")
public class CountPrimes {
    public static int countPrimes(int n) {
        int sum = 0;
        if(n==0 || n==1) return 0;
        for(int i=2; i<n; i++){
            if(isPrime(i)) sum++;
        }
        return sum;
    }
    //朴素质数判断超时
    public static boolean isPrime1(int n){
        if(n<2)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    //改进版判断素数
    public static boolean isPrime(int num){
        if(num ==2|| num==3 )
            return true ;
        //不在6的倍数两侧的一定不是质数
        if(num %6!= 1&&num %6!= 5)
            return false ;
        int tmp = (int) Math.sqrt( num);
        //在6的倍数两侧的也可能不是质数
        for(int i= 5;i <=tmp; i+=6 )
            if(num %i== 0||num %(i+ 2)==0 )
                return false ;
        //排除所有，剩余的是质数
        return true ;
    }
    public static void main(String[] args) {
        int n=150000;
        System.out.println(countPrimes(n));
    }
}

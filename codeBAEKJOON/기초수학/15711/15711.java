import java.util.Scanner;
 
public class Main {
    static long primeTest[]= {2,325,9375,28178,450775,9780504,1795265022};
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        
        for(int test_case=1;test_case<=T;test_case++) {
            long A=scan.nextLong();
            long B=scan.nextLong();
            
            long sum=A+B;
            
            if(sum<4) {
                System.out.println("NO");
            }else if(sum%2==0) {
                System.out.println("YES");
            }else {
                sum-=2;
                if(is_prime(sum)) {System.out.println("YES");}
                else {System.out.println("NO");}
            }
        }
    }

    public static long addmod(long x, long y, long m) {
        x %= m;
        y %= m;
        return (x >= m - y? x - (m - y) : x + y);
    }
     
    public static long mulmod(long x, long y, long m) {
        x %= m;
        y %= m;
        long r = 0;
        while (y > 0) {
            if (y % 2 == 1)
                r = addmod(r, x, m);
            x = addmod(x, x, m);
            y /= 2;
        }
        return r;
    }
     
    public static long powmod(long x, long y, long m) {
        x %= m;
        long r = 1;
        while (y > 0) {
            if (y % 2 == 1)
                r = mulmod(r, x, m);
            x = mulmod(x, x, m);
            y /= 2;
        }
        return r;
    }
     
    public static boolean miller_rabin(long n, long a) {
        long d = n - 1;
        while (d % 2 == 0) {
            if (powmod(a, d, n) == n-1)
                return true;
            d /= 2;
        }
        long tmp = powmod(a, d, n);
        return tmp == n-1 || tmp == 1;
    }
     
    public static boolean is_prime(long n) {
        if (n <= 1)
            return false;
        if (n <= Long.parseLong("10000000000")) {
            for (long i = 2; i*i <= n; i++)
                if (n % i == 0)
                    return false;
            return true;
        }
        for (long a : primeTest)
            if (!miller_rabin(n, a))
                return false;
        return true;
    }
}

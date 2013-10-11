import java.io.*;
import java.util.*;
 
public class Main {
 
    public static boolean[] isPrime = new boolean[1000000001];
        
        public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                int t = s.nextInt();
                initPrimeArr();
                for(int j=0; j<t; j++) {
                        int m = s.nextInt(), n = s.nextInt();
                        if(m%2==0) {
                                if(m==2) System.out.println(2);
                                m++;
                        }else if(m==1) {
                        	System.out.println(2);
                        	m+=2;
                        }
                        for(int i=m; i<=n; i+=2) {
                                if(isPrime[i]) System.out.println(i);
                        }
                        System.out.println();
                }
                s.close();
                System.exit(0);
        }
        
        public static void initPrimeArr() {
                Arrays.fill(isPrime, true);
                isPrime[0] = false;
                isPrime[1] = false;
                for(int i=4; i<isPrime.length; i+=2) isPrime[i] = false;
                int lim = (int)Math.sqrt(isPrime.length);
                for(int i=3; i<lim; i+=2) if(isPrime[i]) for(int j=i+i; j<isPrime.length; j+=i) isPrime[j] = false;
        }
        
}

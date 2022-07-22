package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class 백준_1837번_암호제작{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        char[] p = s[0].toCharArray();
        int k = Integer.parseInt(s[1]);

        boolean[] isPrime = new boolean[k+1];

        Arrays.fill(isPrime, true);

        for(int i=2;i<=k; i++) {
            if(isPrime[i]){
                int index=i+i;
                while(index<=k) {
                    isPrime[index] = false;
                    index += i;
                }
            }
        }

        for(int i=2;i<k;i++){
            if(isPrime[i]){
                long n = 0;
                int index = 0;
                while(index<p.length) {
                    n = 10 * n + p[index++]-'0';
                    n %= i;
                }
                if(n==0) {
                    System.out.print("BAD "+i);
                    return;
                }
            }
        }
        System.out.print("GOOD");
    }
}
package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_11653번_소인수분해 {
    static void factorization(int num){
        int div=2;
        while(num>1) {
            if (num % div == 0) {
                num /= div;
                if(num>1)
                    System.out.println(div);
                else {
                    System.out.print(div);
                    break;
                }
            } else
                div += 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        factorization(N);
    }
}

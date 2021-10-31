package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1676번_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int two=0, five=0;
        for(int i=1;i<=N;i++){
            int num=i;
            while(num%10==0){
                num/=10;
                two++;
                five++;
            }
            while(num%2==0){
                num/=2;
                two++;
            }
            while(num%5==0){
                num/=5;
                five++;
            }
        }
        System.out.printf(String.valueOf((two<five)?two:five));
    }
}

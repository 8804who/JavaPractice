package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1003번_피보나치함수 {
    static int[][] memo=new int[41][2];
    static int[] fibonacci(int n){
        int[] num=new int[2];
        if(n==0){
            num[0]=1;
            num[1]=0;
            return num;
        }
        else if(n==1){
            num[0]=0;
            num[1]=1;
            return num;
        }
        else {
            if(memo[n][0]==0 && memo[n][1]==0) {
                num[0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
                num[1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
                memo[n][0]=num[0];
                memo[n][1]=num[1];
            }
            else{
                num[0]=memo[n][0];
                num[1]=memo[n][1];
            }
            return num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            int[] fibonacci = fibonacci(Integer.parseInt(br.readLine()));
            System.out.printf("%d %d\n", fibonacci[0], fibonacci[1]);
        }
    }
}

package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2225번_합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int N=Integer.parseInt(input[0]), K=Integer.parseInt(input[1]);
        int[][] dp=new int[201][201];
        Arrays.fill(dp[1], 1);
        for(int i=0;i<N+1;i++){
            dp[2][i]=i+1;
        }
        for(int i=3;i<K+1;i++){
            dp[i][0]=1;
            for(int j=1;j<N+1;j++){
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000;
            }
        }
        System.out.print(dp[K][N]);
    }
}

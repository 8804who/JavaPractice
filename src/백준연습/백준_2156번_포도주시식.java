package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2156번_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[] wine = new int[n];
        int[][] dp = new int[n][3];
        for(int i=0;i<n;i++) wine[i]=Integer.parseInt(br.readLine());
        if(n>0) {
            dp[0][0] = 0;
            dp[0][1] = wine[0];
            dp[0][2] = wine[0];
        }
        if(n>1) {
            dp[1][0] = 0;
            dp[1][1] = wine[1];
            dp[1][2] = wine[0] + wine[1];
        }

        for(int i=2;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1]=Math.max(dp[i-1][0], dp[i-2][2])+wine[i];
            dp[i][2]=dp[i-1][1]+wine[i];
        }
        max=Math.max(max, Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
        System.out.print(max);
    }
}

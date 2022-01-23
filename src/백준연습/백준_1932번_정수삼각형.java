package 백준연습;
import java.io.*;
import java.util.*;
public class 백준_1932번_정수삼각형{
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[][] triangle = new int[n+1][];
        int[][] dp = new int[n+1][];
        for(int i=1;i<n+1;i++){
            triangle[i]=new int[i];
            dp[i]=new int[i];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<i;j++) triangle[i][j]=Integer.parseInt(st.nextToken());
        }
        dp[1][0]=triangle[1][0];
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                if(j==i-1) dp[i][j]=triangle[i][j]+dp[i-1][j-1];
                else if(j>0) dp[i][j]=triangle[i][j]+Math.max(dp[i-1][j], dp[i-1][j-1]);
                else dp[i][j]=dp[i-1][j]+triangle[i][j];
            }
        }
        for(int i=0;i<n;i++){
            if(max<dp[n][i]) max=dp[n][i];
        }
        System.out.print(max);
    }
}

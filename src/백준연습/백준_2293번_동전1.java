package 백준연습;
import java.io.*;
public class 백준_2293번_동전1 {
    public static void main(String[] args) throws IOException{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]), k=Integer.parseInt(input[1]);
        int[][] dp = new int[n][k+1];
        for(int i=0;i<n;i++){
            int coin=Integer.parseInt(br.readLine());
            dp[i][0]=1;
            for(int j=1;j<k+1;j++){
                if(j-coin>=0) dp[i][j]=dp[i][j-coin];
                if(i>0) {
                    dp[i][j]+=dp[i-1][j];
                }
            }
        }
        System.out.print(dp[n-1][k]);
    }
}

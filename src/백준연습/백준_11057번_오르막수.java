package 백준연습;
import java.io.*;
import java.util.*;
public class 백준_11057번_오르막수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][10];
        int sum=0;
        Arrays.fill(dp[0], 1);
        for(int i=1;i<N;i++){
            for(int j=0;j<10;j++){
                for(int k=j;k<10;k++) dp[i][j]+=dp[i-1][k]%10007;
            }
        }
        for (Integer num: dp[N-1]) {
            sum+=num;
            sum%=10007;
        }
        System.out.print(sum);
    }
}

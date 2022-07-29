package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 백준_7579번_앱 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory = new int[N];
        int[] restart = new int[N];

        int[][] dp = new int[N][N*100+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N; i++) {
            memory[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N; i++) {
            restart[i]=Integer.parseInt(st.nextToken());
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<=N*100;j++){
                if(i==0) {
                    if(j-restart[i]>=0) dp[i][j]=memory[i];
                }
                else{
                    if(j-restart[i]>=0) dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-restart[i]]+memory[i]);
                    else dp[i][j]=dp[i-1][j];
                }
            }
        }
        for(int j=0;j<=N*100;j++){
            if(dp[N-1][j]>=M) {
                System.out.print(j);
                break;
            }
        }
    }
}
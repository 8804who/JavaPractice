package 백준연습;
import java.io.*;
import java.util.*;

public class 백준_11053번_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());

        dp[0]=1;

        for(int i=1;i<N;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]) max=Math.max(dp[j]+1,max);
            }
            dp[i]=max;
        }

        int max=0;
        for(int i=0;i<N;i++) max=Math.max(max, dp[i]);
        System.out.print(max);
    }
}

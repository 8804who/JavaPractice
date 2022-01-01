package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_12852번_1로만들기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[1000001][2];
        int num;
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dp[N][0]=1;
        while(!q.isEmpty()){
             num = q.poll();

             if(num-1>0) {
                 if (dp[num - 1][0] == 0) {
                     q.add(num - 1);
                     dp[num - 1][0] = dp[num][0] + 1;
                     dp[num-1][1]=num;
                 }
             }

             if(num%3==0){
                 if(dp[num/3][0]==0) {
                     q.add(num / 3);
                     dp[num/3][0] = dp[num][0] + 1;
                     dp[num/3][1] = num;
                 }
             }

             if(num%2==0){
                 if(dp[num/2][0]==0){
                     q.add(num/2);
                     dp[num/2][0]=dp[num][0]+1;
                     dp[num/2][1]=num;
                 }
             }
        }
        System.out.println(dp[1][0]-1);

        int pointer = 1;
        int[] route = new int[dp[1][0]];
        for(int i=0;i<dp[1][0];i++){
            route[i]=pointer;
            if(pointer==N) break;
            pointer = dp[pointer][1];
        }
        for(int i=dp[1][0]-1;i>-1;i--) System.out.print(route[i]+" ");
    }
}

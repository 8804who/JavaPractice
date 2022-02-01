package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1912번_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] memo = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        memo[0]=arr[0];
        int max = memo[0];
        for(int i=1;i<n;i++){
            if(memo[i-1]>0) memo[i]=memo[i-1]+arr[i];
            else memo[i]=arr[i];
            if(memo[i]>max) max=memo[i];
        }
        System.out.print(max);
    }
}

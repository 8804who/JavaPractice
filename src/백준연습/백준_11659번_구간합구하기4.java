package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_11659번_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N=Integer.parseInt(input[0]);
        int M=Integer.parseInt(input[1]);
        int[] arr=new int[N+1];
        int[] cumulativeSum=new int[N+1];
        int sum;
        input=br.readLine().split(" ");
        for(int i=0;i<N;i++) {
            arr[i+1]=Integer.parseInt(input[i]);
            cumulativeSum[i+1]=Integer.parseInt(input[i])+cumulativeSum[i];
        }
        for(int i=0;i<M;i++){
            input=br.readLine().split(" ");
            sum=cumulativeSum[Integer.parseInt(input[1])]-cumulativeSum[Integer.parseInt(input[0])-1];
            sb.append(sum+"\n");
        }
        System.out.print(sb);
    }
}

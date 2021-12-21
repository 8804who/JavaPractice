package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_3273번_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int count=0, leftPointer=0, rightPointer=n-1;
        int[] arr = new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int x=Integer.parseInt(br.readLine());
        while(leftPointer<rightPointer){
            if(arr[leftPointer]+arr[rightPointer]==x) {
                count++;
                leftPointer++;
                rightPointer--;
            }
            else if(arr[leftPointer]+arr[rightPointer]>x){
                rightPointer--;
            }
            else leftPointer++;
        }
        System.out.print(count);
    }
}

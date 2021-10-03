package 연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소인수분해 {
    static int[] factorization(int num){
        int[] arr=new int[num+1];
        int div=2;
        while(num>1){
            if(num%div==0){
                num/=div;
                arr[div]+=1;
            }
            else
                div+=1;
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=factorization(N);
        for(int i=2;i<arr.length;i++){
            if(arr[i]>0)
                System.out.printf("%d^%d ",i,arr[i]);
        }
    }
}

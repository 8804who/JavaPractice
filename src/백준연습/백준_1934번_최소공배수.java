package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1934번_최소공배수 {
    static int gcd(int a, int b){
        if(a%b==0) return b;
        else{
            return gcd(b,a%b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String input[]=br.readLine().split(" ");
            int n1=Integer.parseInt(input[0]), n2=Integer.parseInt(input[1]);
            sb.append(n1*n2/gcd(n1,n2)+"\n");
        }
        System.out.print(sb);
    }
}

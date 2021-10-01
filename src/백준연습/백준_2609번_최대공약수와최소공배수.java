package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 백준_2609번_최대공약수와최소공배수 {
    static int gcd(int a, int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n1 = Math.max(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        int n2 = Math.min(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        int gcd=gcd(n1, n2);
        System.out.println(gcd);
        System.out.printf("%d",n1*(n2/gcd));
    }
}
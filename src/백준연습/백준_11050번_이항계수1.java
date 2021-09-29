package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_11050번_이항계수1 {
    public static int factorial(int n){
        if (n==0)
            return 1;
        else
            return n*factorial(n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int count=0;
        if(K!=0)
            System.out.printf("%d", factorial(N) / (factorial(K) * factorial(N - K)));
        else
            System.out.printf("1");
    }
}

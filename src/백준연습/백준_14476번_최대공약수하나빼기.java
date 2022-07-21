package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14476번_최대공약수하나빼기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] gcdArrLR = new int[N];
        int[] gcdArrRL = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) num[i] = Integer.parseInt(st.nextToken());

        gcdArrLR[0] = num[0];
        for(int i=1;i<N-1;i++) gcdArrLR[i] = getGcd(num[i], gcdArrLR[i-1]);

        gcdArrRL[N-1] = num[N-1];
        for(int i=N-2;i>=0;i--) gcdArrRL[i] = getGcd(num[i], gcdArrRL[i+1]);

        int max = 0;
        int except = -1;

        for(int i=0;i<N;i++){
            int gcd;
            if(i==0) gcd = gcdArrRL[1];
            else if(i==N-1) gcd = gcdArrLR[N-2];
            else gcd = getGcd(gcdArrLR[i-1], gcdArrRL[i+1]);
            if(num[i]%gcd!=0) {
                if(max<gcd){
                    max = gcd;
                    except = i;
                }
            }
        }
        if(except!=-1) System.out.printf("%d %d", max, num[except]);
        else System.out.print("-1");
    }
    static int getGcd(int a, int b){
        if(b==0) return a;
        else return getGcd(b, a%b);
    }
}
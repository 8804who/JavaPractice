package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EGResult{
    long s;
    long t;
    long r;
    public EGResult(long s, long t, long r){
        this.s = s;
        this.t = t;
        this.r = r;
    }
}

public class 백준_3955번_캔디분배 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            EGResult e = extendedGcd(A, B);
            if (e.r != 1) System.out.println("IMPOSSIBLE");
            else {

            }
        }
    }
    static EGResult extendedGcd(long a, long b){
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while(r1 != 0){
            long q = r0/r1;

            temp = r0-r1*q;
            r0 = r1;
            r1 = temp;

            temp = s0-s1*q;
            s0 = s1;
            s1 = temp;

            temp = t0-t1*q;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }
}
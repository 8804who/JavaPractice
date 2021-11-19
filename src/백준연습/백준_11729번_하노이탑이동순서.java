package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_11729번_하노이탑이동순서 {
    static StringBuilder sb = new StringBuilder();
    static int count=0;
    static void hanoi(int n, int start,int through, int to){
        if(n==1) {
            count++;
            sb.append(start+" "+to+"\n");
        }
        else{
            hanoi(n-1, start, to, through);
            hanoi(1, start, through, to);
            hanoi(n-1, through, start, to);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        hanoi(N, 1, 2,3);
        System.out.println(count);
        System.out.print(sb);
    }
}

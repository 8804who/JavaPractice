package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_1038번_감소하는수 {
    static boolean[] descNum = new boolean[1000000001];
    static void search(int c, int n, int sum){
        if(c<6) {
            int coefficient= (int) Math.pow(10, c);
            for(int i=0;i<10;i++) {
                if(n<i) {
                    search(c+1, i, sum+n*coefficient);
                    System.out.println(sum);
                }
                else if(i==0) search(c+1, 0, sum);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0, idx = 0;
        Arrays.fill(descNum, false);
        for(int i=0;i<10;i++) search(0, i, i);
    }
}
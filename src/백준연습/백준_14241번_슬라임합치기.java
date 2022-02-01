package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_14241번_슬라임합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] slime = new Integer[N];
        int sum=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) slime[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(slime);
        int size=slime[0];
        for(int i=1;i<N;i++) {
            sum+=slime[i]*size;
            size+=slime[i];
        }
        System.out.print(sum);
    }
}

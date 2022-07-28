package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_11660번_구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            table[i][1] = Integer.parseInt(st.nextToken());
            for(int j=2;j<N+1;j++) table[i][j]=table[i][j-1]+Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=x1;j<=x2;j++){
                sum+=table[j][y2]-table[j][y1-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}

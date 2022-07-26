package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 백준_11657번_타임머신 {
    static long MAX = (long) 1e10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st =  new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] adj = new int[M][3];
        long[] distance = new long[N+1];
        Arrays.fill(distance, MAX);

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            adj[i][0]=Integer.parseInt(st.nextToken());
            adj[i][1]=Integer.parseInt(st.nextToken());
            adj[i][2]=Integer.parseInt(st.nextToken());
        }

        boolean cycle = false;

        distance[1] = 0;
        for(int i=0;i<=N;i++){
            for(int j=0;j<M;j++){
                int start = adj[j][0];
                int dest = adj[j][1];
                int cost = adj[j][2];
                if(distance[start]!=MAX && distance[dest]>distance[start]+cost){
                    distance[dest]=distance[start]+cost;
                    if(i==N) cycle = true;
                }
            }
        }

        if(cycle) System.out.print(-1);
        else{
            for (int i=2;i<N+1;i++) {
                if(distance[i]!=MAX) sb.append(distance[i]).append("\n");
                else sb.append(-1).append("\n");
            }
            System.out.print(sb);
        }
    }
}
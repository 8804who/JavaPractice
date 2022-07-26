package 못푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 백준_11438번_LCA2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] node = new int[N+1][4];

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b){
                int temp = a;
                a=b;
                b=temp;
            }
            node[b][0]=a;
            node[b][1]=node[a][0];
            node[b][2]=node[node[a][1]][0];
            node[b][3]=node[a][3]+1;
        }
        
        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
        }
    }
}

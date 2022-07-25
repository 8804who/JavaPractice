package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1922번_네트워크연결 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        int linkCount = 0;
        int sum = 0;
        int[][] link = new int[M][3];

        for(int i=0;i<=N;i++) parent[i]=i;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            link[i][0]=Integer.parseInt(st.nextToken());
            link[i][1]=Integer.parseInt(st.nextToken());
            link[i][2]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(link, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        for(int i=0;i<M;i++){
            if(!isConnected(link[i][0], link[i][1])){
                sum+=link[i][2];
                union(link[i][0], link[i][1]);
                linkCount++;
            }
            if(linkCount==N-1) break;
        }
        System.out.print(sum);
    }

    static boolean isConnected(int a, int b){
        return find(a)==find(b);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        parent[b] = a;
    }

    static int find(int a){
        if(parent[a]==a) return a;
        else return parent[a]=find(parent[a]);
    }
}

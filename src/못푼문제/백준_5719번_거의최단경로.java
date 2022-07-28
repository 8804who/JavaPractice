package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Road implements Comparable<Road>{
    int dist;
    int dest;

    Road(boolean[][] includedRoad, int dist, int dest){
        this.dist = dist;
        this.dest = dest;
    }

    @Override
    public int compareTo(Road o) {
        return dist-o.dist;
    }
}

public class 백준_5719번_거의최단경로 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;

    static final int MAX = 100000000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] shortest = new int[N];
        int[] almostShortest = new int[N];
        Arrays.fill(shortest, MAX);
        Arrays.fill(almostShortest, MAX);

        PriorityQueue<Road> pq = new PriorityQueue();
        List<Road>[] list = new List[N];
        for(int i=0;i<N; i++) list[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            boolean[][] includedRoad = new boolean[N][N];
            includedRoad[U][V]=true;

            list[U].add(new Road(includedRoad, P, V));
        }

        pq.addAll(list[S]);

        while(!pq.isEmpty()){

        }
        System.out.print(shortest[D]);
    }
}

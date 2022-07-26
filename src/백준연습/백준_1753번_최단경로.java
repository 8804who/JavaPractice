package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 백준_1753번_최단경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o1[1], o2[1]);
                }
            });

        List<int[]>[] values = new ArrayList[V+1];
        for(int i=1;i<V+1;i++) values[i] = new ArrayList<>();

        int[] linkedValue = new int[V+1];

        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            if(n1==K) pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            else values[n1].add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int count=0;
        while(!pq.isEmpty()){
            int[] link=pq.poll();
            if(linkedValue[link[0]]!=0) continue;
            else count++;
            linkedValue[link[0]]=link[1];
            if(count==V-1) break;
            for(int i=0;i<values[link[0]].size();i++){
                int[] link2 = values[link[0]].get(i);
                if(linkedValue[link2[0]]==0) pq.add(new int[]{link2[0], linkedValue[link[0]]+link2[1]});
            }
        }

        for(int i=1;i<V+1;i++) {
            if (i==K) sb.append(0).append("\n");
            else if(linkedValue[i]==0) sb.append("INF").append("\n");
            else sb.append(linkedValue[i]).append("\n");
        }
        System.out.print(sb);
    }
}
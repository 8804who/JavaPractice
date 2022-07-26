package 못푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 백준_2458번_키순서 {
    static int[][] student;
    static boolean[] visited;
    static List<Integer>[] link;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        student = new int[N+1][2];
        visited = new boolean[N+1];
        link = new List[N+1];
        for(int i=1;i<N+1;i++) link[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            link[a].add(b);
        }

        for(int i=1;i<N+1;i++){
            DFS(i, 0);
        }
        for(int i=1;i<N+1;i++) System.out.printf("%d %d\n", student[i][0], student[i][1]);
    }

    static void DFS(int num, int depth){
        student[num][0]++;
        visited[num]=true;
        for(int i=0;i<link[num].size();i++){
            if(!visited[link[num].get(i)]) {
                DFS(link[num].get(i),depth+1);
            }
        }
        visited[num]=false;
    }
}
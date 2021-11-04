package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
public class 백준_11724번_연결요소의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int N=Integer.parseInt(input[0]), M=Integer.parseInt(input[1]), now=0, visit_count=0, count=0;
        LinkedList<Integer>[] comp=new LinkedList[N+1];
        Queue<Integer> connect=new LinkedList<Integer>();
        boolean[] visited=new boolean[N+1];
        visited[0]=true;

        for(int i=0;i<comp.length;i++) comp[i]=new LinkedList<Integer>();
        for(int i=0;i<M;i++){
            input=br.readLine().split(" ");
            comp[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
            comp[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
        }
        for (int i=1;i<comp.length;i++) Collections.sort(comp[i]);

        while(visit_count<N) {
            for(int i=1;i<N+1;i++){
                if(visited[i]==false) {
                    now=i;
                    break;
                }
            }
            visited[now] = true;
            visit_count++;
            count++;
            connect.add(now);
            while (connect.size() > 0) {
                now = connect.poll();
                while (comp[now].size() > 0) {
                    int next = comp[now].poll();
                    if (!visited[next]) {
                        visited[next] = true;
                        visit_count++;
                        connect.add(next);
                    }
                }
            }
        }
        System.out.print(count);
    }
}

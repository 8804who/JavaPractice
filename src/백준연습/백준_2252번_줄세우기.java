package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_2252번_줄세우기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] student = new int[N+1];

        List<Integer>[] taller  = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) taller[i] = new ArrayList<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            taller[B].add(A);
            student[A]++;
        }
        for(int i=1;i<=N;i++) {
            if(student[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int num = q.poll();
            s.push(num);
            for(int i=0;i<taller[num].size();i++){
                student[taller[num].get(i)]--;
                if(student[taller[num].get(i)]==0) q.add(taller[num].get(i));
            }
        }
        while(!s.empty()){
            sb.append(s.pop()).append(" ");
        }
        System.out.print(sb);
    }
}
package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_2606번_바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()), M=Integer.parseInt(br.readLine());
        LinkedList<Integer>[] computer=new LinkedList[N+1];
        boolean[] infected= new boolean[N+1];
        Queue<Integer> connect=new LinkedList<Integer>();
        int count=0, now;
        infected[1]=true;
        for(int i=0;i<computer.length;i++) computer[i]=new LinkedList<Integer>();
        for(int i=0;i<M;i++){
            String[] input=br.readLine().split(" ");
            computer[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
            computer[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
        }
        for (int i=1;i<computer.length;i++) Collections.sort(computer[i]);
        connect.add(1);
        while(connect.size()>0){
            now=connect.poll();
            while(computer[now].size()>0){
                int next=computer[now].poll();
                if(!infected[next]){
                    infected[next]=true;
                    connect.add(next);
                }
            }
        }
        for(int i=2;i<infected.length;i++) {
            if(infected[i]) count++;
        }
        System.out.print(count);
    }
}

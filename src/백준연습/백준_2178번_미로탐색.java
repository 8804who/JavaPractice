package 백준연습;

import java.io.*;
import java.util.*;

public class 백준_2178번_미로탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N=Integer.parseInt(input[0]), M=Integer.parseInt(input[1]);
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] map=new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int min=10000;

        for(int i=0;i<N;i++){
            input = br.readLine().split("");
            for(int j=0;j<M;j++) map[i][j]=Integer.parseInt(input[j]);
        }

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        Queue<Integer> queueCount = new LinkedList<>();
        queueX.add(0);
        queueY.add(0);
        queueCount.add(0);
        visited[0][0]=false;
        while(!queueX.isEmpty()){
            int x = queueX.poll();
            int y = queueY.poll();
            int count = queueCount.poll();

            if(x==N-1 & y==M-1){
                min=Math.min(min, count);
            }

            for(int i=0;i<4;i++){
                if(x+move[i][0]>=0 & x+move[i][0]<N & y+move[i][1]>=0 & y+move[i][1]<M){
                    if(map[x+move[i][0]][y+move[i][1]]==1 & !visited[x+move[i][0]][y+move[i][1]]){
                        queueX.add(x+move[i][0]);
                        queueY.add(y+move[i][1]);
                        queueCount.add(count+1);
                        visited[x+move[i][0]][y+move[i][1]]=true;
                    }
                }
            }
        }
        System.out.print(min+1);
    }
}

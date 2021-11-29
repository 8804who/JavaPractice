package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_10026번_적록색약 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] moveX={0, 0, -1, 1};
    static int[] moveY={-1, 1, 0, 0};

    static void inputMap(String[][] map) throws IOException {
        String[] input;
        for(int i=0;i< map.length;i++){
            input=br.readLine().split("");
            for(int j=0;j< map.length;j++){
                map[i][j]=input[j];
            }
        }
    }

    static void DFS(int x, int y, String[][] map, int[][] visited){
        visited[x][y]=1;
        for(int i=0;i<4;i++) {
            if(x+moveX[i]>=0 && y+moveY[i]>=0 && x+moveX[i]< map.length && y+moveY[i]< map.length){
                if (map[x][y].equals(map[x + moveX[i]][y + moveY[i]]) && visited[x+moveX[i]][y+moveY[i]]==0) DFS(x+moveX[i],y+moveY[i],map,visited);
            }
        }
    }

    static void DFS_RG(int x, int y, String[][] map, int[][] visited){
        visited[x][y]=1;
        for(int i=0;i<4;i++) {
            if(x+moveX[i]>=0 && y+moveY[i]>=0 && x+moveX[i]< map.length && y+moveY[i]< map.length){
                if (map[x][y].equals("R") || map[x][y].equals("G")){
                    if ((map[x+moveX[i]][y+moveY[i]].equals("R") || map[x+moveX[i]][y+moveY[i]].equals("G")) && visited[x+moveX[i]][y+moveY[i]]==0) DFS_RG(x+moveX[i],y+moveY[i],map,visited);
                }
                else{
                    if (map[x+moveX[i]][y+moveY[i]].equals("B") && visited[x+moveX[i]][y+moveY[i]]==0) DFS(x+moveX[i],y+moveY[i],map,visited);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int count=0;
        int N = Integer.parseInt(br.readLine());
        String[][] map=new String[N][N];
        int[][] visited=new int[N][N];
        inputMap(map);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==0) {
                    DFS(i,j,map,visited);
                    count++;
                }
            }
        }
        System.out.print(count+" ");

        count=0;
        for(int i=0;i<N;i++) Arrays.fill(visited[i],0);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j]==0) {
                    DFS_RG(i,j,map,visited);
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}

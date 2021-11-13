package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1012번_유기농배추 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] field;
    static boolean[][] visited;
    static int worm;
    static void inputCabbage(int num) throws IOException {
        for(int i=0;i<num;i++){
            String[] input=br.readLine().split(" ");
            field[Integer.parseInt(input[0])][Integer.parseInt(input[1])]=true;
        }
    }

    static void Search(int h, int v, int count){
        int[][] move={{-1,0},{1,0},{0,-1},{0,1}};
        visited[h][v]=true;
        if(field[h][v]==true){
            if(count==1) worm++;
            for(int i=0;i<4;i++){
                if(h+move[i][0]>=0&&v+move[i][1]>=0&&h+move[i][0]< field.length&&v+move[i][1]<field[0].length){
                    if(field[h+move[i][0]][v+move[i][1]]==true&&visited[h+move[i][0]][v+move[i][1]]==false){
                        Search(h+move[i][0],v+move[i][1], count+1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String[] input=br.readLine().split(" ");
            int M=Integer.parseInt(input[0]), N=Integer.parseInt(input[1]), K=Integer.parseInt(input[2]);
            field=new boolean[M][N];
            visited=new boolean[M][N];
            worm=0;
            inputCabbage(K);
            for(int m=0;m<M;m++){
                for(int n=0;n<N;n++){
                    if(visited[m][n]==false) Search(m, n, 1);
                }
            }
            System.out.println(worm);
        }
    }
}

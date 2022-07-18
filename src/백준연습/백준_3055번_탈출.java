package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_3055번_탈출 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    static int R, C;
    static char[][] map;
    static boolean[][] visit;

    static Queue<int[]> water = new LinkedList<>();
    static Queue<int[]> flood = new LinkedList<>();
    static Queue<int[]> hedgehog = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R+1][C+1];
        visit = new boolean[R+1][C+1];

        for(int i = 1; i <= R; i++) {
            String input = br.readLine();
            for(int j=1;j<=C;j++){
                map[i][j] = input.charAt(j-1);
                if(input.charAt(j-1)=='*') water.add(new int[]{i, j});
                if(input.charAt(j-1)=='S') hedgehog.add(new int[]{i, j, 1});
            }
        }
        int minute = 0;
        while(!hedgehog.isEmpty()){
            int[] hedgehogCoordinate = hedgehog.poll();
            if(minute<hedgehogCoordinate[2]) {
                minute++;
                while (!water.isEmpty()) {
                    int[] waterCoordinate = water.poll();
                    for (int i = 0; i < 4; i++) {
                        int floodX = waterCoordinate[0] + move[i][0];
                        int floodY = waterCoordinate[1] + move[i][1];
                        if (R >= floodX && floodX > 0 && C >= floodY && floodY > 0) {
                            if (map[floodX][floodY] == '.') {
                                map[floodX][floodY] = '*';
                                flood.add(new int[]{floodX, floodY});
                            }
                        }
                    }
                }
            }

            for(int i=0;i<4;i++){
                int moveX = hedgehogCoordinate[0]+move[i][0];
                int moveY = hedgehogCoordinate[1]+move[i][1];

                if(R>=moveX && moveX>0 && C>=moveY && moveY>0){
                    if(map[moveX][moveY]=='.' && !visit[moveX][moveY]){
                        hedgehog.add(new int[]{moveX, moveY, hedgehogCoordinate[2]+1});
                        visit[moveX][moveY] = true;
                    }else if(map[moveX][moveY]=='D'){
                        System.out.print(hedgehogCoordinate[2]);
                        return;
                    }
                }
            }
            while(!flood.isEmpty()) water.add(flood.poll());
        }
        System.out.print("KAKTUS");
    }
}

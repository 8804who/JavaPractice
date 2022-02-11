package 백준연습;
import java.io.*;
import java.util.*;

class Robot{
    int x;
    int y;
    int d;
    Robot(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class 백준_14503번_로봇청소기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Robot> q = new LinkedList<>();
        int[][] direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int count = 0;

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        q.add(new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) map[i][j]=Integer.parseInt(st.nextToken());
        }

        while(!q.isEmpty()){
            Robot robot = q.poll();
            int x = robot.x;
            int y = robot.y;
            int d = robot.d;

            if(map[x][y]==0) {
                map[x][y] = 2;
                count++;
            }
            for(int i=0;i<4;i++){
                if(x+direction[d][0]>=0 & x+direction[d][0]<N & y+direction[d][1]>=0 & y+direction[d][1]<M){
                    if(map[x+direction[d][0]][y+direction[d][1]]==0) {
                        q.add(new Robot(x+direction[d][0], y+direction[d][1], (d+3)%4));
                        break;
                    }
                    else d = (d+3)%4;
                }
                else d = (d+3)%4;

                if(i==3) {
                    int backDirect = (d+3)%4;
                    if (x+direction[backDirect][0] >=0 & x+direction[backDirect][0]<N & y+direction[backDirect][1]>=0 & y+direction[backDirect][1]<M){
                        if(map[x+direction[backDirect][0]][y+direction[backDirect][1]]!=1) q.add(new Robot(x+direction[backDirect][0], y+direction[backDirect][1], d));
                    }
                }
            }
        }
        System.out.print(count);
    }
}
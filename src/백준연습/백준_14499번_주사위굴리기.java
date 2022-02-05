package 백준연습;
import java.io.*;
import java.util.*;

public class 백준_14499번_주사위굴리기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb=new StringBuilder();
    static Queue<Integer> qX = new LinkedList<>();
    static Queue<Integer> qY = new LinkedList<>();
    static Queue<Integer> qCmd = new LinkedList<>();
    static int N, M, K;
    static int[][] map;
    static int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[] diceMove={3, 4, 2, 5};//동서남북
    static int[] dice = new int[7];
    static int topside=1;

    static void inputSetting() throws IOException{
        st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        qX.add(Integer.parseInt(st.nextToken()));
        qY.add(Integer.parseInt(st.nextToken()));
        K=Integer.parseInt(st.nextToken());
    }

    static void inputMap() throws IOException{
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) map[i][j]=Integer.parseInt(st.nextToken());
        }
    }

    static void inputCmd() throws IOException{
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++) qCmd.add(Integer.parseInt(st.nextToken()));
    }

    static void selectDirection(int direction){
        int temp;
        if(direction==0){//동쪽
            temp=diceMove[1];
            diceMove[0]=topside;
            diceMove[1]=7-topside;
        }
        else if(direction==1){//서쪽
            temp=diceMove[0];
            diceMove[0]=7-topside;
            diceMove[1]=topside;
        }
        else if(direction==2){//북쪽
            temp=diceMove[3];
            diceMove[2]=topside;
            diceMove[3]=7-topside;
        }
        else{//남쪽
            temp=diceMove[2];
            diceMove[2]=7-topside;
            diceMove[3]=topside;
        }
        topside=temp;
    }

    static void copy(int x, int y, int direction){
        if(map[x+move[direction][0]][y+move[direction][1]]==0){
            map[x+move[direction][0]][y+move[direction][1]]=dice[7-topside];
        }
        else {
            dice[7-topside]=map[x+move[direction][0]][y+move[direction][1]];
            map[x+move[direction][0]][y+move[direction][1]]=0;
        }
    }

    static void moveDice(){
        while(!qCmd.isEmpty()){
            int x=qX.poll(), y=qY.poll();
            int direction = qCmd.poll()-1;
            if(N > x+move[direction][0] & x+move[direction][0] >= 0 & M > y+move[direction][1] & y+move[direction][1] >= 0){
                selectDirection(direction);
                copy(x,y,direction);
                qX.add(x+move[direction][0]);
                qY.add(y+move[direction][1]);
                sb.append(dice[topside]).append("\n");
            }
            else{//명령이 범위를 벗어나면 해당 명령 무시
                qX.add(x);
                qY.add(y);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        inputSetting();
        map = new int[N][M];
        inputMap();
        inputCmd();
        moveDice();
        System.out.print(sb);
    }
}
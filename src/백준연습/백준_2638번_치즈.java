package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2638번_치즈 {
    static int row, column;
    static int[][] check = {{-1, 0},{1, 0},{0,-1},{0,1}};
    static int hour=0;

    static Queue<Integer> rowQueue = new LinkedList<>();
    static Queue<Integer> columnQueue = new LinkedList<>();
    static Queue<Integer> rowQueueTemp = new LinkedList<>();
    static Queue<Integer> columnQueueTemp = new LinkedList<>();


    static void checkMap(int meltingRow, int meltingColumn, int[][] map, boolean[][][] visited){
        for(int i=0;i<4;i++){
            if(meltingRow+check[i][0] >=0 & meltingRow+check[i][0] <= row+1 & meltingColumn+check[i][1] >= 0 & meltingColumn+check[i][1] <= column+1){
                if(!visited[meltingRow+check[i][0]][meltingColumn+check[i][1]][4]){
                    if(map[meltingRow+check[i][0]][meltingColumn+check[i][1]]>=1){
                        if(!visited[meltingRow+check[i][0]][meltingColumn+check[i][1]][i]){
                            map[meltingRow+check[i][0]][meltingColumn+check[i][1]]+=1;
                            visited[meltingRow+check[i][0]][meltingColumn+check[i][1]][i]=true;
                            if(map[meltingRow+check[i][0]][meltingColumn+check[i][1]]>=3){
                                rowQueueTemp.add(meltingRow+check[i][0]);
                                columnQueueTemp.add(meltingColumn+check[i][1]);
                            }
                        }
                    }
                    else{
                        rowQueue.add(meltingRow+check[i][0]);
                        columnQueue.add(meltingColumn+check[i][1]);
                        visited[meltingRow+check[i][0]][meltingColumn+check[i][1]][4]=true;
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row=Integer.parseInt(st.nextToken());
        column=Integer.parseInt(st.nextToken());

        int[][] map = new int[row+2][column+2];
        boolean[][][] visited = new boolean[row+2][column+2][5];

        for(int i=1;i<row;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<column;j++)
            {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        rowQueue.add(0);
        columnQueue.add(0);

        while(!rowQueue.isEmpty()){
            while(!rowQueue.isEmpty()){
                int meltingRow=rowQueue.poll();
                int meltingColumn=columnQueue.poll();
                checkMap(meltingRow, meltingColumn, map, visited);
            }



            while(!rowQueueTemp.isEmpty()){
                int meltedRow=rowQueueTemp.poll();
                int meltedColumn=columnQueueTemp.poll();
                map[meltedRow][meltedColumn]=0;
                rowQueue.add(meltedRow);
                columnQueue.add(meltedColumn);
            }

            for(int i=1;i<=row;i++){
                for (int j=1;j<=column;j++) {
                    if(map[i][j]>1) map[i][j]=1;
                    for(int k=0;k<5;k++) visited[i][j][k]=false;
                }
            }
            hour+=1;
        }
        System.out.print(hour-1);
    }
}
package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_11651번_좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(br.readLine());
        int[][] coordinate =new int[N][2];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            coordinate[i][0]=Integer.parseInt(st.nextToken());
            coordinate[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coordinate, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(coordinate[i][0]+" "+coordinate[i][1]).append('\n');
        }
        System.out.print(sb);
    }
}

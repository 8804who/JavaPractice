package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 백준_2304번_창고다각형 {
    private static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    static void input(int[][] arr, int i) throws IOException {
        st=new StringTokenizer(br.readLine());
        arr[i][0]=Integer.parseInt(st.nextToken());
        arr[i][1]=Integer.parseInt(st.nextToken());
    }

    static void sort(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                } else{
                    return o1[0]-o2[0];
                }
            }
        });
    }

    static int find_pivot(int[][] arr){
        int pivot=0;
        for(int i=0;i<arr.length;i++){
            if (arr[pivot][1]<arr[i][1]) {
                pivot=i;
            }
        }
        return pivot;
    }

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br. readLine());
        int[][] arr=new int[N][2];
        int pivot = 0, sum=0, height=0;

        for(int i=0;i<N;i++){
            input(arr, i);
        }

        sort(arr);

        pivot=find_pivot(arr);

        height=arr[0][1];
        for (int i=1;i<=pivot;i++){
            sum+=height*(arr[i][0]-arr[i-1][0]);
            if (height<arr[i][1]) height=arr[i][1];
        }

        sum+=arr[pivot][1];

        height=arr[N-1][1];
        for (int i=N-2;i>=pivot;i--){
            sum+=height*(arr[i+1][0]-arr[i][0]);
            if(height<arr[i][1]) height=arr[i][1];
        }

        System.out.print(sum);
    }
}
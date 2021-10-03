package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1920번_수찾기 {
    static boolean binarySearch(int[] arr, int findNum, int start, int last){
        int pivot=(start+last)/2;
        if(start>last)
            return false;
        if (arr[pivot]>findNum)
            return binarySearch(arr, findNum, start, pivot-1);
        else if(arr[pivot]<findNum)
            return binarySearch(arr, findNum, pivot+1, last);
        else{
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for(int i=0;i<N;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for(int i=0;i<M;i++)
            System.out.println((binarySearch(arr, Integer.parseInt(st2.nextToken()), 0, N-1)) ? 1: 0);
    }
}

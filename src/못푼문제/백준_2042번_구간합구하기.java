package 못푼문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 백준_2042번_구간합구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long[] num;

    static int treeLength;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int temp = N;
        int pow = 0;
        while(temp>0){
            temp/=2;
            pow++;
        }

        treeLength = (int) Math.pow(2,pow)+N;
        num = new long[treeLength];

        for(int i=treeLength-N;i<treeLength;i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        calcSum(1);
    }

    static void calcSum(int index){
        if(index*2<treeLength){
            if(num[index*2]==0) calcSum(index*2);
            if(index*2+1<treeLength){
                if(num[index*2+1]==0) calcSum(index*2+1);
                num[index] = num[index*2]+num[index*2+1];
            }
            else num[index] = num[index*2];
        }
    }

    static long getSum(int left, int right, int leftSearch, int rightSearch, int index){
        return 0;
    }
}

package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_2470번_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[] arr=new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int posCount=0;
        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            if(arr[i]>0) posCount++;
        }
        Arrays.sort(arr);

        int[] negativeArr = new int[N-posCount];
        int[] positiveArr = new int[posCount];

        if (N - posCount >= 1) System.arraycopy(arr, 0, negativeArr, 0, N - posCount);
        if (posCount >= 1) System.arraycopy(arr, N - posCount, positiveArr, -posCount + posCount, N - (N - posCount));

        int negPivot=0, posPivot=positiveArr.length-1;

        int min=Math.abs(negativeArr[negPivot]+positiveArr[posPivot]);
        int acidNum=negPivot, alkNum=posPivot;

        while(acidNum<N-posCount & alkNum>=0){
            if(min>Math.abs(negativeArr[negPivot]+positiveArr[posPivot])){
                min=Math.abs(negativeArr[negPivot]+positiveArr[posPivot]);
                acidNum=negPivot;
                alkNum=posPivot;
            }
        }
    }
}

package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_1049번_기타줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N=Integer.parseInt(input[0]), M=Integer.parseInt(input[1]);
        int packMin=1001, indMin=1001;
        for(int i=0;i<M;i++){
            input=br.readLine().split(" ");
            packMin=Math.min(packMin,Integer.parseInt(input[0]));
            indMin=Math.min(indMin,Integer.parseInt(input[1]));
        }
        System.out.print(Math.min((N/6)*packMin+Math.min(packMin, (N%6)*indMin),N*indMin));
    }
}

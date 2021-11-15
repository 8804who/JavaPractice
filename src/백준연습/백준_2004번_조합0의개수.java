package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2004번_조합0의개수 {
    static int CheckTwo(long num){
        int Two=0;
        for(long div=2;div<=num;div*=2) {
            Two += num / div;
        }
        return Two;
    }
    static int CheckFive(long num){
        int Five=0;
        for(long div=5;div<=num;div*=5) {
            Five += num / div;
        }
        return Five;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        long n=Integer.parseInt(input[0]), m=Integer.parseInt(input[1]);
        int NumOfZero=Math.min(CheckTwo(n)-CheckTwo(m)-CheckTwo(n-m),CheckFive(n)-CheckFive(m)-CheckFive(n-m));
        System.out.print(NumOfZero);
    }
}
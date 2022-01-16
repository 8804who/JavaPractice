package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 백준_1629번_곱셈 {
    static Map<Long, Long> memo = new HashMap<>();
    static long power(long A, long B, long C){
        if(B==1) return A%C;
        else if(B>=2){
            if (B%2 == 0) {
                if (!memo.containsKey(B/2)){
                    memo.put(B/2, power(A%C, B/2, C)%C);
                }
                return (memo.get(B/2) * memo.get(B/2))%C;
            }
            else {
                if (!memo.containsKey(B/2)){
                    memo.put(B/2, power(A%C, B/2, C)%C);
                }
                return ((memo.get(B/2) * memo.get(B/2) % C) * A%C)%C;
            }
        }
        else return 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]), B = Integer.parseInt(input[1]), C = Integer.parseInt(input[2]);
        System.out.print(power(A,B,C));
    }
}
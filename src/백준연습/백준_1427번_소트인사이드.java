package 백준연습;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 백준_1427번_소트인사이드 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] N=sc.next().split("");
        Arrays.sort(N, Collections.reverseOrder());
        for (String n:N) {
            System.out.print(n);
        }
    }
}

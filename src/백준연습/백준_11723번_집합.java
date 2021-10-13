package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 백준_11723번_집합 {
    static boolean[] S=new boolean[21];
    static StringBuilder sb=new StringBuilder();
    static void add(int i){
        S[i]=true;
    }

    static void remove(int i){
        S[i]=false;
    }

    static void check(int i){
        if (S[i]) sb.append("1\n");
        else sb.append("0\n");
    }

    static void toggle(int i){
        if (S[i]) S[i]=false;
        else S[i]=true;
    }

    static void all(){
        for(int i=1;i<S.length;i++) S[i]=true;
    }

    static void empty(){
        for(int i=1;i<S.length;i++) S[i]=false;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int M=Integer.parseInt(br.readLine());
        String[] order;
        for (int i=0; i<M;i++){
            order=br.readLine().split(" ");
            if (order[0].equals("add")) add(Integer.parseInt(order[1]));
            else if (order[0].equals("remove")) remove(Integer.parseInt(order[1]));
            else if (order[0].equals("check")) check(Integer.parseInt(order[1]));
            else if (order[0].equals("toggle")) toggle(Integer.parseInt(order[1]));
            else if (order[0].equals("all")) all();
            else empty();
        }
        System.out.println(sb);
    }
}

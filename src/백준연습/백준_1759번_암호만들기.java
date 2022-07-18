package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_1759번_암호만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Stack<StringBuilder> stack = new Stack<>();

    static int L, C;
    static char[] alphabet;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);

        dfs(0,0, new StringBuilder(""));
        while(!stack.empty()) System.out.println(stack.pop());
    }
    static void dfs(int index, int depth, StringBuilder s){
        if(depth==L){
            int vowel=0;
            int consonant =0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='a' | s.charAt(i)=='e' | s.charAt(i)=='i' | s.charAt(i)=='o' | s.charAt(i)=='u') vowel++;
                else consonant++;
            }
            if(vowel>=1 & consonant>=2) stack.push(s);
            return;
        }
        if(index>=C) return;
        dfs(index+1, depth, new StringBuilder(s));
        dfs(index+1, depth+1, new StringBuilder(s.append(alphabet[index])));
    }
}

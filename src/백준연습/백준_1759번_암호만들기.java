package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 백준_1759번_암호만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Stack<char[]> stack = new Stack<>();

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

        dfs(0,0, new char[L]);
        while(!stack.empty()) sb.append(stack.pop()).append("\n");
        System.out.print(sb);
    }
    static void dfs(int index, int depth, char[] s){
        if(depth==L){
            int vowel=0;
            int consonant =0;
            for (char c : s) {
                if (c == 'a' | c == 'e' | c == 'i' | c == 'o' | c == 'u') vowel++;
                else consonant++;
            }
            if(vowel>=1 & consonant>=2) stack.push(s);
            return;
        }
        if(index>=C) return;
        char[] s2 = new char[L];
        System.arraycopy(s, 0, s2, 0, L);
        s2[depth]=alphabet[index];
        dfs(index+1, depth, s);
        dfs(index+1, depth+1, s2);
    }
}
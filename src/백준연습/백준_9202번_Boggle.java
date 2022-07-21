package 백준연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Word{
    char ch;
    int score=-1;

    boolean isHit=false;

    Word[] child = new Word[26];
    Word(char ch){
        this.ch = ch;
    }
    void cleanHit(){
        isHit=false;
        for(int i=0;i<26;i++){
            if(child[i]!=null) child[i].cleanHit();
        }
    }
}

public class 백준_9202번_Boggle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static char[][][] map;
    static boolean[][] visited = new boolean[5][5];
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static int[][] move = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    static int count, sum;
    static String maxLength;

    public static void main(String[] args) throws IOException {
        Word root = new Word((char) 0);
        int w = Integer.parseInt(br.readLine());
        for(int i=0;i<w;i++) {
            String s = br.readLine();
            makeTree(root, s, 0);
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        map = new char[b][5][5];
        for(int i=0;i<b;i++){
            for(int j=1;j<5;j++) {
                String s = br.readLine();
                for (int k = 1; k < 5; k++) map[i][j][k]=s.charAt(k-1);
            }
            if(i<b-1) br.readLine();
        }

        for(int i=0;i<b;i++) {
            maxLength = "";
            count = 0;
            sum = 0;
            for(int j=1;j<5;j++) {
                for(int k=1;k<5;k++) {
                    if(root.child[map[i][j][k]-'A']!=null)  {
                        DFS(root.child[map[i][j][k]-'A'], j, k, i);
                    }
                }
            }
            root.cleanHit();
            System.out.printf("%d %s %d\n", sum, maxLength, count);
        }
    }

    static void makeTree(Word w, String s, int index){
        if(index==s.length()) {
            w.score=score[s.length()];
            return;
        }
        if(w.child[s.charAt(index)-'A']==null){
            w.child[s.charAt(index)-'A']=new Word(s.charAt(index));
        }
        makeTree(w.child[s.charAt(index)-'A'], s, index+1);
    }

    static void DFS(Word w, int x, int y, int mapNumber){
        visited[x][y]=true;
        sb.append(w.ch);

        if(w.score!=-1 && !w.isHit){
            w.isHit=true;
            sum+=w.score;
            count++;
            if(sb.length()>maxLength.length()){
                maxLength = sb.toString();
            }else if(sb.length()==maxLength.length()){
                String[] s = {sb.toString(), maxLength};
                Arrays.sort(s);
                maxLength = s[0];
            }
        }

        for (int i = 0; i < 8; i++) {
            int movedX = x + move[i][0];
            int movedY = y + move[i][1];
            if (5 > movedX && movedX > 0 && 5 > movedY && movedY > 0) {
                char c = map[mapNumber][movedX][movedY];
                if(!visited[movedX][movedY] && w.child[c-'A']!=null) {
                    DFS(w.child[c-'A'], movedX, movedY, mapNumber);
                }
            }
        }
        visited[x][y]=false;
        sb.deleteCharAt(sb.length()-1);
    }
}
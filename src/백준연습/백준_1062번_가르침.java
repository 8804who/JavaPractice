package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 백준_1062번_가르침{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[] alpha = new boolean[26];
    static int N, K;
    static int selectedCount;
    static int max=0;
    static String[] words;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        if(K<5) System.out.print("0");
        else if(K==26) {
            System.out.print(N);
        }
        else{
            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
                words[i] = words[i].replaceAll("[antic]","");
            }

            alpha['a'-'a']=true;
            alpha['n'-'a']=true;
            alpha['t'-'a']=true;
            alpha['i'-'a']=true;
            alpha['c'-'a']=true;
            selectedCount=5;

            /*for(int i=0;i<26;i++){
                Search(i);
            }*/
            Search(0);
            System.out.print(max);
        }
    }

    static void Search(int index){
        if(!alpha[index]) {
            alpha[index] = true;//1.체크인
            selectedCount++;
        }
        if(selectedCount==K){//2.목적지인가
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean isValid = true;
                for(int j=0;j < words[i].length();j++){
                    if(!alpha[words[i].charAt(j)-'a']) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid) count++;
            }
            max = Math.max(count, max);
        }else{
            for(int i = index+1;i<26;i++){//3.연결된 곳을 순회
                if(!alpha[i]){//4.갈 수 있는가
                    Search(i);//5.간다
                }
            }
        }
        alpha[index] = false;//6.체크아웃
        selectedCount--;
    }
}
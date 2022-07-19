package 백준연습;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Frame implements Comparable<Frame>{
    int studentNumber;
    int recommendCount;
    int turn;
    Frame(int recommend, int i){
        studentNumber = recommend;
        recommendCount = 0;
        turn = i;
    }

    @Override
    public int compareTo(Frame o) {
        int comp = Integer.compare(recommendCount, o.recommendCount);
        if(comp==0) return Integer.compare(turn, o.turn);
        else return comp;
    }
}

public class 백준_1713번_후보추천하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int recommend;

        st = new StringTokenizer(br.readLine());
        Frame[] frames = new Frame[N];
        for(int i=0;i<N;i++) frames[i]=new Frame(0,0);

        for (int i = 0; i < M; i++) {
            recommend=Integer.parseInt(st.nextToken());
            boolean isExist = false;
            for (int j = 0; j < N; j++) {
                if (frames[j].studentNumber == 0) {
                    frames[j].studentNumber = recommend;
                    frames[j].turn = i;
                    isExist = true;
                    break;
                } else if (frames[j].studentNumber == recommend) {
                    frames[j].recommendCount++;
                    isExist = true;
                    break;
                }
            }
            if(!isExist){
                Arrays.sort(frames);
                frames[0].studentNumber=recommend;
                frames[0].recommendCount=0;
                frames[0].turn=i;
            }
        }

        Comparator<Frame> comp = Comparator.comparingInt(o -> o.studentNumber);

        Arrays.sort(frames, comp);
        for(int i=0;i<N;i++){
            if(frames[i].studentNumber!=0) System.out.print(frames[i].studentNumber+" ");
        }
    }
}
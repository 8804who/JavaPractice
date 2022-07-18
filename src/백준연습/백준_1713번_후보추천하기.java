package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_1713번_후보추천하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] candidate = new int[N][3];
        int recommend;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            recommend=Integer.parseInt(st.nextToken());
            boolean isExist = false;
            for (int j = 0; j < N; j++) {
                if (candidate[j][0] == 0) {
                    candidate[j][0] = recommend;
                    candidate[j][2] = i;
                    isExist = true;
                    break;
                } else if (candidate[j][0] == recommend) {
                    candidate[j][1]++;
                    isExist = true;
                    break;
                }
            }

            if (!isExist) {
                int min = 1001;
                int deleteNum = 0;
                for (int j = 0; j < N; j++) {
                    if (min > candidate[j][1]) {
                        min = candidate[j][1];
                        deleteNum = j;
                    } else if (min == candidate[j][1]) {
                        if (candidate[deleteNum][2] > candidate[j][2]) deleteNum = j;
                    }
                }
                candidate[deleteNum][0] = recommend;
                candidate[deleteNum][1] = 0;
                candidate[deleteNum][2] = i;
            }
        }

        Arrays.sort(candidate, (o1, o2) -> {return o1[0]-o2[0];});
        for(int i=0;i<N;i++){
            if(candidate[i][0]!=0) System.out.print(candidate[i][0]+" ");
        }
    }
}
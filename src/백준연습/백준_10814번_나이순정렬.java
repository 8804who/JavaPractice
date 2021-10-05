package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 백준_10814번_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        String[][] arr=new String[201][N];
        for(int i=0;i<N;i++){
            String[] s=br.readLine().split(" ");
            arr[Integer.parseInt(s[0])][i]=s[1];
        }
        int count=0;
        for(int i=1;i<201;i++){
            if(count==N)
                break;
            for(int j=0;j<N;j++) {
                if ((arr[i][j] != null) && (count==N-1)) {
                    System.out.printf("%d %s", i, arr[i][j]);
                    count+=1;
                    break;
                }
                if (arr[i][j] != null) {
                    System.out.printf("%d %s\n", i, arr[i][j]);
                    count += 1;
                }
            }
        }
    }
}

package 백준연습;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class 백준_2143번_두배열의합 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long count = 0;
    static int n, m, T;
    static int[] A;
    static int[] B;

    static List<Long> subA = new ArrayList<>();
    static List<Long> subB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        n = Integer.parseInt(br.readLine());
        A = new int[n];
        inputArr(n,A);

        m =Integer.parseInt(br.readLine());
        B = new int[m];
        inputArr(m, B);

        inputSubArr(n, A, subA);
        inputSubArr(m, B, subB);

        Collections.sort(subA);
        subB.sort(Comparator.reverseOrder());

        int ptA = 0;
        int ptB = 0;

        while(true) {
            long numA = subA.get(ptA);
            long numB = subB.get(ptB);
            if (numA + numB == T) {
                long countA = 0;
                long countB = 0;
                while (ptA<subA.size() && subA.get(ptA) == numA) {
                    countA++;
                    ptA++;
                }
                while (ptB<subB.size() && subB.get(ptB) == numB) {
                    countB++;
                    ptB++;
                }
                count+=countA*countB;
            } else if (numA + numB > T) {
                ptB++;
            } else {
                ptA++;
            }
            if (ptA == subA.size() || ptB == subB.size()) {
                break;
            }
        }
        System.out.print(count);
    }

    static void inputArr(int l, int[] arr) throws IOException{
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<l;i++) arr[i]=Integer.parseInt(st.nextToken());
    }

    static void inputSubArr(int l, int[] arr, List<Long> list){
        for(int i=0;i<l;i++){
            long sum=0;
            for(int j=i;j<l;j++){
                sum=sum+arr[j];
                list.add(sum);
            }
        }
    }
}

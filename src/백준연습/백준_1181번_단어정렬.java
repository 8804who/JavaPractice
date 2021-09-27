package 백준연습;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1181번_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        List<String> word=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String input=br.readLine();
            if(!word.contains(input))
                word.add(input);
        }
        Collections.sort(word);
        word.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }else
                    return Integer.compare(o1.length(),o2.length());
            }
        });
        for(String i : word)
            System.out.println(i);
    }
}

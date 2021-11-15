package 연습;

public class 팩토리얼 {
    public static void main(String[] args){
        long[] factorial=new long[21];
        factorial[1]=1;
        for(int i=2;i<factorial.length;i++){
            factorial[i]=factorial[i-1]*i;
        }
        System.out.println(factorial[20]);
    }
}

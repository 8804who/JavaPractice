package 연습;

import java.math.BigInteger;

public class 자료구조및알고리즘과제 {
    public static void main(String[] args){
        BigInteger num = new BigInteger("2");
        num=num.pow(67).subtract(new BigInteger("1"));
        BigInteger sq = sqrt(num).add(new BigInteger("1"));

        System.out.println("2**67-1: "+num);
        System.out.println("2**67-1의 제곱근: "+sq);

        BigInteger div = new BigInteger("2");
        while(true){
            if(num.mod(div).equals(new BigInteger("0"))) {
                System.out.println(div+"로 나눌경우 나머지 0이므로 소수가 아님");
                break;
            }
            else div=div.add(new BigInteger("1"));
            if(div.equals(sq.add(new BigInteger("1")))) {
                System.out.println("이 수는 소수입니다.");
                break;
            }
        }
    }

    public static BigInteger sqrt(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
}

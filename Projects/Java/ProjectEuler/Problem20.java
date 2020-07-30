package ProjectEuler;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem20 {

    public static void main(String[] args) {

        String n = factorial(new BigInteger("100")).toString();
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < n.length(); i++) {
            char t = n.charAt(i);
            a.add(((int)t)-48);
        }

        Integer sum = 0;
        for (Integer e : a) {
            //System.out.print(e);
            sum+=e;
        }
        System.out.println(sum);

    }
    public static BigInteger factorial(BigInteger n){
        if (n.toString().equals("1"))
            return new BigInteger("1");
        else
            return n.multiply(factorial(n.subtract(new BigInteger("1"))));

    }
/*
    n! means n × (n − 1) × ... × 3 × 2 × 1

    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

    Find the sum of the digits in the number 100!
*/
}

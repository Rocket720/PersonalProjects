package ProjectEuler;

import java.util.ArrayList;

public class Problem21 {

    public static void main(String[] args) {

        ArrayList amicable = new ArrayList();
        for (int i = 1; i < 10000; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 1; j < i; j++) {
                if (i%j==0)
                    sum1+=j;
            }
            for (int j = 1; j < sum1; j++) {
                if (sum1%j==0)
                    sum2+=j;
            }
            if (sum2==i)
                amicable.add(i);
        }
        System.out.println(amicable);
        int sum3 = 0;
        for (Object o : amicable) {
            sum3+=(int)o;
        }
        System.out.println(sum3);
    }

}

package ProjectEuler;

import java.util.Scanner;

public class JLew {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int l, i, s, p, o, g, c, r;
        int lisp, logic, prolog;


        for (int l1 = 0; l1 < 10; l1++) {
            l = l1;
            target:
            for (int l2 = 0; l2 < 10; l2++) {
                i = l2;
                for (int l3 = 0; l3 < 10; l3++) {
                    s = l3;
                    for (int l4 = 0; l4 < 3; l4++) {
                        p = l4;
                        for (int l5 = 0; l5 < 10; l5++) {
                            o = l5;
                            for (int l6 = 0; l6 < 10; l6++) {
                                g = l6;
                                for (int l7 = 0; l7 < 10; l7++) {//this problem gives me aids
                                    c = l7;
                                    for (int l8 = 0; l8 < 10; l8++) {
                                        r = l8;

                                        if (l == i || l == s || l == p || l == o || l == g || l == c || l == r || i == s || i == p || i == o || i == g || i == c || i == r || s == p || s == o || s == g || s == c || s == r || p == o || p == g || p == c || p == r || o == g || o == c || o == r || g == c || g == r || c == r)
                                            continue target;

                                        lisp = (1000 * l) + (100 + i) + (10 * s) + p;
                                        logic = (10000 * l) + (1000 + o) + (100 * g) + (10 * i) + c;
                                        prolog = (100000 * p) + (10000 + r) + (1000 * o) + (100 * l) + (10 * o) + g;

                                        if (lisp + logic == prolog)
                                            System.out.println("lisp = " + lisp + " logic = " + logic + " prolog = " + prolog);
                                    }
                                }
                            }
                        }
                    }
                }
            }


        }
    }
}
package MathX;

public class MathX{

    static int accuracy = -7;
    public static String derivative(String n){
        return n;
    }
    private static double leftReimann(double a, double b){
        double Summation = 0;
        for (double i = a; i < b; i+=Math.pow(10, accuracy)) {
            Summation+=g(i)*Math.pow(10, accuracy);
        }
        return Summation;
    }
    private static double rightReimann(double a, double b){
        double Summation = 0;
        for (double i = b; i > a; i-=Math.pow(10, accuracy)) {
            Summation+=g(i)*Math.pow(10, accuracy);
        }
        return Summation;
    }
    public static double Reimann(double a, double b){
        System.out.println(leftReimann(a, b) + " " + rightReimann(a, b));
        return (leftReimann(a, b) + rightReimann(a, b))/2;
    }
    private static double g(double x){
        return Math.pow(x, 2) ;
    }

}

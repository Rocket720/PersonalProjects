package MathX;

public class Reimann{

    double accuracy = -7;
    public Reimann(double acc){
        accuracy = -acc;
    }
    private double midReimann(double a, double b){
        double Summation = 0;
        for (double i = a+Math.pow(10, accuracy); i < b; i+=Math.pow(10, accuracy)) {
            Summation+=f((i+Math.pow(10, accuracy)/2))*Math.pow(10, accuracy);
        }
        return Summation;
    }
    private double endReimann(double a, double b){
        return (f(a)*Math.pow(10, accuracy))+(f(b)*Math.pow(10, accuracy));
    }
    public double Reimann(double a, double b){
        System.out.println("Taking the integral of f(x) from bounds " + a + " to " + b);
        double end = endReimann(a, b);
        double mid = midReimann(a, b);
        return (end+mid)/2;
    }

    private double f(double x){
        return Math.pow(x, 2);
    }

}

import java.text.DecimalFormatSymbols;
import java.util.Scanner;

/**
 * Created by Luis on 25/05/2016.
 */
public class Tolerance {
    public static void main(String[] args) {
        Tolerance objTolerance = new Tolerance();
        char decimalSeparator = objTolerance.getDecimalSeparator();

        System.out.println("KEEP IN MIND THAT CURRENT DECIMAL SEPARATOR CHARACTER IS: " + decimalSeparator);
        double v1 = objTolerance.askValue("Value 1");
        double v2 = objTolerance.askValue("Value 2");
        double t = objTolerance.askValue("Tolerance %");

        System.out.println("Value 1 = " + v1);
        System.out.println("Value 2 = " + v2);
        System.out.println("Tolerance = " + t + "%");
        System.out.println("Difference admitted = " + objTolerance.admitted(v1,v2,t));
    }

    private double askValue(String valueName){
        double v;
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert " + valueName +": ");
        v = sc.nextDouble();
        return v;
    }

    private boolean admitted(double v1, double v2, double tolerance){
        double minAllowed = v1 * (1 - (tolerance / 100));
        double maxAllowed = v1 * (1 + (tolerance / 100));

        System.out.println("Minimum allowed (" + v1 + " * " + (100 - tolerance) + "%) = " + minAllowed);
        System.out.println("Maximum allowed (" + v1 + " * " + (100 + tolerance) + "%) = " + maxAllowed);

        if (v2<minAllowed){
            System.out.println(v2 + "<" + minAllowed);
        }

        if (v2>maxAllowed){
            System.out.println(v2 + ">" + minAllowed);
        }

        if (v2>=minAllowed && v2 <= maxAllowed){
            System.out.println("[" + minAllowed + "] <= " + v2 + " <= [" + maxAllowed + "]");
            return true;
        }

        return false;
    }

    private char getDecimalSeparator(){
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        return dfs.getDecimalSeparator();
    }

}

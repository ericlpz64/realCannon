import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static Double isNull(String value) {
        if (value.equals("null"))
            return null;

        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        Double viInput;
        Double vfInput;
        Double aInput;
        Double mInput;
        Double deltaxInput;
        Double timeInput;
        Double thetaInput;

        Scanner sc = new Scanner(System.in);
        System.out.print("Input Initial Velocity: ");
        viInput = isNull(sc.next());
        System.out.print("Input Final Velocity: ");
        vfInput = isNull(sc.next());
        System.out.print("Input Acceleration: ");
        aInput = isNull(sc.next());
        System.out.print("Input Mass: ");
        mInput = isNull(sc.next());
        System.out.print("Input Δx: ");
        deltaxInput = isNull(sc.next());
        System.out.print("Input Time: ");
        timeInput = isNull(sc.next());
        System.out.print("Input θ: ");
        thetaInput = isNull(sc.next());

        CannonEquations Teracotta = new CannonEquations(viInput, vfInput, aInput, mInput, deltaxInput, timeInput,
                thetaInput);
        // Teracotta.CannonEquations(50.0, 45.0, null, null, 37.2, 1.4,
        // 15.0);//vi,vf,a,m,delatx,time,theta

        if (Teracotta.m == null) {
            System.out.println("please measure the mass of this item in kg");
        }
        if (Teracotta.vi == null) {
            System.out.println("found missing initial velocity: " + Teracotta.toString(Teracotta.missingvi()));
        }
        if (Teracotta.vf == null) {
            System.out.println("found missing final velocity: " + Teracotta.toString(Teracotta.missingvf()));
        }
        if (Teracotta.theta == null && 
            Teracotta.x != null) {
            System.out.println("found missing θ: " + Teracotta.toString(Teracotta.missingtheta()));
        Teracotta.missingvx();
        Teracotta.missingvy();}
        if (Teracotta.theta != null){
        Teracotta.missingvx();
        Teracotta.missingvy();
        }

        if (Teracotta.a == null &&
            Teracotta.time != null) {
            System.out.println("found missing acceleration: " + Teracotta.toString(Teracotta.missinga()));
        }
        if (Teracotta.a == null &&
            Teracotta.time == null) {
            System.out.println("found missing acceleration: " + Teracotta.toString(Teracotta.missingawt()));
        }
        if (Teracotta.time == null) {
            System.out.println("found missing time: " + Teracotta.toString(Teracotta.missingtime()));
        }
        if (Teracotta.x == null) {
            System.out.println("found missing Δx: " + Teracotta.toString(Teracotta.missingx()));
        }
        if (Teracotta.theta == null) {
            System.out.println("found missing θ: " + Teracotta.toString(Teracotta.missingtheta()));
        }
        
        Teracotta.writeFile(
    "\n" + "Initial Velocity: " + Teracotta.toString(Teracotta.vi) + 
    "\n" + "Final Velocity: " + Teracotta.toString(Teracotta.vf) +
    "\n" + "Acceleration: " + Teracotta.toString(Teracotta.a) +
    "\n" + "Mass: " + Teracotta.toString(Teracotta.m) +
    "\n" + "Δx: " + Teracotta.toString(Teracotta.x) +
    "\n" + "Time: " + Teracotta.toString(Teracotta.time) +
    "\n" + "θ: " + Teracotta.toString(Teracotta.theta));

    }

}
import java.util.Scanner;
class Main {
    public static Double isNull(String value) {
        if (value.equals("null")) return null;

        try {
            return Double.parseDouble(value);
        } catch (Exception e) { e.printStackTrace(); }


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
        System.out.println("Input Initial Velocity: ");
        viInput = isNull(sc.nextLine());
        System.out.println("Input Final Velocity: ");
        vfInput = isNull(sc.nextLine());
        System.out.println("Input Acceleration: ");
        aInput = isNull(sc.nextLine());
        System.out.println("Input Mass: ");
        mInput = isNull(sc.nextLine());
        System.out.println("Input Δx: ");
        deltaxInput = isNull(sc.nextLine());
        System.out.println("Input Time: ");
        timeInput = isNull(sc.nextLine());
        System.out.println("Input θ: ");
        thetaInput = isNull(sc.nextLine());
        
        CannonEquations Teracotta = new CannonEquations(viInput, vfInput, aInput, mInput, deltaxInput, timeInput, thetaInput);
        //Teracotta.CannonEquations(50.0, 45.0, null, null, 37.2, 1.4, 15.0);//vi,vf,a,m,delatx,time,theta
        { 
            if(Teracotta.vi == null){
            System.out.println("found missing initial velocity: " + Teracotta.missingvi());
            }
            if(Teracotta.vf == null){
            System.out.println("found missing final velocity: " + Teracotta.missingvf());
            }
            if(Teracotta.a == null){
            System.out.println("found missing acceleration: " + Teracotta.missinga());
            }
            if(Teracotta.m == null){
            System.out.println("please measure the mass of this item");
            }
            if(Teracotta.x == null){
            System.out.println("found missing Δx: " + Teracotta.missingx());
            }
            if(Teracotta.time == null){
            System.out.println("found missing time: " + Teracotta.missingtime());
            }
            if(Teracotta.theta == null){
            System.out.println("found missing θ: " + Teracotta.missingtheta());
            }
        }
    }
}
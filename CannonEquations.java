import java.util.Scanner;
import java.lang.Math;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class CannonEquations {
    Double vi;
    Double vf;
    Double a;
    Double m;
    Double x;
    Double time;
    Double theta;
    Double vix;
    Double vfx;
    Double viy;
    Double vfy;
    Double viS;
    Double vfS;
    Double aS;
    Double mS;
    Double deltaxS;
    Double timeS;
    Double thetaS;
    
    // if a variable is missing input null
    public CannonEquations(

        Double velocityinitial,
        Double velocityfinal,
        Double acceleration,
        Double mass,
        Double deltax,
        Double deltaTime,
        Double thetaAngle) {

        vi = velocityinitial;
        vf = velocityfinal;
        a = acceleration;
        m = mass;
        x = deltax;
        time = deltaTime;
        theta = thetaAngle;
    }

    public Double missingvi() {
        if (a == 0.0) {
            vi = vf;
        } else {
            vi = vf + ((a * time) * -1);
        }
        return vi;
    }

    public Double missingvf() {
        if (a == 0.0) {
            vf = vi;
        } else {
            vf = vi + (a * time);
        }
        return vf;
    }

    public Double missinga() {
        if (vi == vf) {
            a = 0.0;
        } else {
            a = (vf - vi) / time;
        }
        return a;
    }

    public Double missingawt() {
        if (vi == vf) {
            a = 0.0;
        } else {
            a = ((vf * vf) - (vi * vi)) / (2.0 * x);
        }
        return a;
    }

    public void missingvy() {
        Double thetar = Math.toRadians(theta);
        Double thetas = Math.sin(thetar);
        viy = thetas * vi;
        vfy = thetas * vf;
    }

    public void missingvx() {
        Double thetar = Math.toRadians(theta);
        Double thetac = Math.cos(thetar);
        vix = thetac * vi;
        vfx = thetac * vf;
    }

    public Double missingx() {
        if (a != 0.0) {
            x = (((vfx * vfx) - (vix * vix))) / (2.0 * a);
        } else {
            x = ((vfx + vix) / 2.0) * time;
        }
        return x;
    }

    public Double missingtime() {
        time = (vf - vi) / a;
        return time;
    }

    public Double missingtheta() {
        theta = 0.5 * (Math.toDegrees(Math.asin((9.81 * x) / (vi * vi))));
        return theta;
    }

    public String toString(Double varReal){
        if (varReal == null){return "unknown";}
        if(varReal == vi){return varReal + "㎧";}
        if(varReal == vf){return varReal + "㎧";}
        if(varReal == a){return varReal + "㎧²";}
        if(varReal == m){return varReal + "kg";}
        if(varReal == x){return varReal + "m";}
        if(varReal == time){return varReal + "s";}
        if(varReal == theta){return varReal + "°";}
        else return "woops";
    }
    public static void writeFile(String real) {
        try {
            File data = new File("result.txt");
            Scanner reader = new Scanner(data);
            String str = "";
            while (reader.hasNextLine())
                str += reader.nextLine() + "\n";
            FileWriter f = new FileWriter("result.txt");
            f.write(str);
            f.write("\n" + "New Run:");
            f.write(real);
            f.close();
        } catch (IOException e) {
            System.out.println("failed to write to result.txt");
        }
    }
    /*
     * public Double airDensity() {
     * 
     * }
     */
}
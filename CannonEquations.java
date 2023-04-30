import java.lang.Math;

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
        vi = vf + ((a * time) * -1);
        vix = vi * (Math.toDegrees(Math.cos(theta)));
        return vi;
    }

    public Double missingvf() {
        vf = vi + (a * time);
        vfx = vf * (Math.toDegrees(Math.cos(theta)));
        return vf;
    }

    public Double missinga() {
        a = (vf - vi) / time;
        return a;
    }

    public Double missingawt() {
        a = ((vf * vf) - (vi - vi)) / (2 * x);
        return a;
    }

    public Double missingx() {
        Double thetar = Math.toRadians(theta);
        Double thetax = Math.cos(thetar);
        vix = thetax * vi;
        vfx = thetax * vf;
        if (a != 0.0) {
            x = (((vfx * vfx) - (vix * vix))) / (2 * a);
        } else {
            x = ((vfx + vix) / 2) * time;
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
}
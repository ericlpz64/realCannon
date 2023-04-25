import java.lang.Math;
public class CannonEquations {
    Double vi;
    Double vf;
    Double a;
    Double m;
    Double x;
    Double time;
    Double theta;
    //if a variable is missing input null
    public CannonEquationsSetAll(
        
    Double velocityinitial,
    Double velocityfinal,
    Double acceleration,
    Double mass,
    Double deltax,
    Double deltaTime,
    Double thetaAngle){
            
    vi = velocityinitial;
    vf = velocityfinal;
    a = acceleration;
    m = mass;
    x = deltax;
    time = deltaTime;
    theta = thetaAngle;
    }

    
    public Double missingvi(){
         vi = vf + ((a*time)*-1);
        return vi;
    }
    public Double missingvf(){
         vf = vi + (a*time);
        return vf;
    }
        
    public Double missinga(){
         a = (vf-vi)/time;
        return a;
    }
    
    public Double missingx(){
         x = ((vi + vf)/2) * time;
        return x;
    }

    public Double missingtime(){
        time = (vf - (-1 * vi))/a ;
       return time;
   }

   public Double missingtheta(){
    theta = 1/2 *(math.asin);
    return theta;
   }
    
}
public class E2G {
    double a,b,c;
    public E2G(double a_,double b_,double c_){
    a=a_;
    b=b_;
    c=c_;
    }
    public double discriminante(){
    return b*b-4*a*c;
    }
    public double[] raices(){
    double[] r=new double[2];
    double d=discriminante();
    r[0]=-b+Math.sqrt(d)/(2*a);
    r[1]=-b-Math.sqrt(d)/(2*a);
    return r;
    }
    public static void main(String[] args) {
    double a=1,b=2,c=1;
    E2G eq=new E2G(a,b,c);
    double[] r=eq.raices();
    System.out.printf("soluciones de la ecuación: %.1f x2 %+.1f x %+.1f= [x= %.1f, x=%.1f]",a,b,c,r[0],r[1]);
    }
}

public class RaicesImaginarias extends
Exception{
double real, imag;
public RaicesImaginarias (double r, double
i){
real=r; imag=i;
}
public double getReal(){
return real;
}
public double getImag(){
return imag;
}
}
public class E2G {
    double a,b,c;
    public E2G(double a_,double b_,double c_){
    a=a_; b=b_; c=c_;
    }
    public double discriminante(){
    return b*b-4*a*c;
    }
    public double[] raices()throws RaicesImaginarias{
    double[] r=new double[2], d=discriminante();
    if (d<0)
    throw new RaicesImaginarias(-b/(2*a), Math.sqrt(-d)/(2*a));
    r[0]=-b+Math.sqrt(d)/(2*a);
    r[1]=-b-Math.sqrt(d)/(2*a);
    return r;
    }
    public static void main(String[] args) {
    double a=1,b=2,c=2;
    try{
    E2G eq=new E2G(a,b,c);
    double[] r=eq.raices();
    System.out.printf("soluciones de la ecuación: “+ ”%.1f x2 %+.1f x %+.1f= [x= %.1f, x= %.1f]",a,b,c,r[0],r[1]);
    }
    catch (RaicesImaginarias e){
    System.out.printf("soluciones de la ecuación: “+ ”%.1f x2 %+.1f x %+.1f= Raices imaginarias [x= %.1f %+.1f i , x= %.1f %+.1fi]",a,b,c,e.getReal(),e.getImag(),e.getReal(),-e.getImag());
    }
    }
}
package mygame;
import java.io.*;
public class Frisbee {
    public static final double MASS=0.172;
    private static final double GRAVITY=-9.82;
    private static final double DENSITY=1.23;
    private static final double SURFAREA=0.0568;
    private static final double LIFT0=0.1;
    private static final double LIFTA=1.4;
    private static final double DRAG0=0.08;
    private static final double DRAGA=2.72;
    private static final double ANGLEOFF=-4;
    private double lift;
    private double drag;
    private double x=0;
    private double y=1.1684;
    private double vx;
    private double vy;
    private double time=0;
    private double mass;
    private long millisStart=-1;
    private boolean wait=true;
    private PrintStream csv;
    public Frisbee(double v0,double angle,double mass) {
        vx=v0*Math.cos(torad(angle));
        vy=v0*Math.sin(torad(angle));
        this.mass=mass;
        lift=LIFT0+LIFTA*torad(angle);
        drag=DRAG0+DRAGA*Math.pow(torad(angle-ANGLEOFF),2);
        try {
            csv=new PrintStream(new FileOutputStream("/home/anirudh/Projects/Robotics/frisbee-simulations/"+System.currentTimeMillis()+".csv"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public float toFeet(float meters) {
        return (meters*(float)3.218);
    }
    public void step() {
        if(millisStart<0) {
            millisStart=System.currentTimeMillis();
            return;
        }
        if(wait) {
            if(System.currentTimeMillis()-millisStart>2000) {
                wait=false;
                millisStart=System.currentTimeMillis();
            }
            return;
        }
        long millis=System.currentTimeMillis()-millisStart;
        double seconds=millis*1.0/1000.0;
        double dt=seconds-time;
        time=seconds;
        double v=Math.sqrt(vx*vx+vy*vy);
        double dvx=(-1*drag*DENSITY*SURFAREA*Math.pow(vx,2)/2.0/mass)*dt;
        double dvy=(lift*DENSITY*SURFAREA*Math.pow(vx,2)/2.0/mass+GRAVITY)*dt;
//        double dvx=(lift*SURFAREA*DENSITY*Math.pow(v,2)/2+GRAVITY)/mass;
//        double dvy=-(drag*SURFAREA*DENSITY*Math.pow(v,2)/2)/mass;
        vx+=dvx;
        vy+=dvy;
        x+=vx*dt;
        y+=vy*dt;
        System.out.println(dvy);
        csv.println(time+","+toFeet((float)x)+","+toFeet((float)y));
    }
    private double torad(double deg) {
        return deg*(Math.PI/180);
    }
}

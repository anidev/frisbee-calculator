#include <iostream>
#include <cmath>
#include "convert.h"
#include "flight.h"
#include "goals.h"

void do_goals_calculations(double v0,double y0) {
	y0=tometers(y0);
	std::cout.precision(3);
	std::cout<<"DEG\tLOW\tMID\tHIGH"<<std::endl;
	for(double a=LOW_ANGLE;a<=HIGH_ANGLE;a+=ANGLE_STEP) {
		double vx0=v0*std::cos(torad(a));
		double vy0=v0*std::sin(torad(a));
		std::cout<<a<<"°\t";
		std::cout<<tofeet(simulate_flight(vx0,vy0,a,DELTAT,tometers(LOW_TARGET-y0)))<<"\t";
		std::cout<<tofeet(simulate_flight(vx0,vy0,a,DELTAT,tometers(MID_TARGET-y0)))<<"\t";
		std::cout<<tofeet(simulate_flight(vx0,vy0,a,DELTAT,tometers(HIGH_TARGET-y0)))<<std::endl;
	}
}

void do_find_velocity(double angle,double _dist,double y0) {
	std::cout.precision(3);
	std::cout<<"V0\tDIST"<<std::endl;
	for(double i=20.0;i<100.0;i+=0.1) {
		double vx0=tometers(i)*std::cos(torad(angle));
		double vy0=tometers(i)*std::sin(torad(angle));
		std::cout<<i<<"\t";
		double dist=tofeet(simulate_flight(vx0,vy0,angle,DELTAT,tometers(MID_TARGET-y0)));
		std::cout<<dist<<std::endl;
	}
}


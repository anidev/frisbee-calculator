#include <iostream>
#include <cmath>
#include "convert.h"
#include "flight.h"
#include "goals.h"

void do_goals_calculations(double v0) {
	std::cout.precision(3);
	std::cout<<"DEG\tLOW\tMID\tHIGH"<<std::endl;
	for(double a=LOW_ANGLE;a<=HIGH_ANGLE;a+=ANGLE_STEP) {
		double vx0=v0*std::cos(torad(a));
		double vy0=v0*std::sin(torad(a));
		std::cout<<a<<"°\t";
		std::cout<<tofeet(simulate_flight(vx0,vy0,a,DELTAT,tometers(LOW_TARGET)))<<"\t";
		std::cout<<tofeet(simulate_flight(vx0,vy0,a,DELTAT,tometers(MID_TARGET)))<<"\t";
		std::cout<<tofeet(simulate_flight(vx0,vy0,a,DELTAT,tometers(HIGH_TARGET)))<<std::endl;
	}
}


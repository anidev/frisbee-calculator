#include <iostream>
#include <cmath>
#include "convert.h"
#include "flight.h"
#include "goals.h"

int main() {
/*	double angle=10;
	double v0=20.0;
	double vx0=v0*cos(torad(angle));
	double vy0=v0*sin(torad(angle));
	std::cout<<simulate_flight(vx0,vy0,angle,0.001,24.384)<<std::endl;*/
//	do_goals_calculations(tometers(81.5),46.0/12);
	do_find_velocity(22.0,32.0,46.0/12.0);
}

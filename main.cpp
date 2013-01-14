#include <iostream>
#include <cmath>
#include "flight.h"

int main() {
	double angle=20;
	double v0=15.0;
	double vx0=v0*cos(torad(angle));
	double vy0=v0*sin(torad(angle));
	std::cout<<simulate_flight(vx0,vy0,angle,0.1,24.384)<<std::endl;
}

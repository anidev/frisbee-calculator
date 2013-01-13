#include <iostream>
#include <cmath>
#include "flight.h"

int main() {
	double angle=10;
	double v0=30.0;
	double vx0=v0*cos(torad(angle));
	double vy0=v0*sin(torad(angle));
	std::cout<<simulate_flight(vx0,vy0,5,0.1,24.384)<<std::endl;
}

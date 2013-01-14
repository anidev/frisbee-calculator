#define _USE_MATH_DEFINES
#include <cmath>
#include <iostream>
#include "flight.h"

double torad(double degrees) {
	return degrees*(M_PI/180);
}

double simulate_flight(double vx0,double vy0,double angle,double dt,double height,double mass) {
	double lift=LIFT0+LIFTA*torad(angle);
	double drag=DRAG0+DRAGA*pow(torad(angle-ANGLEOFF),2);
	double x=0;
	double y=0;
	double vx=vx0;
	double vy=vy0;
	double time=0;
	for(int i=0;y<=height;i++) {
		/*
		 * dvx = delta x velocity, d = density, m = mass, A = surface area,
		 *       D = drag coefficient, dt = delta time, v = previous x velocity
		 *
		 * dvx = (1/2m) * d * v^2 * A * D * dt 
		 */
		double dvx=(-1*drag*DENSITY*SURFAREA*pow(vx,2)/2.0/mass)*dt;
		/*
		 * dvy = delta y velocity, d = density, g = gravity, m = mass, A = surface area,
		 *       L = lift coefficient, dt = delta time, v = previous y velocity
		 *
		 * dvy = (g + (1/2m) * d * p * v^2 * A * L) * dt
		 */
		double dvy=(lift*DENSITY*SURFAREA*pow(vx,2)/2.0/mass+GRAVITY)*dt;
		vx+=dvx;
		vy+=dvy;
		x+=vx*dt;
		y+=vy*dt;
		if(y<0) {
			return -1;
		}
	}
	return x;
}

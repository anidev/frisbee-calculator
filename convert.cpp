#define _USE_MATH_DEFINES
#include <cmath>
#include "convert.h"

double torad(double deg) {
	return deg*(M_PI/180.0);
}

double todeg(double rad) {
	return rad*180.0/M_PI;
}

double tofeet(double meters) {
	return meters*3.281;
}

double tometers(double feet) {
	return feet/3.281;
}


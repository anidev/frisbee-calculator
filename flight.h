#ifndef FLIGHT_H
#define FLIGHT_H

static const double GRAVITY=-9.82; //!< m/s^2
static const double MASS=0.175; //!< kg
static const double DENSITY=1.23; //!< of air, kg/m^3
static const double SURFAREA=0.0531; //!< of frisbee
static const double LIFT0=0.15; //!< lift coefficient at alpha=0
static const double LIFTA=1.4; //!< lift coefficient dependent on alpha
static const double DRAG0=0.08; //!< drag coefficient at alpha=0
static const double DRAGA=2.72; //!< drag coefficient dependent on alpha
static const double ANGLEOFF=-4; //!< alpha angle offset

double torad(double);

/*! Calculates distance traveled given parameters.
 * \param vx0 Initial x velocity
 * \param vy0 Initial y velocity
 * \param angle Angle of launch
 * \param dt Delta time (i.e. time intervals for Euler's method)
 * \param height Target height
 * \param mass Mass of frisbee (default MASS=0.172kg)
 * \return Distance traveled by frisbee
 */
double simulate_flight(double vx0,double vy0,double angle,double dt,double height,double mass=MASS);

#endif // FLIGHT_H

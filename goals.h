#ifndef GOALS_H
#define GOALS_h

static const double LOW_TARGET=31.0;
static const double MID_TARGET=793.0/8.0;
static const double HIGH_TARGET=881.0/8.0;

static const double LOW_ANGLE=0.0;
static const double HIGH_ANGLE=60.0;
static const double ANGLE_STEP=1.0;

static const double DELTAT=0.001;

void do_goals_calculations(double);

#endif // GOALS_H

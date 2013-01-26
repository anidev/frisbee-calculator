public class GlobalMembersFlight
{
	///#define _USE_MATH_DEFINES

	public static final double GRAVITY = -9.82; //!< m/s^2
	public static final double MASS = 0.175; //!< kg
	public static final double DENSITY = 1.23; //!< of air, kg/m^3
	public static final double SURFAREA = 0.0531; //!< of frisbee
	public static final double LIFT0 = 0.15; //!< lift coefficient at alpha=0
	public static final double LIFTA = 1.4; //!< lift coefficient dependent on alpha
	public static final double DRAG0 = 0.08; //!< drag coefficient at alpha=0
	public static final double DRAGA = 2.72; //!< drag coefficient dependent on alpha
	public static final double ANGLEOFF = -4; //!< alpha angle offset

	//double torad(double NamelessParameter);Tangible Method Implementation Not Found-torad
public static double simulate_flight(double vx0, double vy0, double angle, double dt, double height)
{
	return simulate_flight(vx0, vy0, angle, dt, height, MASS);
}

	/*! Calculates distance traveled given parameters.
	 * \param vx0 Initial x velocity
	 * \param vy0 Initial y velocity
	 * \param angle Angle of launch
	 * \param dt Delta time (i.e. time intervals for Euler's method)
	 * \param height Target height
	 * \param mass Mass of frisbee (default MASS=0.172kg)
	 * \return Distance traveled by frisbee
	 */
//C++ TO JAVA CONVERTER NOTE: Java does not allow default values for parameters. Overloaded methods are inserted above:
//ORIGINAL LINE: double simulate_flight(double vx0, double vy0, double angle, double dt, double height, double mass =MASS)
	public static double simulate_flight(double vx0, double vy0, double angle, double dt, double height, double mass)
	{
		double lift = LIFT0 + LIFTA * GlobalMembersConvert.torad(angle);
		double drag = DRAG0 + DRAGA * Math.pow(GlobalMembersConvert.torad(angle - ANGLEOFF),2);
		double x = 0;
		double y = 0;
		double vx = vx0;
		double vy = vy0;
		double time = 0;
		for (int i = 0;y <= height;i++)
		{
			/*
			 * dvx = delta x velocity, d = density, m = mass, A = surface area,
			 *       D = drag coefficient, dt = delta time, v = previous x velocity
			 *
			 * dvx = (1/2m) * d * v^2 * A * D * dt
			 */
			double dvx = (-1 * drag * DENSITY * SURFAREA * Math.pow(vx,2) / 2.0 / mass) * dt;
			/*
			 * dvy = delta y velocity, d = density, g = gravity, m = mass, A = surface area,
			 *       L = lift coefficient, dt = delta time, v = previous y velocity
			 *
			 * dvy = (g + (1/2m) * d * p * v^2 * A * L) * dt
			 */
			double dvy = (lift * DENSITY * SURFAREA * Math.pow(vx,2) / 2.0 / mass + GRAVITY) * dt;
			vx += dvx;
			vy += dvy;
			x += vx * dt;
			y += vy * dt;
			if (y < 0)
			{
				return -1;
			}
		}
		return x;
	}
}
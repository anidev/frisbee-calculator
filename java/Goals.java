public class Goals
{
	public static final double LOW_TARGET = 31.0;
	public static final double MID_TARGET = 793.0 / 8.0;
	public static final double HIGH_TARGET = 881.0 / 8.0;

	public static final double LOW_ANGLE = 0.0;
	public static final double HIGH_ANGLE = 60.0;
	public static final double ANGLE_STEP = 1.0;

	public static final double DELTAT = 0.001;

	public static void do_goals_calculations(double v0)
	{
		System.out.print("DEG\tLOW\tMID\tHIGH");
		System.out.print("\n");
		for (double a = LOW_ANGLE;a <= HIGH_ANGLE;a += ANGLE_STEP)
		{
			double vx0 = v0 * Math.cos(Convert.torad(a));
			double vy0 = v0 * Math.sin(Convert.torad(a));
			System.out.print(a);
			System.out.print("\t");
			System.out.print(Convert.tofeet(Flight.simulate_flight(vx0, vy0, a, DELTAT, Convert.tometers(LOW_TARGET))));
			System.out.print("\t");
			System.out.print(Convert.tofeet(Flight.simulate_flight(vx0, vy0, a, DELTAT, Convert.tometers(MID_TARGET))));
			System.out.print("\t");
			System.out.print(Convert.tofeet(Flight.simulate_flight(vx0, vy0, a, DELTAT, Convert.tometers(HIGH_TARGET))));
			System.out.print("\n");
		}
	}
}
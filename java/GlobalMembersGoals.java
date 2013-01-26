public class GlobalMembersGoals
{
	//C++ TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
	///#if ! GOALS_H
	//C++ TO JAVA CONVERTER TODO TASK: #define macros defined in preprocessor conditionals can only be replaced within the scope of the preprocessor conditional:
	///#define GOALS_h

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
			double vx0 = v0 * Math.cos(GlobalMembersConvert.torad(a));
			double vy0 = v0 * Math.sin(GlobalMembersConvert.torad(a));
			System.out.print(a);
			System.out.print("°\t");
			System.out.print(GlobalMembersConvert.tofeet(GlobalMembersFlight.simulate_flight(vx0, vy0, a, DELTAT, GlobalMembersConvert.tometers(LOW_TARGET))));
			System.out.print("\t");
			System.out.print(GlobalMembersConvert.tofeet(GlobalMembersFlight.simulate_flight(vx0, vy0, a, DELTAT, GlobalMembersConvert.tometers(MID_TARGET))));
			System.out.print("\t");
			System.out.print(GlobalMembersConvert.tofeet(GlobalMembersFlight.simulate_flight(vx0, vy0, a, DELTAT, GlobalMembersConvert.tometers(HIGH_TARGET))));
			System.out.print("\n");
		}
	}
	///#endif
}
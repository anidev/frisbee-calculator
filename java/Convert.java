public class Convert
{
	public static double torad(double deg)
	{
		return deg * (Math.PI / 180.0);
	}
	public static double todeg(double rad)
	{
		return rad * 180.0 / Math.PI;
	}
	public static double tofeet(double meters)
	{
		return meters * 3.281;
	}
	public static double tometers(double feet)
	{
		return feet / 3.281;
	}
}
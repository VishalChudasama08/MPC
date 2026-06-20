/*
 * The distance between two cities (in KM) is input through the keyboard. Write a program to convert and print this distance in meters, feet, inches and centimeters.
 */

public class L16_km_to {
	public static void main(String[] args) {
		float km = 250f;
		float me = km * 1000f;
		float feet = me * 3.28083f;
		float inch = km * 39370.0f;
		float cm = km * 100000f;

		System.out.print(
				"\nkm: " + km + ", meters: " + me + ", feet: " + feet + ", inches: " + inch + ", centimeters: " + cm);
	}
}

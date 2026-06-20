/*
 * Prepare a pay slip.
Employee code, basic salary
Calculate as below:
DA is 180% of basic, HRA is 10% of Basic, PF is 14% of Basic.
Gross Total= DA+HRA+Basic.
Net Salary=Gross Salary – PF
 */

import java.util.*;

public class L15_pay_slip {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter basic salary: ");
		float bs = scan.nextFloat();
		float da = bs * 1.8f;
		float hra = bs * 0.1f;
		float pf = bs * 1.4f;

		float gt = da + hra + bs;
		float nt = gt - pf;
		System.out.print("\nGross Total = " + gt + "\r\n" + //
				"Net Salary = " + nt);
		scan.close();
	}
}

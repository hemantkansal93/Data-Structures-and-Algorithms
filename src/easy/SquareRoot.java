package easy;

import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = sc.nextInt();
		System.out.println("The square root of the given number is  " + mySqrt(number));
		sc.close();
	}

//	Use LONG to accommodate m*m term (which can be very large)
//	Main condition: l<=h
//	find middle
//	Compare m*m with given number
//	since answer has be to floored, we are assigning answer in (number<x) block but not in (number>x)
//	Casting is very important to do return answer in integer.
	public static int mySqrt(int x) {
		if( x < 2)
			return x;
		long l = 0;
		long h = x;
		long ans = 0;
		while (l <= h) {
			long m = l + (h - l) / 2;
			long number = m * m;
			if (number == x) {
				return(int)m;
			} else if (number > x) {
				h = m - 1;
			} else {
				ans = m;
				l = m + 1;
			}
		}
		return (int) ans;
	}
}

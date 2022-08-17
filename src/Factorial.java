import java.util.Scanner;

public class Factorial {

	public static void  main (String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		System.out.println("Factorial: " + factorial(number));
		input.close();
	}
	
	
	public static int factorial(int n) {
		int ans;
		
		if(n>0) {
			ans = n*factorial(n-1);
		}
		else {
			ans = 1;
		}
		
		return ans;
		
	}
	
}

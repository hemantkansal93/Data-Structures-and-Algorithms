
public class FibonacciSeriesUsingRecursion {
	public static void main (String[] args) {
		int a = 0; 
		int b = 1; 
		int n = 7;
		System.out.print(a +"\t");
		System.out.print(b +"\t");
		printNextNumber(a,b,n-2);
		
		
	}
	public static void  printNextNumber(int a , int b, int n) {
		if(n==0) {
			return;
		}
		int c =a+b;
		System.out.print(c+"\t");
		printNextNumber(b,c,n-1);
	}

}

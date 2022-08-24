package hard;

public class Largest_Reactangle_Histogram {

	public static void main(String[] args) {
		int heights[] = {2,1,5,6,2,3};
		int area = findLargestRectangle(heights);
		System.out.println("The area of largest rectangle in histograms is " + area);
	}

	private static int findLargestRectangle(int[] heights) {
		int n = heights.length;
		int maxArea = 0;
		
		int[] ns = nextSmaller(heights);
		int[] ps = previousSmaller(heights);
		
		for( int i= 0 ; i < n; i++) {
			int area = (ns[i] - ps[i] -1)*heights[i];
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	private static int[] previousSmaller(int[] heights) {
		int n = heights.length;
		int[] ps = new int[n];
		java.util.Stack<Integer> s = new java.util.Stack<>();
		for( int i = 0; i < n; i++) {
			while(! s.isEmpty() && heights[i] <= heights[s.peek()]) {
				s.pop();
			}
			if(s.isEmpty()) {
				ps[i] = -1;
			}
			else {
				ps[i] = s.peek();
			}
			s.push(i);
		}
		return ps;
	}

	private static int[] nextSmaller(int[] heights) {
		int n = heights.length;
		int[] ns = new int[n];
		java.util.Stack<Integer> s = new java.util.Stack<>();
		for( int i = n-1; i >=0; i--) {
			while(! s.isEmpty() && heights[i] <= heights[s.peek()]) {
				s.pop();
			}
			if(s.isEmpty()) {
				ns[i] = n;
			}
			else {
				ns[i] = s.peek();
			}
			s.push(i);
		}
		return ns;
	}
}

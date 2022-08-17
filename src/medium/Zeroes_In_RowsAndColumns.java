package medium;

public class Zeroes_In_RowsAndColumns {

	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
		
		makeZeroes(matrix);
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0 ; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] +"\t");
			}
			System.out.println();
		}

	}

	private static void makeZeroes(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int col0 = 1;
		for(int i = 0; i < rows; i++) {
			if(matrix[i][0] == 0) {
				col0 = 0;
			}
			for(int j = 1 ; j < cols; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
//		Traversing in reverse order so that we can avoid first row zeroes 
//		(in other way traversal otherwise) if first row is set to zeroes,
//		then all corresponding columns which whole matrix would be set to zero.
		for(int i = rows-1; i >= 0; i--) {
			for(int j = cols-1 ; j >= 1; j--) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
//			Keeping record of rows if any row's first element is zero ( reference column--left most column) 
//			If we do it in conventional way then we would make whole column = 0 
//			and then during traversal we would make all rows zero and eventually the matrix =0 
			if(col0 == 0) {
				matrix[i][0] = 0;
			}
		}
	}

}

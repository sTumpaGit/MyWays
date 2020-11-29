package DSA_practices;

public class MatrixCoFactors {

	public static void main(String[] args) {
		int[][] A = {
				{1,2,3},
				{0,4,5},
				{1,0,6}
		};
		
		int[] X = {1,0,0};
		int[] Y = {2,2,1};
		
		int[][] ans_matrix = new int[3][3];
		int count = 0;
		for(int row=0; row<3; row++) {
			for(int col=0; col<3; col++) {
				//passing count for returning negative result for 
				//every odd count 
				ans_matrix[row][col] = findCofactorDeterminant(row,col,X,Y,A,count);
				count++;
			}
		}
		printMatrix(ans_matrix);
		
	}

	private static void printMatrix(int[][] ans_matrix) {
		for(int row=0; row<3; row++) {
			for(int col=0; col<3; col++) {
				System.out.print(ans_matrix[row][col]+"\t");
			}
			System.out.println();
		}
	}

	private static int findCofactorDeterminant(int row, int col, int[] x, int[] y, int[][] mat, int count) {
		
		int row1=0, row2=0;
		if(row==0) {
			row1 = 1;
			row2 = 2;
		}
		if(row==1) {
			row1 = 0;
			row2 = 2;
		}
		if(row==2) {
			row1 = 0;
			row2 = 1;
		}
		
		int det = (mat[row1][x[col]] * mat[row2][y[col]]) - (mat[row1][y[col]] * mat[row2][x[col]]);
		
				//passing count for returning negative result for 
				//every odd count 
		if(count%2 == 0) return det;
		return -det;
	}

}

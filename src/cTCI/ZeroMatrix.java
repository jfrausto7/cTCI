package cTCI;

public class ZeroMatrix {
	
	public static int[][] ZeroMatrix(int[][]matrix){
		int m = matrix[0].length;
		int n = matrix.length;
		System.out.println(n);
		System.out.println(m);
		boolean[] rows = new boolean[n];
		boolean[] cols = new boolean[m];
		
		//iterate through matrix
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		for(int x=0; x < rows.length; x++) {
			if(rows[x]) {
			for(int y = 0; y<m; y++) {
				matrix[x][y] = 0;
				}
			}
		}
		
		for(int y=0; y < cols.length; y++) {
			if(cols[y]) {
			for(int x = 0; x<n; x++) {
				matrix[x][y] = 0;
				}
			}
		}
		return matrix;
	}
	
	//driver code
	public static void main(String[] args) {
		int[][] test = new int[4][3];
		int number = 1;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				test[i][j] = number;
				number++;
				System.out.print(test[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		
		//add zeroes
		test[0][2] = 0;
		test[1][1] = 0;
		test[2][1] = 0;
		
		
		
		
		//actually test method
		test = ZeroMatrix(test);
		
		
		//print out matrix to check
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(test[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}

}

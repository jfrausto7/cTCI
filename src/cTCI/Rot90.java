package cTCI;

import java.util.Scanner;

public class Rot90 {
	
	public static int[][] rot90(int[][] image){
		int temp;
		int n = image.length;
		
		//iterative nested for loops to go through matrix
		for(int i = 0; i < n/2; i++) {
			for(int j = i; j < n-i-1; j++) {
				//setup temporary value
				temp = image[i][j];
				
				//left to top
				image[i][j] = image[j][n-1-i];
				
				//bottom to left
				image[j][n-1-i] = image[n-1-i][n-1-j];
				
				//right to bottom
				image[n-1-i][n-1-j] = image[n-1-j][i];
				
				//assign top values
				image[n-1-j][i] = temp;
			}
		}
		return image;
	}
	
	//method to actually create the matrix image in ascending values
	public static int[][] createMatrix(int value){
		int[][] matrix = new int[value][value];
		int number = 1;
		for(int j = 0; j < value; j++) {
			for(int i = 0; i < value; i++) {
				matrix[i][j] = number;
				number++;
			}
		}
		return matrix;
	}
	
	//driver code
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number to make a n * n array and rotate it: ");
		int value = scanner.nextInt();
		
		int[][] matrix = createMatrix(value);
		int[][] newMatrix = rot90(matrix);
		
		System.out.println("Your rotated array is: \n");
		
		//print out matrix to check
		for(int j = 0; j < value; j++) {
			for(int i = 0; i < value; i++) {
				System.out.print(newMatrix[i][j]);
				System.out.print(" ");	// we could use a bit of spacing here
			}
			System.out.print("\n");
		}
		
	}

}

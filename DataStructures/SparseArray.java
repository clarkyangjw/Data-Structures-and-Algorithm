package DataStructures;

public class SparseArray {
	
	public static void main(String[] args) {
		// Create an 2D Array 11*11
		// 0:no chess pieces 	1:black chess pieces		2:white chess pieces
		int chessArray1[][] = new int[11][11];
		chessArray1[1][2] = 1;
		chessArray1[2][3] = 2;
		chessArray1[4][5] = 1;
		chessArray1[6][7] = 2;
		// Print the original chess board
		System.out.println("Original chess board:");
		for (int[] row : chessArray1) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
		//Convert the 2D Array to the Sparse Array
		//1.Iterate the 2D Array and count the number of non-zero data
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArray1[i][j] != 0) {
					sum++;
				}
			}
		}
		
		//2.Create the Sparse Array
		int sparseArray[][] = new int[sum + 1][3];
		//assign the value to the Sparse Array
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		
		//3.Iterate the 2D Array  and assign the valid data to the sparseArray
		int count = 0; 
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArray1[i][j] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessArray1[i][j];
				}
			}
		}
		
		//4.Print the Sparse Array
		System.out.println();
		System.out.println("Compressed chess board");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
		}
		System.out.println();
		
		
		//Recover the Sparse Array to the 2D Array
		//1.Read the first line of the Sparse Array and create a 2D Array
		int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		

		//2.Read the rest line of the Sparse Array and assign the value to the 2D array
		for(int i = 1; i < sparseArray.length; i++) {
			chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		
		//3.Print the recovered 2D Array
		System.out.println();
		System.out.println("Recivered chess board");
		
		for (int[] row : chessArr2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
	}
	
}
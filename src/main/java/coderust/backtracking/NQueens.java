package coderust.backtracking;

public class NQueens {
	int N;
	boolean[][] board;

	public NQueens(int n) {
		N = n;
		board = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = false;
			}
		}
	}

	public boolean solveNQueens() {
		return solveNQueensRecur(0);
	}

	private boolean solveNQueensRecur(int queenNumber) {
		if(queenNumber >= N) {
			return true;
		}
		// Try placing queen in each column of that row and check if there is any collision
		for(int j = 0; j < N; j++) {
			if(isSafe(queenNumber, j)) {
				board[queenNumber][j] = true;
				if(solveNQueensRecur(queenNumber + 1)) {
					return true;
				}
				board[queenNumber][j] = false;
			}
		}
		return false;
	}

	// Check if queen queenNumber can be safely placed on board[queenNumber][column]
	// return false if there is a collision in the queen's path
	private boolean isSafe(int queenNumber, int column) {
		// 1. check all rows above in the same column
		for(int i = 0; i < queenNumber; i++) {
			if(board[i][column]) return false;
		}

		// 2. Check the upper diagonal on left side
		for(int i=queenNumber-1, j=column-1; i>=0 && j>=0; i--,j--) {
			if(board[i][j]) return false;
		}

		// 3. check the upper diagonal on right side
		// System.out.println("Checking upper diagonal " + queenNumber + " " + column + " N=" + N);
		for(int i = queenNumber, j=column; i>=0 && j < N; --i,++j) {
			// System.out.println(i + " " + j);
			if(board[i][j]) return false;
		}
		return true;
	}

	private void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j != 0) {
					System.out.print(",");
				}
				System.out.print(board[i][j] ? 1 : 0);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 6;
		NQueens nq = new NQueens(N);
		if (nq.solveNQueens()) {
			nq.printBoard();
		}
	}
}
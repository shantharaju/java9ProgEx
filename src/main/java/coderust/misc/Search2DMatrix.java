package coderust.misc;

public class Search2DMatrix {

	/*
	 * O(n+m) solution. Start from last row and first element.
	 * Adjust i and j accordingly
	 */
	public boolean search1(int[][] arr, int target) {
		int n = arr.length;
		int m = arr[0].length;
		int i = n-1;
		int j = 0;
		while(i >=0 && j<= m-1) {
			if(arr[i][j] > target) {
				i--;
			}
			else if(arr[i][j] < target) {
				j++;
			}
			else {
				System.out.println("[" + i + "," + j + "]");
				return true;
			}
		}
		return false;
	}

	/*
	 * O(log(nm)) solution. Treat entire 2D matrix as a list.
	 * Works iff:
	 * 1) Integers in each row are sorted from left to right. 
	 * 2) The first integer of each row is greater than the last integer of the previous row.
	 * Ex: 
	 * [[1,  3,  5,  7],
	 * [10, 11, 16, 20],
	 * [23, 30, 34, 50]]
	 */
	public boolean search2(int[][] arr, int target) {
		int n = arr.length;
		int m = arr[0].length;
		int l = 0;
		int r = n*m - 1;
		while(l <= r) {
			System.out.println("[" + l + "," + r + "]");
			int mid = (l + r) >> 1;
			int i = mid / m; 
			int j = mid % m;
			if(arr[i][j] < target) {
				l = mid + 1;
			}
			else if (arr[i][j] > target) {
				r = mid - 1;
			}
			else {
				System.out.println("[" + i + "," + j + "]");
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] arr = { {1, 4, 7, 11, 15},
						{2, 5, 8, 12, 19},
						{3,   6,  9, 16, 22},
						{10, 13, 14, 17, 24},
						{18, 21, 23, 26, 30}};
		int target = 12;
		Search2DMatrix s = new Search2DMatrix();
		System.out.println(s.search1(arr, target));
		System.out.println(s.search2(arr, target));

	}

}

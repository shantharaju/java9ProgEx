package hackerrank;

import java.util.Scanner;

public class StairCase {

	
	public static void initialize(char[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = ' ';
		}
	}
	public static void main(String[] args) {
		int n = 0;
		try (Scanner scan = new Scanner(System.in)) {
			n = scan.nextInt();
		}
		char[] arr = new char[n];
		for(int i = 0,j=n-1; i<n; i++,j--) {
			initialize(arr);
			for(int k = j; k<n; k++) {
				arr[k] = '#';
			}
		    System.out.println(new String(arr));
		}
	}
}

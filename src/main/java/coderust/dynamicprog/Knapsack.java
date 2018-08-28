package coderust.dynamicprog;

import java.util.ArrayList;
import java.util.List;

/**
 * B[0,w] = 0
 * B[i,0] = 0
 * B[i,w] = B[i-1,w] if wi > w
 * B[i,w] = max(B[i-1,w], B[i-1,w-wi] + vi) if wi <= w
 * 
 * find B[n,w]
 * 
 * 
 */
public class Knapsack {
	static class Bag {
		int benefit;
		int weight;

		public Bag(int v, int w) {
			benefit = v;
			weight = w;
		}
	}

	public List<Bag> findOptimum(Bag[] bags, int weight) {
		int[][] B = new int[bags.length + 1][weight + 1];
		for (int j = 0; j <= weight; j++) {
			B[0][j] = 0;
		}
		for (int i = 0; i <= bags.length; i++) {
			B[i][0] = 0;
		}
		for (int i = 1; i <= bags.length; i++) {
			for (int w = 1; w <= weight; w++) {
				if (bags[i - 1].weight > w) {
					B[i][w] = 0;
					continue;
				}
				B[i][w] = Math.max(B[i - 1][w], B[i - 1][w - bags[i - 1].weight] + bags[i - 1].benefit);
			}
		}
		for (int i = 0; i <= bags.length; i++) {
			for (int w = 0; w <= weight; w++) {
				System.out.print(B[i][w] + ", ");
			}
			System.out.println();
		}

		int n = bags.length;
		int m = weight;
		List<Bag> l = new ArrayList<>();

		while (n > 0 && m > 0) {
			if ((n == 0 || m == 0)) {
				break;
			}
			if (bags[n - 1].weight > m) {
				n--;
				continue;
			}
			if (bags[n - 1].benefit + B[n - 1][m - bags[n - 1].weight] > B[n - 1][m]) {
				l.add(bags[n - 1]);
				m = m - bags[n - 1].weight;
			}
			n--;
		}
		return l;
	}

	public static void main(String[] args) {
//		int weight = 10;
//		Bag[] bags = { new Bag(10, 5), new Bag(40, 4), new Bag(30, 6), new Bag(50, 3) };

		int weight = 50;
		Bag[] bags = {new Bag(60, 10), new Bag(100, 20), new Bag(120, 30)};
		Knapsack k = new Knapsack();
		List<Bag> optBags = k.findOptimum(bags, weight);
		optBags.forEach(x -> System.out.println("(" + x.benefit + "," + x.weight + ")"));
	}
}
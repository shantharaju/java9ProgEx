package hackerrank;

import java.util.EnumMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/queens-attack-2/problem
public class QueenMoves {

	static class Coordinate {
		int x = -1;
		int y = -1;
		public Coordinate(int x1, int y1) {
			x = x1;
			y = y1;
		}
		
		// x - y
		static int distance(Coordinate p1, Coordinate p2) {
			if((p1.x == -1 && p1.y == -1) || ((p2.x == -1) && (p2.y == -1))) return Integer.MAX_VALUE;
			
			if(p1.x == p2.x) {
				return Math.abs(p1.y - p2.y);
			}
			if(p1.y == p2.y) {
				return Math.abs(p1.x - p2.x);
			}
			return Math.abs(p1.x - p2.x);
		}

		static boolean IsUnitSlope(Coordinate p1, Coordinate p2) {
			double slope = (p1.x - p2.x)*1.0/(p1.y - p2.y);
			return ((slope == Math.floor(slope)) && (slope == 1.0));
		}
	}
	enum Direction {
		NW,
		N,
		NE,
		E,
		SE,
		S,
		SW,
		W
	};
	public static void main(String[] args) {
		Coordinate Q = new Coordinate(5,3);
		// Input
		Coordinate[] blockers = { new Coordinate(6,2),
								  new Coordinate(3,1),
								  new Coordinate(1,7),
								  new Coordinate(7,5),
								  new Coordinate(8,3),
								  new Coordinate(5,7),
								  new Coordinate(2,3),
								  new Coordinate(5,2)};
		Map<Direction, Coordinate> minBlocker = new EnumMap<Direction, Coordinate>(Direction.class);
		minBlocker.put(Direction.N, new Coordinate(-1, -1));
		minBlocker.put(Direction.NW, new Coordinate(-1, -1));
		minBlocker.put(Direction.NE, new Coordinate(-1, -1));
		minBlocker.put(Direction.S, new Coordinate(-1, -1));
		minBlocker.put(Direction.SW, new Coordinate(-1, -1));
		minBlocker.put(Direction.SE, new Coordinate(-1, -1));
		minBlocker.put(Direction.E, new Coordinate(-1, -1));
		minBlocker.put(Direction.W, new Coordinate(-1, -1));
		// input scan
		for(Coordinate c : blockers) {
			// check N, S, E, W condition
			if(Q.y == c.y) {
				// N
				if(c.x > Q.x) {
					if(Coordinate.distance(minBlocker.get(Direction.N), Q) > Coordinate.distance(c, Q)) {
						minBlocker.put(Direction.N, c);
					}
				}
				else { // S
					if(Coordinate.distance(minBlocker.get(Direction.S), Q) > Coordinate.distance(c, Q)) {
						minBlocker.put(Direction.S, c);
					}
				}
			}
			if(Q.x == c.x) {
				// E
				if(c.y > Q.y) {
					if(Coordinate.distance(minBlocker.get(Direction.E), Q) > Coordinate.distance(c, Q)) {
						minBlocker.put(Direction.E, c);
					}
				}
				else { // W
					if(Coordinate.distance(minBlocker.get(Direction.W), Q) > Coordinate.distance(c, Q)) {
						minBlocker.put(Direction.W, c);
					}
				}
			}
			if(!Coordinate.IsUnitSlope(c, Q)) continue;
			
			if(Q.x < c.x) {
				// NW
				if(Q.y > c.y) {
					if(Coordinate.distance(minBlocker.get(Direction.NW), Q) > Coordinate.distance(c, Q)) {
						minBlocker.put(Direction.NW, c);
					}
				}
				else { // NE
					if(Coordinate.distance(minBlocker.get(Direction.NE), Q) > Coordinate.distance(c, Q)) {
						minBlocker.put(Direction.NE, c);
					}
				}
			}
			else {
				// SW
				if(Q.y > c.y) {
					if(Coordinate.distance(minBlocker.get(Direction.SW), Q) > Coordinate.distance(c, Q)) {
						minBlocker.put(Direction.SW, c);
					}
				}
				else { // NE
					if(Coordinate.distance(minBlocker.get(Direction.SE), Q) > Coordinate.distance(c, Q)) {
						minBlocker.put(Direction.SE, c);
					}
				}
			}
		}
		int distance = 0;
		for(Coordinate c : minBlocker.values()) {
			distance += Coordinate.distance(Q, c);
		}
		distance -= 8;
		System.out.println("distance = " + distance);
	}

}

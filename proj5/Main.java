package proj5;

import java.sql.Time;

public class Main {

	static void initCompleteUSMap(Map map) {
		map.states.add("Alabama");			// 0
		map.states.add("Alaska");			// 1
		map.states.add("Arizona");			// 2
		map.states.add("Arkansas");			// 3
		map.states.add("California");		// 4
		map.states.add("Colorado");			// 5
		map.states.add("Connecticut");		// 6
		map.states.add("Delaware");			// 7
		map.states.add("Florida");			// 8
		map.states.add("Georgia");			// 9
		map.states.add("Hawaii");			// 10
		map.states.add("Idaho");			// 11
		map.states.add("Illinois");			// 12
		map.states.add("Indiana");			// 13
		map.states.add("Iowa");				// 14
		map.states.add("Kansas");			// 15
		map.states.add("Kentucky");			// 16
		map.states.add("Louisiana");		// 17
		map.states.add("Maine");			// 18
		map.states.add("Maryland");			// 19
		map.states.add("Massachusetts");	// 20
		map.states.add("Michigan");			// 21
		map.states.add("Minnesota");		// 22
		map.states.add("Mississippi");		// 23
		map.states.add("Missouri");			// 24
		map.states.add("Montana");			// 25
		map.states.add("Nebraska");			// 26
		map.states.add("Nevada");			// 27
		map.states.add("New Hampshire");	// 28
		map.states.add("New Jersey");		// 29
		map.states.add("New Mexico");		// 30
		map.states.add("New York");			// 31
		map.states.add("North Carolina");	// 32
		map.states.add("North Dakota");		// 33
		map.states.add("Ohio");				// 34
		map.states.add("Oklahoma");			// 35
		map.states.add("Oregon");			// 36
		map.states.add("Pennsylvania");		// 37
		map.states.add("Rhode Island");		// 38
		map.states.add("South Carolina");	// 39
		map.states.add("South Dakota");		// 40
		map.states.add("Tennessee");		// 41
		map.states.add("Texas");			// 42
		map.states.add("Utah");				// 43
		map.states.add("Vermont");			// 44
		map.states.add("Virginia");			// 45
		map.states.add("Washington");		// 46
		map.states.add("West Virginia");	// 47
		map.states.add("Wisconsin");		// 48
		map.states.add("Wyoming");			// 49

		map.borders.add(new Border(0, 8));
		map.borders.add(new Border(0, 9));
		map.borders.add(new Border(0, 23));
		map.borders.add(new Border(0, 41));
		map.borders.add(new Border(2, 4));
		map.borders.add(new Border(2, 27));
		map.borders.add(new Border(2, 30));
		map.borders.add(new Border(2, 43));
		map.borders.add(new Border(3, 17));
		map.borders.add(new Border(3, 23));
		map.borders.add(new Border(3, 24));
		map.borders.add(new Border(3, 35));
		map.borders.add(new Border(3, 41));
		map.borders.add(new Border(3, 42));
		map.borders.add(new Border(4, 27));
		map.borders.add(new Border(4, 36));
		map.borders.add(new Border(5, 15));
		map.borders.add(new Border(5, 26));
		map.borders.add(new Border(5, 30));
		map.borders.add(new Border(5, 35));
		map.borders.add(new Border(5, 43));
		map.borders.add(new Border(5, 49));
		map.borders.add(new Border(6, 20));
		map.borders.add(new Border(6, 31));
		map.borders.add(new Border(6, 38));
		map.borders.add(new Border(7, 19));
		map.borders.add(new Border(7, 29));
		map.borders.add(new Border(7, 37));
		map.borders.add(new Border(8, 9));
		map.borders.add(new Border(9, 32));
		map.borders.add(new Border(9, 39));
		map.borders.add(new Border(9, 41));
		map.borders.add(new Border(11, 25));
		map.borders.add(new Border(11, 27));
		map.borders.add(new Border(11, 36));
		map.borders.add(new Border(11, 43));
		map.borders.add(new Border(11, 46));
		map.borders.add(new Border(11, 49));
		map.borders.add(new Border(12, 13));
		map.borders.add(new Border(12, 14));
		map.borders.add(new Border(12, 16));
		map.borders.add(new Border(12, 24));
		map.borders.add(new Border(12, 48));
		map.borders.add(new Border(13, 16));
		map.borders.add(new Border(13, 21));
		map.borders.add(new Border(13, 34));
		map.borders.add(new Border(14, 22));
		map.borders.add(new Border(14, 24));
		map.borders.add(new Border(14, 26));
		map.borders.add(new Border(14, 40));
		map.borders.add(new Border(14, 48));
		map.borders.add(new Border(15, 24));
		map.borders.add(new Border(15, 26));
		map.borders.add(new Border(15, 35));
		map.borders.add(new Border(16, 24));
		map.borders.add(new Border(16, 34));
		map.borders.add(new Border(16, 41));
		map.borders.add(new Border(16, 45));
		map.borders.add(new Border(16, 47));
		map.borders.add(new Border(17, 23));
		map.borders.add(new Border(17, 42));
		map.borders.add(new Border(18, 28));
		map.borders.add(new Border(19, 37));
		map.borders.add(new Border(19, 45));
		map.borders.add(new Border(19, 47));
		map.borders.add(new Border(20, 28));
		map.borders.add(new Border(20, 31));
		map.borders.add(new Border(20, 38));
		map.borders.add(new Border(20, 44));
		map.borders.add(new Border(21, 34));
		map.borders.add(new Border(21, 48));
		map.borders.add(new Border(22, 33));
		map.borders.add(new Border(22, 40));
		map.borders.add(new Border(22, 48));
		map.borders.add(new Border(23, 41));
		map.borders.add(new Border(24, 26));
		map.borders.add(new Border(24, 35));
		map.borders.add(new Border(24, 41));
		map.borders.add(new Border(25, 33));
		map.borders.add(new Border(25, 40));
		map.borders.add(new Border(25, 49));
		map.borders.add(new Border(26, 40));
		map.borders.add(new Border(26, 49));
		map.borders.add(new Border(27, 36));
		map.borders.add(new Border(27, 43));
		map.borders.add(new Border(28, 44));
		map.borders.add(new Border(29, 31));
		map.borders.add(new Border(29, 37));
		map.borders.add(new Border(30, 35));
		map.borders.add(new Border(30, 42));
		map.borders.add(new Border(30, 43));
		map.borders.add(new Border(31, 37));
		map.borders.add(new Border(31, 44));
		map.borders.add(new Border(32, 39));
		map.borders.add(new Border(32, 41));
		map.borders.add(new Border(32, 45));
		map.borders.add(new Border(33, 40));
		map.borders.add(new Border(34, 37));
		map.borders.add(new Border(34, 47));
		map.borders.add(new Border(35, 42));
		map.borders.add(new Border(36, 46));
		map.borders.add(new Border(37, 47));
		map.borders.add(new Border(40, 49));
		map.borders.add(new Border(41, 45));
		map.borders.add(new Border(43, 49));
		map.borders.add(new Border(45, 47));
	}

	/**
	 * Initializes the map of the states in the South West of the USA
	 * @param map The map to be initialized
	 */
	static void initMap(Map map) {
		map.states.add("North Carolina");
		map.states.add("South Carolina");
		map.states.add("Virginia");
		map.states.add("Tennessee");
		map.states.add("Kentucky");
		map.states.add("West Virginia");
		map.states.add("Georgia");
		map.states.add("Alabama");
		map.states.add("Mississippi");
		map.states.add("Florida");

		map.borders.add(new Border(0, 1));
		map.borders.add(new Border(0, 2));
		map.borders.add(new Border(0, 3));
		map.borders.add(new Border(0, 6));
		map.borders.add(new Border(1, 6));
		map.borders.add(new Border(2, 3));
		map.borders.add(new Border(2, 4));
		map.borders.add(new Border(2, 5));
		map.borders.add(new Border(3, 4));
		map.borders.add(new Border(3, 6));
		map.borders.add(new Border(3, 7));
		map.borders.add(new Border(3, 8));
		map.borders.add(new Border(4, 5));
		map.borders.add(new Border(6, 7));
		map.borders.add(new Border(6, 9));
		map.borders.add(new Border(7, 8));
		map.borders.add(new Border(7, 9));
	}

	/**
	 * Initialized some sudoku.
	 * @param sudoku The sudoku to be initialized.
	 */
	static void initSudoku(Sudoku sudoku) {
		sudoku.givenValues.put("A3", 6);
		sudoku.givenValues.put("A4", 9);
		sudoku.givenValues.put("A5", 8);
		sudoku.givenValues.put("B1", 9);
		sudoku.givenValues.put("B7", 2);
		sudoku.givenValues.put("B8", 5);
		sudoku.givenValues.put("B9", 1);
		sudoku.givenValues.put("C3", 4);
		sudoku.givenValues.put("C6", 1);
		sudoku.givenValues.put("D5", 2);
		sudoku.givenValues.put("D6", 4);
		sudoku.givenValues.put("E1", 7);
		sudoku.givenValues.put("E2", 2);
		sudoku.givenValues.put("E5", 5);
		sudoku.givenValues.put("E8", 6);
		sudoku.givenValues.put("E9", 3);
		sudoku.givenValues.put("F4", 1);
		sudoku.givenValues.put("F5", 7);
		sudoku.givenValues.put("G4", 3);
		sudoku.givenValues.put("G7", 5);
		sudoku.givenValues.put("H1", 8);
		sudoku.givenValues.put("H2", 6);
		sudoku.givenValues.put("H3", 7);
		sudoku.givenValues.put("H9", 9);
		sudoku.givenValues.put("I5", 9);
		sudoku.givenValues.put("I6", 7);
		sudoku.givenValues.put("I7", 1);
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Map map = new Map();
		initCompleteUSMap(map);

		//Sudoku sudoku = new Sudoku();
		//initSudoku(sudoku);

		CSP<Integer> csp = map.createCSP();
		//CSP<Integer> csp = sudoku.createCSP();

		
//		 set Tennessee to a specific value
//		csp.domains.get("Tennessee").clear();
//		csp.domains.get("Tennessee").add(1);
		 
//
//		long start1 = System.nanoTime();
//		boolean result1 = AC3.ac3(csp);
//		BacktrackingCSPSolver b = new BacktrackingCSPSolver();
//		long end1 = System.nanoTime();
//		long time1 = (end1 - start1)/1000000;
//
//		if(result1 != true) {
//			System.out.println("Found no solution!");
//		}
//		else {
//			System.out.println("Time for AC3 : " + time1 + "ms");
//			System.out.println(result1 + "\n");
//		}
//		long start = System.nanoTime();
//		CSPSolver solver = new BacktrackingCSPSolver();
//		CSPResult<Integer> result = solver.solve(csp);
//		long end = System.nanoTime();
//		long time = (end - start)/1000000;
//
//		if(result == null) {
//			System.out.println("Found no solution!");
//		} else {
//			System.out.println("Time for Backtracking : " + time + "ms" );
//			System.out.println(result.toString() + "\n");
//		}
//
//		long start2 = System.nanoTime();
//		CSPSolver solver2 = new ForwardCheckingCSPSolver();
//		CSPResult<Integer> results2 = solver2.solve(csp);
//		long end2 = System.nanoTime();
//		long time2 = (end2 - start2)/1000000;
//
//		if(results2 == null) {
//			System.out.println("Found no solution!");
//		} else {
//			System.out.println("Time for Forward Checking: " + time2 + "ms");
//			System.out.println(results2.toString() + "\n");
//		}

		long start3 = System.nanoTime();
		CSPSolver MinConflicts = new MinConflicts();
		CSPResult<Integer> results3 = MinConflicts.solve(csp);
		long end3 = System.nanoTime();
		long time3 = (end3 - start3)/1000000;

		if(results3 == null) {
			System.out.println("Found no solution for Min Conflicts!");
		} else {
			System.out.println("Time for Min Conflicts: " + time3 + "ms");
			System.out.println(results3.toString());
		}




		/* TODO
		 * evaluate the different algorithms
		 */

	}
}

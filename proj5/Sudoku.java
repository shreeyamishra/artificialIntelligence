package proj5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class representing a sudoku puzzle. 
 */
public class Sudoku {
	public Map<String, Integer> givenValues; /**< The preset values of the sudoku */
	
	/**
	 * Default constructor creating an empty sudoku.
	 */
	public Sudoku() {
		givenValues = new HashMap<String, Integer>();
	}
	
	/**
	 * Puts this sudoku into a csp. It sets up the constraints and incorporates
	 * the preset values into the domains of that variables.
	 * @return This sudoku represented as a csp.
	 */
	public CSP<Integer> createCSP() {
		CSP<Integer> csp = new CSP<Integer>();
		
		// create variable names
		char[] varName = new char[2];
		for(int i = 0; i < 9; ++i) {
			varName[0] = (char)('A' + i);
			for(int j = 0; j < 9; ++j) {
				varName[1] = (char)('1' + j);
				csp.variables.add(new String(varName));
			}
		}
		
		// create domains
		// first create "generic" domain
		List<Integer> domain = new ArrayList<Integer>();
		for(int i = 1; i <= 9; ++i) {
			domain.add(i);
		}
		// and add it for all variables
		for(String i : csp.variables) {
			csp.domains.put(i, new ArrayList<Integer>(domain));
		}
		
		// then replace the domain of given values to that of the given value
		for(Map.Entry<String, Integer> i : givenValues.entrySet()) {
			List<Integer> limitedDomain = new ArrayList<Integer>();
			limitedDomain.add(i.getValue());
			csp.domains.put(i.getKey(), limitedDomain);
		}
		
		// create constraints
		Set<InequalityConstraint> uniqueConstraints = new HashSet<InequalityConstraint>();
		char[] varNameRow = new char[2];
		char[] varNameColumn = new char[2];
		char[] varNameBox = new char[2];
		for(int i = 0; i < 9; ++i) {
			List<String> rowConstraint = new ArrayList<String>();
			List<String> columnConstraint = new ArrayList<String>();
			List<String> boxConstraint = new ArrayList<String>();
			varNameRow[0] = (char)('A' + i);
			varNameColumn[1] = (char)('1' + i);
			for(int j = 0; j < 9; ++j) {
				varNameRow[1] = (char)('1' + j);
				varNameColumn[0] = (char)('A' + j);
				varNameBox[0] = (char)('A' + i / 3 * 3 + j / 3);
				varNameBox[1] = (char)('1' + i % 3 * 3 + j % 3);

				rowConstraint.add(new String(varNameRow));
				columnConstraint.add(new String(varNameColumn));
				boxConstraint.add(new String(varNameBox));
			}
			for(int j = 0; j < 9; ++j) {
				for(int k = j + 1; k < 9; ++k) {
					uniqueConstraints.add(new InequalityConstraint(rowConstraint.get(j), rowConstraint.get(k)));
					uniqueConstraints.add(new InequalityConstraint(columnConstraint.get(j), columnConstraint.get(k)));
					uniqueConstraints.add(new InequalityConstraint(boxConstraint.get(j), boxConstraint.get(k)));
				}
			}
		}
		csp.constraints.addAll(uniqueConstraints);
		return csp;
	}
}

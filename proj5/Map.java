package proj5;

import java.util.Collection;
import java.util.Vector;
import java.util.ArrayList;

/**
 * A class representing a map of states and borders. 
 */
public class Map {
	Vector<Border> borders;
	Vector<String> states;
	
	public Map() {
		borders = new Vector<Border>();
		states = new Vector<String>();
	}
	
	/**
	 * Translates this map into a csp.
	 * @return The csp modeling this map.
	 */
	public CSP<Integer> createCSP() {
		CSP<Integer> csp = new CSP<Integer>();
		
		csp.variables = states;
		
		Collection<Integer> domain = new ArrayList<Integer>(4);
		for(int i = 0; i < 4; ++i) {
			domain.add(i);
		}
		
		for(String i : states) {
			csp.domains.put(i, new ArrayList<Integer>(domain));
		}
		
		for(Border i : borders) {
			csp.constraints.add(new InequalityConstraint(states.get(i.index1), states.get(i.index2)));
		}
		
		return csp;
	}
}

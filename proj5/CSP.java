package proj5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing a CSP.
 * @param <E> The type of the values of the variables of the csp.
 */
public class CSP<E> {
	public List<String> variables; /**< The set of variables */
	public Map<String, List<E>> domains; /**< A mapping of variables to their domains */
	public List<Constraint> constraints; /**< The constraints that define the csp */
	
	/**
	 * Default constructor creating an empty CSP.
	 */
	public CSP() {
		variables = new ArrayList<String>();
		domains = new HashMap<String, List<E>>();
		constraints = new ArrayList<Constraint>();
	}

	/**
	 * Checks whether an assignment is consistent with all constraints of this CSP.
	 * @param assignment The assignment to be checked
	 * @return Whether all constraints are fulfilled
	 */
	public boolean isConsistent(Assignment<E> assignment) {
		/* TODO
		 * Check if every single constraint is consistent
		 * with the assignment.
		 */
		for(int i = 0; i < constraints.size(); i++)
			if(!constraints.get(i).isConsistent(assignment))
				return false;
		return true;
	}
}

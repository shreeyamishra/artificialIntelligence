package proj5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implements the backtracking search with forward checking. 
 */
public class ForwardCheckingCSPSolver extends BacktrackingCSPSolver {

	/**
	 * Implements the actual forward checking. Infers the values to be deleted
	 * from the domains of some variables based on the given variable and value.
	 */
	@Override
	protected <E> Inference<E> inference(CSP<E> csp, Assignment<E> assignment, String var, E value) {
		/* TODO
		 * Implement the forward checking. You may want to iterate over all
		 * constraints to identify those who involve the given variable. Then,
		 * iterate over the variables of the scope of the constraint and check
		 * if the variable is not yet assigned. If it is not assigned, check all
		 * the values of the domain of that variable, and identify those values
		 * that are inconsistent with the constraint (therefore, you might temporarily
		 * modify the assignment with the value to test, and restore the assignment
		 * later on). The inconsistent values should be added to the inference that
		 * will be returned. If no value was found at all, then return failure (null in this
		 * case).
		 */
		Inference<E> inf = new Inference();
		
		for(Constraint c : csp.constraints) {
			List<String> scope = c.getScope();
			if(scope.contains(var)) {
				for( String s: scope) {
					if (assignment.get(s) == null) {
						if(csp.domains.get(s).size() == 0)
							return null;
						Set<E> set = new HashSet<E>(4);
						for(E val : csp.domains.get(s)) {
							assignment.put(s, val);
							if (!csp.isConsistent(assignment))
								set.add(val);
							assignment.remove(s);
						}
						inf.put(s, set);
					}
				}
			}
			//foreach constraint in csp.constraints do
			//scope <- csp.constraints.getScope()
			//if scope.contains(var)
			//foreach string in scope
			//if assignment.get(string) == null
			//if csp.domains.get(string).size() == 0 return null
			//foreach value v of csp.domains.get(string)
			//assignment.put(string, v)
			//if (!csp.isConsistent(assignment))
			//inf.put(string, v)
			//assignment.remove(string)
			
		}
		return inf;
	}
}
package proj5;
import java.util.ArrayList;
import java.util.List;

/**
 * A class implementing the backtracking CSP algorithm.
 */
public class BacktrackingCSPSolver implements CSPSolver {
	private int iterationCount;

	/**
	 * Initiates the backtracking search for this CSP.
	 * @return A consistent assignment for this CSP
	 */
	@Override
	public <E> CSPResult<E> solve(CSP<E> csp) {
		iterationCount = 0;
		Assignment<E> finalAssignment = backtrack(csp, new Assignment<E>());
		return new CSPResult<E>(finalAssignment, iterationCount);		
	}

	/**
	 * Selects an unassigned variable. For this algorithm, it can be just the first, or a
	 * randomly chosen unassigned variable.
	 * @param assignment The assignment for which to determine an unassigned variable
	 * @return A variable that is not assigned yet.
	 */
	protected <E> String selectUnassignedVariable(CSP<E> csp, Assignment<E> assignment) {
		ArrayList l = new ArrayList();

		for(String s: csp.variables) {
			if(assignment.get(s) == null) {
				l.add(s);
			}
		}
		return (String) l.get((int) (Math.random() * l.size()));
		/* TODO
		 * Return any unassigned variable. For the generic backtracking search
		 * you can e.g. return a randomly chosen unassigned variable, or just the
		 * first one.
		 */

	}

	/**
	 * This method returns the values of the domain of a variable in
	 * a specific order. Can be used to implement e.g. least-constraining-value heuristic.
	 * For this algorithm, it can be in any order, e.g. the arbitrary order in which they are
	 * stored in the csp.
	 * @param variable The variable for which the domain values should be returned
	 * @param assignment The current assignment
	 * @return An ordering of all domain values of the given variable.
	 */
	protected <E> List<E> orderDomainValues(CSP<E> csp, String variable, Assignment<E> assignment) {
		return csp.domains.get(variable);
	}

	/**
	 * This method returns some inference, which is basically a set of domain values that can be safely
	 * deleted from the domains of the csp. To be used to implement e.g. forward-checking heuristic.
	 * If it returns null this means there is some failure and we should back-track.
	 * For this algorithm, it can always return an empty inference.
	 * @param assignment The current assignment
	 * @param var The selected variable
	 * @param value The value for the given variable
	 * @return An inference based on the current state of the csp, or null if there is a failure.
	 */
	protected <E> Inference<E> inference(CSP<E> csp, Assignment<E> assignment, String var, E value) {
		// return an empty inference. We cannot return null, because this has a different meaning.
		return new Inference<E>();
	}

	/**
	 * Actual recursive implementation of the backtracking search. The
	 * implementation can pretty much follow the pseudo-code in the text book.
	 * Basically, the algorithm can be implemented using almost only calls to the other
	 * methods of this and the other classes.
	 * @param assignment The current assignment
	 * @return The updated assignment, or null if there is no valid assignment
	 */
	private <E> Assignment<E> backtrack(CSP<E> csp, Assignment<E> assignment) {
		++iterationCount;

		if(assignment.isComplete(csp))
			return assignment;
		String var = selectUnassignedVariable(csp, assignment);
		for(E value : orderDomainValues(csp, var, assignment)){
			assignment.put(var, value);
			if(csp.isConsistent(assignment)) {
				Inference<E> inferences = inference(csp, assignment, var, value);
				if(inferences != null) {
					inferences.reduceDomain(csp);
					Assignment<E> result = backtrack(csp, assignment);
					inferences.restoreDomain(csp);
					if(result != null)
						return result;

				}
				assignment.remove(var);
			} else
				assignment.remove(var);

		}
		return null;

		/* TODO
		 * The implementation can follow very much the pseudo code in the book:
		 * 
		 * if assignment is complete then return assignment
		 * var <- SELECT-UNASSIGNED-VARIABLE(csp)
		 * for each value in ORDER-DOMAIN-VALUES(var, assignment, csp) do
		 *   if value is consistent with assignment then
		 *     add {var = value} to assignment
		 *     inferences <- INFERENCE(csp, var, value)
		 *     if inferences != failure then
		 *       add inferences to csp
		 *       result <- BACKTRACK(assignment, csp)
		 *       remove inferences from csp
		 *       if result != failure then
		 *         return result
		 *     remove {var = value} from assignment
		 * return failure
		 * 
		 * Please note that "failure" is represented as null in this implementation.
		 * I implemented the inferences slightly different than the book suggests:
		 * The method inference() additionally needs the current assignment as a
		 * parameter, and the inference is instead applied to the csp, not to the
		 * assignment. This is realized by the methods Inference.reduceDomain() and
		 * Inference.restoreDomain(). I slightly modified the pseudo code in contrast
		 * to the code in the book to comply with the modified interface of the
		 * inference.
		 */
	}

}

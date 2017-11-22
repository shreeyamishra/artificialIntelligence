package proj5;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AC3  {
	/**
	 * This class represents a single arc for the AC-3 algorithm.
	 */
	public static class Arc{
		private String value1, value2;

		public Arc(String value1, String value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
	}

	/**
	 * Implements the AC-3 algorithm to make a csp arc consistent.
	 * @param csp The csp
	 * @return Whether an inconsistency was found (false) or not (true)
	 * @throws Exception
	 */
	public static <E> boolean ac3(CSP<E> csp) throws Exception  {
		/* TODO
		 * First, set up a queue of all arcs. For each constraint (you can assume that
		 * all constraints are binary constraints) add two arcs, one forward, and one
		 * backwards. Then implement the following (taken from text book):
		 * 
		 * while queue is not empty do
		 *   (Xi, Xj) <- REMOVE-FIRST(queue)
		 *   if REVISE(csp, Xi, Xj) then
		 *     if size of Di = 0 then return false
		 *     for each Xk in Xi.NEIGHBORS - {Xj} do
		 *       add (Xk, Xi) to queue
		 * return true
		 * 
		 * Note that Xi and Xj correspond to Arc.value1 and Arc.value2
		 * after some arc has been polled from the queue.
		 */
		ArrayDeque a = new ArrayDeque();
		for(int i= 0; i< csp.constraints.size(); i++) {
			List<String> scope = csp.constraints.get(i).getScope();
			a.add(new Arc(scope.get(0), scope.get(1)));
			a.add(new Arc(scope.get(1), scope.get(0)));
		}
		while(!a.isEmpty()) {
			Arc X = (Arc) a.poll();
			if(revise(csp,X.value1, X.value2)) {
				if(csp.domains.get(X.value1).size() == 0)
					return false;

				for(String k : neighbors(csp, X.value1))
					if(!k.equals(X.value2))
						a.add(new Arc(k, X.value1));
			}
		}
		return true;



	}

	/**
	 * Implements the revise-routine of the AC-3 algorithm. Effectively iterates
	 * over all domain values of var1 and checks if there is at least 1 possible value
	 * for var2 remaining. If not, removes that value from the domain of var1.
	 * @param csp
	 * @param var1
	 * @param var2
	 * @return
	 */
	private static <E> boolean revise(CSP<E> csp, String var1, String var2) {
		/* TODO
		 * You may want to use a temporary Assignment to check whether a constraint
		 * is violated by any values for var1 and var2. Iterate over all domain values
		 * of var1. Then iterate over all domain values of var2 and prepare the
		 * temporary assignment accordingly. If all values for var2 produce an
		 * inconsistent assignment, remove the current value from the domain of
		 * var1. Hint: You cannot modify the domain as long as you are iterating over
		 * it, therefore I recommend to temporarily store the values to be deleted in
		 * a list or something, and then delete them all together after you iterated
		 * over all domain values. Also, don't forget to return whether you actually
		 * modified the domain of var1. 
		 */
		List<E> l = new ArrayList<E>();
		boolean m = false;
		Assignment<E> temp = new Assignment<E>();
		for(E val1: csp.domains.get(var1)) {
			temp.put(var1, val1);
			int inconsistencies = 0;
			for(E val2: csp.domains.get(var2)) {
				temp.put(var2, val2);
				if(csp.isConsistent(temp))
					inconsistencies++;
				temp.remove(var2);
			}
			if(inconsistencies == csp.domains.get(var2).size())
				l.add(val1);
		}
		if(l.size() > 0) {
			csp.domains.get(var1).removeAll(l);
			m = true;
		}
		return m;

	}

	/**
	 * Computes the "neighbors" of a variable in a CSP. A variable is
	 * a neighbor if it is coupled to another variable by a constraint.
	 * @param <E>
	 * @param csp The csp
	 * @param var The variable the neighbors of which are to be found.
	 * @return The neighbors of the given variable.
	 */
	private static <E> Set<String> neighbors(CSP<E> csp, String var) {
		/* TODO
		 * Iterate over all constraints and check if var is contained
		 * in the constraint's scope. If so, all _other_ variables of
		 * the constraint's scope are neighbors.
		 */
		HashSet s = new HashSet();
		for(Constraint c: csp.constraints) {
			if(c.getScope().contains(var)) {
				s.addAll(c.getScope());
			}
			c.getScope().remove(var);
		}
		return null;
	}
}

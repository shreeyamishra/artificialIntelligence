package proj5;
/**
 * Interface to be implemented by CSP solvers.
 */
public interface CSPSolver {
	/**
	 * Solves a given CSP with some algorithm.
	 * @param csp The csp to solve.
	 * @return The solution to the csp.
	 */
	public <E> CSPResult<E> solve(CSP<E> csp);  
}

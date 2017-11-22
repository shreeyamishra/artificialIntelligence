package proj5;

/**
 * The class that is returned by CSP solvers. Contains the actual assignment
 * (or null if there is none), and the number of iterations it took. 
 * @param <E> The type of the values of variables of the underlying CSP.
 */
public class CSPResult<E> {
	public Assignment<E> assignment;
	public int iterations;
	
	public CSPResult(Assignment<E> assignment, int iterations) {
		this.assignment = assignment;
		this.iterations = iterations;
	}
	
	public String toString() {
		String result = new String();
		result = "Iterations: " + iterations + "\n";
		result += assignment.toString();
		return result;
	}
}

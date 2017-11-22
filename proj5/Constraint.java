package proj5;
import java.util.List;

/**
 * An interface that must be implemented by any constraint for the CSP. 
 */
public interface Constraint {
	public List<String> getScope();
	
	/**
	 * To be implemented by actual constraints. Tells whether the constraint
	 * is fulfilled by the given assignment.
	 * @param assignment The assignment to be checked
	 * @return Whether the constrained is fulfilled
	 */
	<E> boolean isConsistent(Assignment<E> assignment);
}

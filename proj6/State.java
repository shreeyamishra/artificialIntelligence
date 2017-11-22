package proj6;
import java.util.List;

/**
 * An interface to be implemented to represent a specific game.
 */
public interface State {
	/**
	 * Returns the actions that are possible given the current state.
	 * @return All possible actions.
	 */
	public List<Action> getActions();

	/**
	 * Returns the utility value, that is already precomputed.
	 * @return The utility value.
	 */
	public float getUtility();

	/**
	 * Generates a successor state from the current state given an action.
	 * @param action The action that leads to the successor.
	 * @return The successor state.
	 */
	public State getResult(Action action);

	/**
	 * Determines whether the state is terminal (i.e., a leaf).
	 * @return Whether the state is terminal.
	 */
	public boolean isTerminal();

	/**
	 * prints the current state.
	 */
	public void print();
}

package proj6;
import java.util.*;
//import java.util.Vector;

/**
 * A class that implements a state and the playing logic of the TicTacToe game. 
 */
public class TicTacToeState implements State {
	private Square[] field; /**< The field, consisting of nine squares. First three values correspond to first row, and so on. */
	public Square player; /**< The player, either X or O. */
	public Square playerToMove; /**< The player that is about to move. */
	private float utility; /**< The utility value of this state. Can be 0, 1 (won) or -1 (lost).*/

	/**
	 * Updates the utility value.
	 */
	private void updateUtility() {
		/** TODO
		 * The utility value for the TicTacToe game is defined as follows:
		 * - if player has three marks in a row, it is 1
		 * - if the other player has three marks in a row, it is -1
		 * - otherwise it is 0
		 * Note that "three marks in a row" can actually be a row, a column
		 * or a diagonal. So basically, first find out if there are three
		 * identical values in a row, and if so, check whether the marks belong
		 * to player or not. 
		 */
		int i = 0;
		Square win = Square.EMPTY;
		boolean find = false;
		// loop rows
		while (i<field.length){
			if (!(field[i] == Square.EMPTY)){
				if (field[i] == field[i+1] && field[i] == field[i+2]){
					find = true;
					win = field[i];
				}
			}
			i = i+3;
		}
		i = 0;
		while (i<(field.length/3)){
			if (!(field[i] == Square.EMPTY)){
				if (field[i] == field[i+3] && field[i] == field[i+6]){
					find = true;
					win = field[i];
				}
			}
			i = i+1;
		}
		if (!find){
			if (!(field[0] == Square.EMPTY)){
				if (field[0] == field[4] && field[0] == field[8]){
					find = true;
					win = field[0];
				}
			}
			if (!(field[0] == Square.EMPTY)){
				if (field[2] == field[4] && field[2] == field[6]){
					find = true;
					win = field[2];
				}
			}
		}
		if (!find){
			utility = 0;
		}
		if (find){
			if (win == Square.EMPTY){
				utility = 0;
			}
			else if (win == player){
				utility = 1;
			}
			else{ // winner is the other player
				utility = -1;
			}
		}
	}

	/**
	 * Default constructor.
	 */
	public TicTacToeState() {
		field = new Square[9];
		for(int j = 0; j < 9; ++j) {
			field[j] = Square.EMPTY;
		}
		player = Square.X;
		playerToMove = Square.X;
		utility = 0;
	}

	@Override
	public List<Action> getActions() {
		/** TODO
		 * For the TicTacToe game, there is one valid action
		 * for each empty square. The action would then consist
		 * of the position of the empty square and the "color" of
		 * the player to move.
		 */
		List <Action> actions = new Vector <Action> ();
		for (int k = 0; k<field.length; k++){
			if (field[k]==Square.EMPTY){
				actions.add (new TicTacToeAction(playerToMove, k));
			}
		}
		return actions;
	}

	@Override
	public float getUtility() {
		return utility;
	}

	@Override
	public State getResult(Action action) {
		/** TODO
		 * Create a new state and copy all the contents of the current state
		 * to the new one (in particular the field and the player). The
		 * player to move must be switched. Then incorporate the action into
		 * the field of the new state. Finally, compute the utility of the new
		 * state using updateUtility().
		 */
		TicTacToeState newState = new TicTacToeState();
		for (int i = 0; i<newState.field.length; i++){
			newState.field[i] = field[i];
		}

		newState.player = playerToMove;
		if (newState.player == Square.X){
			newState.playerToMove = Square.O;
		}
		else if (newState.player == Square.O){
			newState.playerToMove = Square.X;
		}
		if (newState.playerToMove == Square.X){
			newState.player = Square.O;
		}
		else if (newState.playerToMove == Square.O){
			newState.player = Square.X;
		}
		newState.field[((TicTacToeAction)action).position] = ((TicTacToeAction)action).player;

		//newState.field[action.position];
		newState.updateUtility();


		return newState;
	}

	@Override
	public boolean isTerminal() {
		/** TODO
		 * Hint: the utility value has specific values if one of
		 * the players has won, which is a terminal state. However,
		 * you will also have to check for terminal states in which
		 * no player has won, which can not be inferred immediately
		 * from the utility value.
		 */
		if (utility == 1 || utility == -1){
			return true;
		}
		else if (utility == 0 && getActions().size() ==0 ){
			return true;
		}
		else {//utility == 0
			return false;
		}
	}

	@Override
	public void print() {
		String s = "" + field[0] + "|" + field[1] + "|" + field[2] + "\n";
		s += "-+-+-\n";
		s += field[3] + "|" + field[4] + "|" + field[5] + "\n";
		s += "-+-+-\n";
		s += field[6] + "|" + field[7] + "|" + field[8] + "\n";
		System.out.println(s);
	}
}

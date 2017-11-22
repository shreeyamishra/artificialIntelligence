package proj6;

/**
 *  
 */
public class TicTacToeAction implements Action {
	Square player; // The player to move (determines the square to be set)
	int position; // The position to be modified in the range [0..9)
	
	public TicTacToeAction(Square square, int position) {
		this.player = square;
		this.position = position;
	}
}

package proj6;
/**
 * An enum that represents a single square in the TicTacToe game. 
 */
public enum Square {
	EMPTY {
		public String toString() {
			return " ";
		}
	},
	X {
		public String toString() {
			return "X";
		}
	},
	O {
		public String toString() {
			return "O";
		}
	}	
}

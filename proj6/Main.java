package proj6;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("The squares are numbered as follows:");
		System.out.println("1|2|3\n-+-+-\n4|5|6\n-+-+-\n7|8|9\n");
		
		System.out.print("Who should start? 1=you 2=computer ");
		int temp = scanner.nextInt();
		
		TicTacToeState s = new TicTacToeState();
		s.player = Square.X;
		if(temp == 1) {
			s.playerToMove = Square.O; 
		} else {
			s.playerToMove = Square.X;
		}
		
		do {
			if(s.playerToMove == Square.X) { // computer is to move
				s = (TicTacToeState) s.getResult(MiniMax.MinimaxDecision(s, false));
			} else { // you are to move
				System.out.print("Which square do you want to set? (1--9) ");
				do {
					temp = scanner.nextInt();
				}
				while(temp < 1 || temp > 9);
				TicTacToeAction a = new TicTacToeAction(Square.O, temp - 1);
				s = (TicTacToeState)s.getResult(a);
			}
			s.print();
		}
		while(!s.isTerminal());
		
		if(s.getUtility() > 0) {
			System.out.println("You lost");
		} else if(s.getUtility() < 0) {
			System.out.println("You win");
		} else {
			System.out.println("Draw");
		}
		
		scanner.close();
	}

}

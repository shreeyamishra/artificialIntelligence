package proj2;

import java.util.Queue;

import java.util.ArrayDeque;

public class runSearch {
	
	Queue<Node> queue = new ArrayDeque<Node>();
	static int depthLimit = 0;
	static int currentDepth = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node result = null;
		Node startNode = new Node();
		State s = new State(0,0,0,0,3,3,false);
		State x = new State(3,3,0,0,0,0,true);
		startNode.state = s;
		System.out.println("Searching...");
		while (depthLimit <= 21 && result == null) {
			System.out.println("");
			System.out.println("----------New Depth limit----------------");
			System.out.println("depthLimit: " + depthLimit);
			System.out.println("------------------------------------");
			System.out.println("currentDepth: " + currentDepth);
			result = search(startNode, x);
			depthLimit++;
		}
		
		if (result != null) {
			System.out.println("");
			System.out.println("Path found!");
			System.out.println("---------------------------");
			for(Node i = result; i != null; i = i.previous) {
				System.out.println(i.state);
			}
		} else {
			System.out.println("No path found.");
		}
	}
	
	private static Node search(Node node, State goal) {
		
		
		if (node.state.isEqual(goal)) {
			return node;
		}
		
		if (currentDepth >= depthLimit) {
			return null;
		}
		
		if (node.previous != null && node.previous.previous != null && node.previous.previous.state.isEqual(node.state)) {
			//System.out.println(node.state.toString());
			return null;
		}
		
		node.expand();
		
		currentDepth++;
		//System.out.println("currentDepth: " + currentDepth);
		while (!node.children.isEmpty()) {
			Node child = node.children.poll();
			Node result = search(child, goal);
			if (result != null) {
				//assert(result == null);
				currentDepth--;
				return result;
			}
		}
		currentDepth--;
		//System.out.println("currentDepth: " + currentDepth);
		
		return null;
	}

}

class Node extends Object {
	State state;
	Node previous;
	Queue<Node> children;
	
	public void expand() {
		Queue<Node> children = new ArrayDeque<Node>();
		Node n;
		State s;
		// if the boat is on the left side
		if (state.isBoatOnLeft) {
			if (state.mboat + state.cboat > 0 && state.mleft + state.cleft > 0) {
				
				if (state.mboat > 0 && state.cboat > 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft + state.mboat, state.cleft + state.cboat, 0, 0, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);

					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft + state.cboat, state.mboat, 0, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);

					n = new Node();
					n.previous = this;
					s = new State(state.mleft + state.mboat, state.cleft, 0, state.cboat, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
				}
				byte i;

				i = state.mboat;
				while (i != 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft + (state.mboat - i), state.cleft, i, state.cboat, state.mright, state.cright, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}


				i = state.cboat;
				while (i != 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft + (state.cboat - i), state.mboat, i, state.mright, state.cright, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}
				i = state.mleft;
				while (i >= 0) {
					n = new Node();
					n.previous = this;
					s = new State(i, state.cleft + state.cboat, state.mboat + (state.mleft - i), 0, state.mright, state.cright, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}

				i = state.cleft;
				while (i >= 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft + state.mboat, i, 0, state.cboat + (state.cleft - i), state.mright, state.cright, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}
			} 
			else if (state.mboat + state.cboat > 0) {
				if (state.mboat > 0 && state.cboat > 0) {

					n = new Node();
					n.previous = this;
					s = new State(state.mleft + state.mboat, state.cleft + state.cboat, 0, 0, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);

					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft + state.cboat, state.mboat, 0, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);

					n = new Node();
					n.previous = this;
					s = new State(state.mleft + state.mboat, state.cleft, 0, state.cboat, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
				}
				byte i;

				i = state.mboat;
				while (i != 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft + (state.mboat - i), state.cleft, i, state.cboat, state.mright, state.cright, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}

				i = state.cboat;
				while (i != 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft + (state.cboat - i), state.mboat, i, state.mright, state.cright, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}
			}
		} 
		else if (state.mleft + state.cleft > 0) {
			if (state.mleft > 0 && state.cleft > 0) {
				//----------------------
				n = new Node();
				n.previous = this;
				s = new State(state.mleft - 1, state.cleft - 1, 1, 1, state.mright, state.cright, 
						state.isBoatOnLeft);
				n.state = s;
				children.add(n);
				//-----------------------
				byte x;
				x = state.mleft == 3 ? 2 : state.mleft;
				while (x > 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft - x, state.cleft, x, state.cboat, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					x--;
				}
				//------------------------
				x = state.cleft == 3 ? 2 : state.cleft;
				while (x > 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft - x, state.mboat, x, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					x--;
				}
			} 
			else if (state.mleft > 0) {
				byte x;
				x = state.mleft == 3 ? 2 : state.mleft;
				while (x > 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft - x, state.cleft, x, state.cboat, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					x--;
				}
			} 	
			else {
				byte x;
				x = state.cleft == 3 ? 2 : state.cleft;
				while (x > 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft - x, state.mboat, x, state.mright, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					x--;
				}
			}
			byte i;

			i = state.mleft;
			while (i >= 0) {
				n = new Node();
				n.previous = this;
				s = new State(i, state.cleft + state.cboat, state.mboat + (state.mleft - i), 0, state.mright, state.cright, state.isBoatOnLeft);
				n.state = s;
				children.add(n);
				i--;
			}

			i = state.cleft;
			while (i >= 0) {
				n = new Node();
				n.previous = this;
				s = new State(state.mleft + state.mboat, i, 0, state.cboat + (state.cleft - i), state.mright, state.cright, state.isBoatOnLeft);
				n.state = s;
				children.add(n);
				i--;
			}
		}

		else {
			if (state.mboat + state.cboat > 0 && state.mright + state.cright > 0) {
				if (state.mboat > 0 && state.cboat > 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, 0, 0, state.mright + state.mboat, state.cright + state.cboat, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, state.mboat, 0, state.mright, state.cright + state.cboat, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, 0, state.cboat, state.mright + state.mboat, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
				}
				byte i;

				i = state.mboat;
				while (i != 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, i, state.cboat, state.mright + (state.mboat - i), state.cright, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}

				i = state.cboat;
				while (i != 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, state.mboat, i, state.mright, state.cright + (state.cboat - i), state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}

				i = state.mright;
				while (i >= 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, state.mboat + (state.mright - i), 0, i, state.cright + state.cboat, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}

				i = state.cright;
				while (i >= 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, 0, state.cboat + (state.cright - i), state.mright + state.mboat, i, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}
			} else if (state.mboat + state.cboat > 0) {
				if (state.mboat > 0 && state.cboat > 0) {

					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, 0, 0, state.mright + state.mboat, state.cright + state.cboat, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);

					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, state.mboat, 0, state.mright, state.cright + state.cboat, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);

					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, 0, state.cboat, state.mright + state.mboat, state.cright, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);
				}

				byte i;

				i = state.mboat;
				while (i != 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, i, state.cboat, state.mright + (state.mboat - i), state.cright, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}


				i = state.cboat;
				while (i != 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, state.mboat, i, state.mright, state.cright + (state.cboat - i), state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}
			} else if (state.mright + state.cright > 0) {
				if (state.mright > 0 && state.cright > 0) {

					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, 1, 1, state.mright - 1, state.cright - 1, 
							state.isBoatOnLeft);
					n.state = s;
					children.add(n);

					byte x;
					x = state.mright == 3 ? 2 : state.mright;
					while (x > 0) {
						n = new Node();
						n.previous = this;
						s = new State(state.mleft, state.cleft, x, state.cboat, state.mright - x, state.cright, 
								state.isBoatOnLeft);
						n.state = s;
						children.add(n);
						x--;
					}

					x = state.cright == 3 ? 2 : state.cright;
					while (x > 0) {
						n = new Node();
						n.previous = this;
						s = new State(state.mleft, state.cleft, state.mboat, x, state.mright, state.cright - x, 
								state.isBoatOnLeft);
						n.state = s;
						children.add(n);
						x--;
					}
				} else if (state.mright > 0) {
					byte x;
					x = state.mright == 3 ? 2 : state.mright;
					while (x > 0) {
						n = new Node();
						n.previous = this;
						s = new State(state.mleft, state.cleft, x, state.cboat, state.mright - x, state.cright, 
								state.isBoatOnLeft);
						n.state = s;
						children.add(n);
						x--;
					}
				} else {
					byte x;
					x = state.cright == 3 ? 2 : state.cright;
					while (x > 0) {
						n = new Node();
						n.previous = this;
						s = new State(state.mleft, state.cleft, state.mboat, x, state.mright, state.cright - x, 
								state.isBoatOnLeft);
						n.state = s;
						children.add(n);
						x--;
					}
				}
				byte i;

				i = state.mright;
				while (i >= 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, state.mboat + (state.mright - i), 0, i, state.cright + state.cboat, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}

				i = state.cright;
				while (i >= 0) {
					n = new Node();
					n.previous = this;
					s = new State(state.mleft, state.cleft, 0, state.cboat + (state.cright - i), state.mright + state.mboat, i, state.isBoatOnLeft);
					n.state = s;
					children.add(n);
					i--;
				}
			}
		}

		if (state.mboat + state.cboat > 0) {
			n = new Node();
			n.previous = this;
			s = new State(state.mleft, state.cleft, state.mboat, state.cboat, state.mright, state.cright, !state.isBoatOnLeft);					
			n.state = s;
			children.add(n);
		}
				
		this.children = new ArrayDeque<Node>();
		// remove nodes similar to this one.
		for (Node node : children) {
			if (!state.isEqual(node.state) && !this.children.contains(node) && node.state.isPossible()) {
				this.children.add(node);
			}
			
			if (node.state.mleft > 2 && node.state.cleft > 0 && node.state.cboat == 2) {
				
			}
		}
		// eliminate duplicates
		
	}

	public String toString() {
		return state.toString();
	}
	
	public boolean equals(Object arg0) {
		return arg0.getClass() == Node.class ? state.isEqual(((Node) arg0).state) : super.equals(arg0);
	}
}

class State {
	byte mleft;
	byte cleft;
	byte mright;
	byte cright;
	byte mboat;
	byte cboat;
	boolean isBoatOnLeft;
	
	public State(int ml, int cl, int mb, int cb, int mr, int cr, boolean ibol) {
		mleft = (byte) ml;
		cleft = (byte) cl;
		mright = (byte) mr;
		cright = (byte) cr;
		mboat = (byte) mb;
		cboat = (byte) cb;
		isBoatOnLeft = ibol;
	}
	
	public boolean isPossible() {
		byte sum = 0;
		sum += mleft;
		sum += cleft;
		sum += mright;
		sum += cright;
		sum += mboat;
		sum += cboat;
		if (sum != 6) {
			return false;
		}
		
		if (mboat + cboat < 0 || mboat + cboat > 2) {
			return false;
		}
		
		if ((mleft > 0 && cleft > mleft) || (mright > 0 && cright > mright)) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return "mleft: " + mleft + " cleft: " + cleft + " mboat: " + mboat + " cboat: " + cboat + " isBoatOnLeft: " + isBoatOnLeft + " mright: " + mright + " cright: " + cright;
	}
	
	boolean isEqual(State state) {
		return mleft == state.mleft && cleft == state.cleft && mright == state.mright && cright == state.cright && mboat == state.mboat && cboat == state.cboat && isBoatOnLeft == state.isBoatOnLeft;
	}
	
	public boolean equals(Object arg0) {
		return arg0.getClass() == State.class ? this.isEqual((State) arg0) : super.equals(arg0);
	}
}

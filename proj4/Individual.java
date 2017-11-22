package proj4;

import java.lang.reflect.Array;
public class Individual {
			private Map map; // the map
			private double fitness; // fitness is cached and only updated on request whenever necessary
			// TODO some representation of the genom of the individual

			/**
			 * Updates the fitness value based on the genom and the map.
			 */
			public int[] countryColor;
			public void updateFitness() {
				// TODO implement fitness function
				fitness = 0;
			//	private static final int[] color = {1,2,3,4};
//				private static int[] countryColor = new int[10];
				
				for(int i = 0; i < map.borders.size(); i++) {
					
					if(countryColor[map.borders.get(i).index1] != countryColor[map.borders.get(i).index2])
						fitness++;
				}
						
			}
			
			/**
			 * Default ctor. Creates a (valid) random individual.
			 * @param map The US states map.
			 */
			public Individual(Map map) {
			this.map = map;
			
			// TODO implement random generation of an individual
			countryColor = new int[map.states.size()];
			for(int i = 0; i< countryColor.length; i++)
				countryColor[i] = (int) Math.random() * 4;
				
			updateFitness();				
		}

			/**
			 * Reproduces a child randomly from two individuals (see textbook).
			 * @param x The first parent.
			 * @param y The second parent.
			 * @return The child created from the two individuals.
			 */
			public static Individual reproduce(Individual x, Individual y) {
				Individual child = new Individual(x.map);

				// TODO reproduce child from individuals x and y

				int index = (int)Math.random() * x.countryColor.length;
				for(int i = 0; i< x.countryColor.length; i++) {
					if(i<index)
						child.countryColor[i] = x.countryColor[i];
					else
						child.countryColor[i] = y.countryColor[i];
				}
				child.updateFitness();
				return child;
			}

			/**
			 * Returns the current fitness value of the individual.
			 * @return The current fitness value.
			 */
			public double getFitness() {
				return fitness;
			}

			/**
			 * Randomly mutates the individual.
			 */
			public void mutate() {
				// TODO implement random mutation of the individual
				int index = (int) (Math.random() * countryColor.length);
				countryColor[index] = (int) (Math.random() * 4);
				updateFitness();
			}

			/**
			 * Checks whether the individual represents a valid goal state.
			 * @return Whether the individual represents a valid goal state.
			 */
			public boolean isGoal() {
				return fitness == map.borders.size();
			}
			
			/**
			 * Prints out the individual to the console.
			 */
			void print() {
				// TODO implement printing the individual in the following format:
				// fitness: 15
				// North Carolina: 0
				// South Carolina: 2
				// ...
				System.out.println("fitness: " + fitness);
				for(int state= 0; state< map.states.size(); state++)
					System.out.println( map.states.get(state) + ": " + countryColor[state]);
	}
}

package proj4;
import java.util.Random;
import java.util.Vector;

/**
 * Class representing a population of individuals
 */
public class Population extends Vector<Individual> {
	private Map map;

	/**
	 * Actual standard ctor.
	 * @param map The map.
	 * @param initialSize The initial size of the population.
	 */
	Population(Map map, int initialSize) {
		for(int i = 0; i < initialSize; ++i)
		{
			add(new Individual(map));
		}
	}

	/**
	 * Standard ctor.
	 * @param map The map.
	 */
	public Population(Map map) {
		this(map, 0);
	}

	/**
	 * Randomly selects an individual out of the population
	 * proportionally to its fitness.
	 * @return The selected individual.
	 */
	Individual randomSelection() {
		// TODO implement random selection
		// an individual should be selected with a probability
		// proportional to its fitness
		int totalSum = 0;
		for(int x = 0; x < size() ; x++)
			totalSum += get(x).getFitness(); 
		int index = (int) (Math.random()*(totalSum));
		int sum = 0;
		int i=0;
		while(sum < index ) {
			sum = (int) (sum + this.get(i++).getFitness());
		}
		return this.get(Math.max(0,i-1));


	}
}

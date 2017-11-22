package proj4;

public class Main {
	static void initMap(Map map)
	{
		map.states.add("North Carolina");
		map.states.add("South Carolina");
		map.states.add("Virginia");
		map.states.add("Tennessee");
		map.states.add("Kentucky");
		map.states.add("West Virginia");
		map.states.add("Georgia");
		map.states.add("Alabama");
		map.states.add("Mississippi");
		map.states.add("Florida");

		map.borders.add(new Border(0, 1));
		map.borders.add(new Border(0, 2));
		map.borders.add(new Border(0, 3));
		map.borders.add(new Border(0, 6));
		map.borders.add(new Border(1, 6));
		map.borders.add(new Border(2, 3));
		map.borders.add(new Border(2, 4));
		map.borders.add(new Border(2, 5));
		map.borders.add(new Border(3, 4));
		map.borders.add(new Border(3, 6));
		map.borders.add(new Border(3, 7));
		map.borders.add(new Border(3, 8));
		map.borders.add(new Border(4, 5));
		map.borders.add(new Border(6, 7));
		map.borders.add(new Border(6, 9));
		map.borders.add(new Border(7, 8));
		map.borders.add(new Border(7, 9));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Map map = new Map();
			initMap(map);
			
			final int populationSize = 4; // TODO find reasonable value
			Population population = new Population(map, populationSize);

			final int maxIterations = 1000000; // TODO find reasonable value
			int currentIteration = 0;
			boolean goalFound = false;
			Individual bestIndividual = new Individual(map); // to hold the individual representing the goal, if any

			while(currentIteration < maxIterations && !goalFound)
			{
				Population newPopulation = new Population(map);
				for(int i = 0; i < populationSize; ++i)
				{
					Individual x = population.randomSelection();
					Individual y = population.randomSelection();
					Individual child = Individual.reproduce(x, y);
					if(Math.random() < .01) // TODO use small probability instead
					{
						child.mutate();
					}
					if(child.isGoal())
					{
						goalFound = true;
						bestIndividual = child;
					}
					newPopulation.add(child);
				}
				population = newPopulation;
				++currentIteration;
			}

			if(goalFound)
			{
				System.out.printf("Found a solution after %d iterations\n", currentIteration);
				bestIndividual.print();
			}
			else
			{
				System.out.printf("Did not find a solution after %d iterations\n", currentIteration);
			}
	}

}

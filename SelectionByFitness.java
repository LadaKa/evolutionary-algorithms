package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SelectionByFitness {

	Map<Integer, Individual> selectionPool;
	int maxPoolKey;
	
	public Map<Integer, Individual> CreateSelectionPool(
			ArrayList<Individual> individuals,
			Fitness fitness,
			int generationNumber)
	{
		selectionPool = new HashMap<Integer, Individual>();
		
		int fitnessIndex = 0;
		float sum = 0f;
		int max = 0;
		
		for (Individual individual : individuals)
		{
			int fitnessValue = fitness.EvaluateIndividualFitness(individual);
			sum = sum + fitnessValue;
			if (fitnessValue > max)
				max = fitnessValue;
			fitnessIndex = fitnessIndex + fitnessValue + 1;
			selectionPool.put(fitnessIndex, individual);
			maxPoolKey = fitnessIndex;
		}
		
		float avg = sum/individuals.size();
		
		
		System.out.print(max + ", ");
		return selectionPool;		
	}
	
	
	public Individual SelectNext()
	{
		Random r = new Random();
		int nextIndex = r.nextInt(maxPoolKey);
		for (int key:selectionPool.keySet())
		{
			if (key > nextIndex)
				return selectionPool.get(key);
		}
		return null;
	}
}

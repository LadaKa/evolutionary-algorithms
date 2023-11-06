package main;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Random;

public class SelectionByFitness {

	private SortedMap<Integer, Individual> selectionPool;
	private int maxPoolKey;

	private Result result;

	public SelectionByFitness(int generationCount) {
		result = new Result(generationCount);
	}

	public SortedMap<Integer, Individual> CreateSelectionPool(ArrayList<Individual> individuals, Fitness fitness,
			int generationNumber) {
		selectionPool = new TreeMap<Integer, Individual>();

		int fitnessIndex = 0;
		float sum = 0f;
		int max = 0;

		float[] allFitness = new float[individuals.size()];

		for (int i = 0; i < individuals.size(); i++) {
			Individual individual = individuals.get(i);
			int fitnessValue = fitness.EvaluateIndividualFitness(individual);

			allFitness[i] = fitnessValue;
			sum = sum + fitnessValue;
			if (fitnessValue > max)
				max = fitnessValue;

			fitnessIndex = fitnessIndex + fitnessValue + 1;

			selectionPool.put(fitnessIndex, individual);
			maxPoolKey = fitnessIndex;

		}

		float avg = sum / individuals.size();

		result.Update(allFitness, avg, max, generationNumber);

		return selectionPool;
	}

	public Individual SelectNext() {
		Random r = new Random();
		int nextIndex = r.nextInt(maxPoolKey);

		for (int key : selectionPool.keySet()) {
			
			if (key > nextIndex)
				return selectionPool.get(key);
		}
		return null;
	}

	public Result GetResult() {
		return result;
	}
}

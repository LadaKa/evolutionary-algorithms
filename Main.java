package main;

// TODO: code needs to be cleaned 

public class Main {

	public static void main(String[] args) {
		
		int individualsCount = Integer.parseInt(args[0]); 			// 100
		int individualVectorLength = Integer.parseInt(args[1]); 	// 50
		int generationsCount = Integer.parseInt(args[2]);			// 700
		double mutationProbability = Double.parseDouble(args[3]);	// 0 ; 0.5; 1
		
		int testsCount = 100;
		
		Result[] allResults = new Result[testsCount];
		
		for (int i = 0; i < testsCount; i++)
		{
			Evolution evolution = new Evolution(individualsCount, individualVectorLength, i);
			allResults[i] = evolution.GeneratePopulations(
					generationsCount, mutationProbability, new OneCountFitness());
		}
		
		Result totalResult = Result.ComputeAverageOfAllResults(allResults, generationsCount);
		
		totalResult.Print();
	}

}

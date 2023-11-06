package main;

import java.util.Random;

public class Evolution {

	private int startIndividualsCount;
	private int individualVectorLength;
	
	Random random;

	public Evolution(
			int _startIndividualsCount, int _individualVectorLength, int randomSeed) {	
		
		startIndividualsCount = _startIndividualsCount;
		individualVectorLength = _individualVectorLength;
		random = new Random(randomSeed);
	}

	
	public Result GeneratePopulations(int generationsCount, double mutationProbability, Fitness fitness) {
		
		SelectionByFitness selection = new SelectionByFitness(generationsCount);
		Population currentPopulation = GenerateRandomPopulation();
		
		for (int i = 0; i < generationsCount; i++)
		{
			currentPopulation = GenerateNextPopulation(
					currentPopulation, mutationProbability, fitness, i, selection);
			
		}
		
		return selection.GetResult();
	}
	
	

	private Population GenerateRandomPopulation()
	{
		Population randomPopulation = new Population();
		
		for (int i = 0; i < startIndividualsCount; i++) {
			randomPopulation.AddIndividual(GenerateRandomIndividual());
		}
		
		return randomPopulation;
	}
	
	
	private Population GenerateNextPopulation(
			Population currentPopulation, 
			double mutationProbability, 
			Fitness fitness, 
			int order, 
			SelectionByFitness selection)
	{
		var currentIndividuals =currentPopulation.GetIndividuals();
		selection.CreateSelectionPool(currentIndividuals, fitness, order);
		
		Population nextPopulation = new Population();
		for (int i = 0; i < startIndividualsCount/2; i++) {
			
			Individual parent1 = selection.SelectNext();
			Individual parent2 = selection.SelectNext();
			
			if (random.nextFloat(1)>= mutationProbability)
			{
				Individual[] children = Cross(parent1, parent2);
				nextPopulation.AddIndividual(children[0]);
				nextPopulation.AddIndividual(children[1]);
			}
			else
			{
				int mutationIndex = random.nextInt(parent1.GetIndividualVector().length);
				Individual children1 = new Individual(parent1.GetIndividualVector());
				children1.individualVector[mutationIndex]=!(children1.individualVector[mutationIndex]);
				Individual children2 = new Individual(parent2.GetIndividualVector());
				children2.individualVector[mutationIndex]=!(children2.individualVector[mutationIndex]);
				
				nextPopulation.AddIndividual(children1);
				nextPopulation.AddIndividual(children2);
			}
		}
		
		return nextPopulation;
	}
	
	
	private Individual GenerateRandomIndividual()
	{
		boolean[] individualVector = new boolean[individualVectorLength];
		
		for (int i = 0; i < individualVectorLength; i++) {
			individualVector[i] = random.nextBoolean();
		}
		
		return new Individual(individualVector);
	}

	private Individual[] Cross(Individual parent1, Individual parent2)
	{
		int len = parent1.GetIndividualVector().length;
		Random r = new Random();
		
		boolean[] child1Vector = new boolean[len];
		boolean[] child2Vector = new boolean[len];
		
		int crossIndex = r.nextInt(len-1);
		for (int i = 0; i < crossIndex; i++)
		{
			child1Vector[i] = parent1.GetIndividualVector()[i];
			child2Vector[i] = parent2.GetIndividualVector()[i];
		}
		
		for (int i = crossIndex; i < len; i++)
		{
			child1Vector[i] = parent2.GetIndividualVector()[i];
			child2Vector[i] = parent1.GetIndividualVector()[i];
		}
		
		return new Individual[] 
				{new Individual(child1Vector), new Individual(child2Vector)};
	}


}

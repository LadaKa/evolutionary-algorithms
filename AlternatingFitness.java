package main;

public class AlternatingFitness extends Fitness
{

	@Override
	public int EvaluateIndividualFitness(
			Individual individual) {
		
		int alternationCount = 0;
		boolean previous = individual.GetIndividualVector()[0];

		for(int i = 1; i < individual.GetIndividualVector().length; i++) {
		    if (individual.GetIndividualVector()[i] != previous)
		    {
		    	alternationCount = alternationCount + 1;
		    }
		}
		
		return alternationCount;
	}

	
	@Override
	public boolean HasMaximalFitnessValue(
			Individual individual, int individualFitness) {
		
		return individual.GetIndividualVector().length - 1 == individualFitness;
	}
	
}
package main;

public class OneCountFitness extends Fitness
{

	@Override
	public int EvaluateIndividualFitness(
			Individual individual) {
		
		int oneCount = 0;

		for(boolean b : individual.GetIndividualVector()) {
		    oneCount += b ? 1 : 0;
		}
		
		return oneCount;
	}

	
	@Override
	public boolean HasMaximalFitnessValue(
			Individual individual, int individualFitness) {
		
		return individual.GetIndividualVector().length == individualFitness;
	}
	
}
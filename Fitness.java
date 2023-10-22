package main;

public abstract class Fitness {
	
	public abstract int EvaluateIndividualFitness(
			Individual individual);
	
	public abstract boolean HasMaximalFitnessValue(
			Individual individual, int individualFitness);
}
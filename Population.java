package main;

import java.util.*;

public class Population {
	
	private ArrayList<Individual> individuals;
	
	public Population()
	{
		individuals = new ArrayList<Individual>();
	}
	
	public void AddIndividual(Individual individual)
	{
		individuals.add(individual);
	}
	
	public ArrayList<Individual> GetIndividuals()
	{
		return individuals;
	}
}

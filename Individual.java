package main;

public class Individual {
	
	private boolean[] individualVector; 
	
	public Individual(boolean[] _individualVector)
	{
		individualVector = _individualVector;
	}
	
	public boolean[] GetIndividualVector()
	{
		return individualVector;
	}
}

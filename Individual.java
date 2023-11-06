package main;

public class Individual {
	
	public boolean[] individualVector; // TODO
	
	public Individual(boolean[] _individualVector)
	{
		individualVector = _individualVector;
	}
	
	public boolean[] GetIndividualVector()
	{
		return individualVector;
	}
	
	@Override
	public String toString()
	{
		String result = "[";
		for (boolean b : individualVector)
		{
			int value = b ? 1 : 0;
			result = result + value + " ";
		}
		result = result + "]";
		return result;
	}
	 
}

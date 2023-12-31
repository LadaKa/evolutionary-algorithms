package main;

import java.util.Arrays;

public class Result {
	float[] avg;
	float[] max;
	float[] firstQuartal;
	float[] thirdQuartal;
	
	public Result(int generationCount)
	{
		avg = new float[generationCount];
		max = new float[generationCount];
		firstQuartal = new float[generationCount];
		thirdQuartal = new float[generationCount];
	}
	
	public void Update(float[] allFitness, float _avg, float _max, int index)
	{
		avg[index] = _avg;
		max[index] = _max;
		
		Arrays.sort(allFitness);
		
		int count = allFitness.length;
		
		
		float q1 = allFitness[((count + 1)/4)-1];
		firstQuartal[index] = q1;
		
		float q3 = allFitness[(3*(count + 1)/4)-1];
		thirdQuartal[index] = q3;
	}
	
	
	static Result ComputeAverageOfAllResults(Result[] allResults, int generationCount)
	{
		Result result = new Result(generationCount);
		
		float count = allResults.length;
					
		for (int i = 0; i < generationCount; i++)
		{
			float avg = 0;
			float max = 0;
			float q1 = 0;
			float q3 = 0;
			
			for (Result r : allResults)
			{
				avg = avg + r.avg[i];
				max = max + r.max[i];
				q1 = q1 + r.firstQuartal[i];
				q3 = q3 + r.thirdQuartal[i];
			}
			
			result.avg[i] = avg/count;
			result.max[i] = max/count;
			result.firstQuartal[i] = q1/count;
			result.thirdQuartal[i] = q3/count;
		}
		
		return result;
	}

	// TODO: override?
	
	public void Print()
	{
		Print("avg", avg);
		Print("max", max);
		Print("firstQuartal", firstQuartal);
		Print("thirdQuartal", thirdQuartal);
	}
	
	public void Print(String title, float[] values)
	{
		System.out.println(title);
		for (float value : values)
		{
			System.out.print(value + ", ");
		}
		System.out.println();
		
	}

}
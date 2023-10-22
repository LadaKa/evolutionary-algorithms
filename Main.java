package main;

public class Main {

	public static void main(String[] args) {
		Evolution evolution = new Evolution(10, 5, 0);
		evolution.GeneratePopulations(100, new OneCountFitness());
		System.out.print("End");
	}

}

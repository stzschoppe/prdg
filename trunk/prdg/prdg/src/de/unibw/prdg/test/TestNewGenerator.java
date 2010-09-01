package de.unibw.prdg.test;

import de.unibw.prdg.PseudoRandomDataGenerator;
import de.unibw.prdg.ScenarioGenerator;
import de.unibw.prdg.Verteilung;
import de.unibw.prdg.Verteilungsparameter;

public class TestNewGenerator {
	public static void main(String[] args) {
		double[] parameterB = {0, 100};
		double[] parameterD = {3};
		Verteilungsparameter beginn = new Verteilungsparameter(Verteilung.Uniform, parameterB);
		Verteilungsparameter dauer = new Verteilungsparameter(Verteilung.ChiSqr, parameterD);
		
		ScenarioGenerator generator = new ScenarioGenerator(1000, 0, 100, 252552, beginn, dauer);
		
//		double[] list = new double[1000];
//		PseudoRandomDataGenerator generator = new PseudoRandomDataGenerator(2525255);
//		double my = 0;
//		double sigma = 0;
//		for (int i = 0; i < list.length; i++) {
//			list[i] = generator.nextChiSqrInt(3);
//			my += list[i];
//		}
//		
//		my /= list.length;
//		
//		for (int i = 0; i < list.length; i++) {
//			sigma += Math.pow(list[i]-my, 2);
//		}
//		
//		sigma /=list.length-1;
//		System.out.println("(" + my + ", " 
//				+ sigma + ")");
		
		
		
	}
}

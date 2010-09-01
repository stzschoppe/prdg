package de.unibw.prdg;

import java.security.SecureRandom;
import java.util.Random;

public class PseudoRandomDataGenerator {
	private Random generator;
	private long seed;
	
	public PseudoRandomDataGenerator(long seed) {
		this.generator = new Random(seed);
		this.seed = seed;
	}
	
	public int nextUniformInt(int a, int b) {
		if (b<a) {
			throw new UnsupportedOperationException("Uniforme Verteilung in einem uneigentlichen Intervall.");
		}
		return generator.nextInt(b - a) + a;
	}
	
	public double nextUniformDouble() {
		return generator.nextDouble();
	}
	
	
	public double nextGausian(double my, double sigmaSqr){
		if (sigmaSqr<=0) {
			throw new UnsupportedOperationException("Normalverteilung mit nicht positiver Varianz.");
		}
		return generator.nextGaussian()*Math.sqrt(sigmaSqr)+my;
	}
	
	public int nextGausianInt(double my, double sigmaSqr){
		return (int) Math.round(nextGausian(my, sigmaSqr));
	}
	
	public double nextExponetial(double lambda) {
		if (lambda<=0) {
			throw new UnsupportedOperationException("Exponentialverteilung mit nicht positiver Ausfallrate.");
		}
		return -(1/lambda)*Math.log(generator.nextDouble());
	}
	
	public int nextExponetialInt(double lambda) {
		return (int) Math.round(nextExponetial(lambda));
	}
	
	public double nextChiSqr(int n){
		if (n<1) {
			throw new UnsupportedOperationException("Anzahl der Freiheitsgrade kleiner 1.");
		}
		double result = 0.0;
		for (int i = 0; i < n; i++) {
			result += Math.pow(generator.nextGaussian(), 2);
		}
		return result;
	}
	
	public int nextChiSqrInt(int n){
		return (int)Math.round(nextChiSqr(n));
	}

	public boolean nextBoolean() {
		return generator.nextBoolean();
	}

	public void nextBytes(byte[] bytes) {
		generator.nextBytes(bytes);
	}

	public double nextDouble() {
		return generator.nextDouble();
	}

	public float nextFloat() {
		return generator.nextFloat();
	}

	public double nextGaussian() {
		return generator.nextGaussian();
	}

	public int nextInt() {
		return generator.nextInt();
	}

	public int nextInt(int n) {
		return generator.nextInt(n);
	}

	public long nextLong() {
		return generator.nextLong();
	}
	
	
	
	
	
	
	
	

}

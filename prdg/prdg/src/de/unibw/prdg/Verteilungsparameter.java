package de.unibw.prdg;

public class Verteilungsparameter {
	private final Verteilung art;
	private double parameter[];
	public Verteilungsparameter(Verteilung art, double[] parameter) {
		super();
		this.art = art;
		this.parameter = parameter;
	}
	public Verteilung getArt() {
		return art;
	}
	public double[] getParameter() {
		return parameter;
	}
	
	
}

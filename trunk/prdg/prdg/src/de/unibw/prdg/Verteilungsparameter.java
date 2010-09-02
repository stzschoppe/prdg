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
	@Override
	public String toString() {
		String result ="";
		switch (art) {
		case Uniform: {
			result = "U(" + parameter[0] + ", " + parameter[1] +")";
		}
			break;

		case Normal: {
			result = "N(" + parameter[0] + ", " + parameter[1] +")";
		}
			break;

		case Exponential: {
			result = "Exp(" + parameter[0] +")";
		}
			break;

		case ChiSqr: {
			result = "Chi²(" + parameter[0] +")";
		}
			break;

		default:
			break;
		}
		
		return result;
	}
	
	
}

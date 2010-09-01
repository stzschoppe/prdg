package de.unibw.prdg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import de.unibw.prdg.exceptions.ConstrainException;

public class ScenarioGenerator {
	private final int jobCount;
	private final int start;
	private final int ende;
	private final long seed;
	private final Verteilungsparameter beginnVerteilung;
	private final Verteilungsparameter dauerVerteilung;

	private int[][] jobListe;

	public ScenarioGenerator(int jobCount, int start, int ende, long seed,
			Verteilungsparameter beginnVerteilung,
			Verteilungsparameter dauerVerteilung) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.beginnVerteilung = beginnVerteilung;
		this.dauerVerteilung = dauerVerteilung;

		this.jobListe = new int[jobCount][2];
		erzeugeJobListe();
	}

	private void erzeugeJobListe() {
		PseudoRandomDataGenerator generator = new PseudoRandomDataGenerator(
				seed);

		for (int i = 0; i < jobListe.length; i++) {
			// Beginn des Jobs
			switch (this.beginnVerteilung.getArt()) {
			case Uniform: {
				int a = (int) this.beginnVerteilung.getParameter()[0];
				int b = (int) this.beginnVerteilung.getParameter()[1];
				jobListe[i][0] = Math.max(
						Math.min(generator.nextUniformInt(a, b), ende - 1),
						start);
			}
				break;

			case Normal: {
				double my = this.beginnVerteilung.getParameter()[0];
				double sigmaSqr = this.beginnVerteilung.getParameter()[1];
				jobListe[i][0] = (int) Math.max(Math.min(
						generator.nextGausianInt(my, sigmaSqr), ende - 1),
						start);
			}
				break;

			case Exponential: {
				double lambda = this.beginnVerteilung.getParameter()[0];
				jobListe[i][0] = (int) Math
						.max(Math.min(generator.nextExponetialInt(lambda),
								ende - 1), start);
			}
				break;

			case ChiSqr: {
				int n = (int) this.beginnVerteilung.getParameter()[0];
				jobListe[i][0] = (int) Math.max(
						Math.min(generator.nextChiSqrInt(n), ende - 1), start);
			}
				break;

			default:
				break;
			}

			// Dauer des Jobs
			switch (this.dauerVerteilung.getArt()) {
			case Uniform: {
				int a = (int) this.dauerVerteilung.getParameter()[0];
				int b = (int) this.dauerVerteilung.getParameter()[1];
				jobListe[i][1] = generator.nextUniformInt(a, b);
			}
				break;

			case Normal: {
				double my = this.dauerVerteilung.getParameter()[0];
				double sigmaSqr = this.dauerVerteilung.getParameter()[1];
				jobListe[i][1] = generator.nextGausianInt(my, sigmaSqr);
			}
				break;

			case Exponential: {
				double lambda = this.dauerVerteilung.getParameter()[0];
				jobListe[i][1] = generator.nextExponetialInt(lambda);
			}
				break;

			case ChiSqr: {
				int n = (int) this.dauerVerteilung.getParameter()[0];
				jobListe[i][1] = generator.nextChiSqrInt(n);
			}
				break;

			default:
				break;
			}

			// Stutzen der Dauer, um das Ende nicht zu überschreiten
			// if (jobListe[i][0]+ jobListe[i][1] > ende)
			// jobListe[i][1] = ende - jobListe[i][0];

			//System.out.println(jobListe[i][0] + "-" + jobListe[i][1]);
		}
		System.out.println("Beginn (" + getStichprobenMittelBeginn() + ", " 
				+ getStichprobenVarianzBeginn() + ")");
		System.out.println("Dauer (" + getStichprobenMittelDauer() + ", " 
				+ getStichprobenVarianzDauer() + ")");
	}

	public void saveDataFile(File dataFile) throws IOException {
		FileWriter fw = new FileWriter(dataFile);
		String buffer = "";
		String header = "";

		header += "#test intervalle\n";
		header += "# zeilen mit # = Kommentare\n";
		header += "#	assuming b-c format,\n";
		header += "#		for interval naming a sequencial numbering is used, starting at 0\n";
		header += "#		b starttime,\n";
		header += "#		c endtime,\n";
		header += "#		b and c inclusive\n";
		header += "#		\n";
		header += "#		seed:\t\t " + seed +"\n";
		header += "#		jobcount:\t " + jobCount +"\n";
		header += "#		interval:\t [" + start + ", " + ende +"]\n";
		header += "#		\n";
		header += "#		value\t\tmean\t,\tvariance\n";
		header += "#		" + "starttime\t" + getStichprobenMittelBeginn() + "\t,\t" 
								+ getStichprobenVarianzBeginn() + "\n";
		header += "#		" + "duration\t" + getStichprobenMittelDauer() + "\t,\t" 
								+ getStichprobenVarianzDauer() + "";
		header += "\n";

		fw.write(header);

		for (int i = 0; i < jobListe.length; i++) {
			buffer = jobListe[i][0] + "-"
					+ (jobListe[i][0] + jobListe[i][1] - 1) + "\n";
			fw.write(buffer);
		}

		fw.close();
	}

	public double getStichprobenMittelBeginn() {
		double my = 0;
		for (int i = 0; i < jobListe.length; i++) {
			my += jobListe[i][0];
		}
		my /= jobCount;
		return my;
	}

	public double getStichprobenMittelDauer() {
		double my = 0;
		for (int i = 0; i < jobListe.length; i++) {
			my += jobListe[i][1];
		}
		my /= jobCount;
		return my;
	}

	public double getStichprobenVarianzBeginn() {
		double sigmaSqr = 0;
		double my = getStichprobenMittelBeginn();

		for (int i = 0; i < jobListe.length; i++) {
			sigmaSqr += Math.pow((jobListe[i][0]) - my, 2);
		}
		sigmaSqr /= jobCount - 1;
		return sigmaSqr;
	}

	public double getStichprobenVarianzDauer() {
		double sigmaSqr = 0;
		double my = getStichprobenMittelDauer();

		for (int i = 0; i < jobListe.length; i++) {
			sigmaSqr += Math.pow((jobListe[i][1]) - my, 2);
		}
		sigmaSqr /= jobCount - 1;
		return sigmaSqr;
	}

}

package de.unibw.prdg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import de.unibw.prdg.exceptions.ConstrainException;

public class PseudoRandomDataGenerator {
	private final int jobCount;
	private final int start;
	private final int ende;
	private final long seed;
	private int[][] jobListe;
	private File dataFile;
	
	private final char verteilungBeginn;
	private final double myBeginn;
	private final double sigmaSqrBeginn;
	private final int aBegin;
	private final int bBegin;
	
	private final char verteilungDauer;
	private final double myDauer;
	private final double sigmaSqrDauer;
	private final int aDauer;
	private final int bDauer;
	
	/**
	 * Konstruktor 
	 * Beginn: Normalverteilt
	 * Dauer: Normalverteilt
	 * 
	 * @param jobCount
	 * @param start
	 * @param ende
	 * @param seed
	 * @param dataFile 
	 * @param myBeginn
	 * @param sigmaSqrBeginn
	 * @param myDauer
	 * @param sigmaSqrDauer
	 */
	public PseudoRandomDataGenerator(int jobCount, int start, int ende,
			long seed, File dataFile, double myBeginn,
			double sigmaSqrBeginn, double myDauer, double sigmaSqrDauer) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.dataFile = dataFile;
		this.jobListe = new int[jobCount][2];

		this.verteilungBeginn = 'N';
		this.myBeginn = myBeginn;
		this.sigmaSqrBeginn = sigmaSqrBeginn;
		this.aBegin = -1;
		this.bBegin = -1;

		this.verteilungDauer = 'N';
		this.myDauer = myDauer;
		this.sigmaSqrDauer = sigmaSqrDauer;
		this.aDauer = -1;
		this.bDauer = -1;
		
		try {
			checkConstrains();
			generatePseudorandomDataNN();
			saveDataFile();
			System.out.println("Beginn (" + getStichprobenMittelBeginn() + ", " 
					+ getStichprobenVarianzBeginn() + ")");
			System.out.println("Dauer (" + getStichprobenMittelDauer() + ", " 
					+ getStichprobenVarianzDauer() + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Konstruktor 
	 * Beginn: Normalverteilt
	 * Dauer: Uniformverteilt
	 * 
	 * @param jobCount
	 * @param start
	 * @param ende
	 * @param seed
	 * @param dataFileName
	 * @param myBeginn
	 * @param sigmaSqrBeginn
	 * @param aDauer
	 * @param bDauer
	 */
	public PseudoRandomDataGenerator(int jobCount, int start, int ende,
			long seed, File dataFile, double myBeginn,
			double sigmaSqrBeginn, int aDauer, int bDauer) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.dataFile = dataFile;
		this.jobListe = new int[jobCount][2];

		this.verteilungBeginn = 'N';
		this.myBeginn = myBeginn;
		this.sigmaSqrBeginn = sigmaSqrBeginn;
		this.aBegin = -1;
		this.bBegin = -1;

		this.verteilungDauer = 'U';
		this.myDauer = -1;
		this.sigmaSqrDauer = -1;
		this.aDauer = aDauer;
		this.bDauer = bDauer;
		try {
			checkConstrains();
			generatePseudorandomDataNU();
			saveDataFile();
			System.out.println("Beginn (" + getStichprobenMittelBeginn() + ", " 
					+ getStichprobenVarianzBeginn() + ")");
			System.out.println("Dauer (" + getStichprobenMittelDauer() + ", " 
					+ getStichprobenVarianzDauer() + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Konstruktor 
	 * Beginn: Uniformverteilt
	 * Dauer: Normalverteilt
	 * 
	 * @param jobCount
	 * @param start
	 * @param ende
	 * @param seed
	 * @param dataFileName
	 * @param myDauer
	 * @param sigmaSqrDauer
	 */
	public PseudoRandomDataGenerator(int jobCount, int start, int ende,
			long seed, File dataFile, double myDauer, double sigmaSqrDauer) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.dataFile = dataFile;
		this.jobListe = new int[jobCount][2];

		this.verteilungBeginn = 'U';
		this.myBeginn = -1;
		this.sigmaSqrBeginn = -1;
		this.aBegin = start;
		this.bBegin = ende;

		this.verteilungDauer = 'N';
		this.myDauer = myDauer;
		this.sigmaSqrDauer = sigmaSqrDauer;
		this.aDauer = -1;
		this.bDauer = -1;
		
		try {
			checkConstrains();
			generatePseudorandomDataUN();
			saveDataFile();
			System.out.println("Beginn (" + getStichprobenMittelBeginn() + ", " 
					+ getStichprobenVarianzBeginn() + ")");
			System.out.println("Dauer (" + getStichprobenMittelDauer() + ", " 
					+ getStichprobenVarianzDauer() + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Konstruktor 
	 * Beginn: Uniformverteilt
	 * Dauer: Uniformverteilt
	 * 
	 * @param jobCount
	 * @param start
	 * @param ende
	 * @param seed
	 * @param dataFileName
	 * @param aDauer
	 * @param bDauer
	 */
	public PseudoRandomDataGenerator(int jobCount, int start, int ende,
			long seed, File dataFile, int aDauer, int bDauer) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.dataFile = dataFile;
		this.jobListe = new int[jobCount][2];

		this.verteilungBeginn = 'U';
		this.myBeginn = -1;
		this.sigmaSqrBeginn = -1;
		this.aBegin = start;
		this.bBegin = ende;

		this.verteilungDauer = 'U';
		this.myDauer = -1;
		this.sigmaSqrDauer = -1;
		this.aDauer = aDauer;
		this.bDauer = bDauer;
		
		try {
			checkConstrains();
			generatePseudorandomDataUU();
			saveDataFile();
			System.out.println("Beginn (" + getStichprobenMittelBeginn() + ", " 
					+ getStichprobenVarianzBeginn() + ")");
			System.out.println("Dauer (" + getStichprobenMittelDauer() + ", " 
					+ getStichprobenVarianzDauer() + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Überprüft die Einhaltung von logischen Anforderungen an die Eingabedaten
	 * @throws ConstrainException
	 */ //TODO Anforderungen ergänzen
	public void checkConstrains() throws ConstrainException{
		
		// allgemeine Constrains
		if (jobCount <= 0) {
			throw new ConstrainException("JobCount ist kleiner oder gleich 0.");
		}
		if (start < 0) {
			throw new ConstrainException("Start der Jobs vor dem Zeitpunkt 0.");
		}
		if (start > ende) {
			throw new ConstrainException("Uneigentliches Zeitintervall, Startzeitpunkt liegt nach Endzeitpunkt.");
		}
		
		
		// Verteilungsspezifische Constrains zum Beginn der Jobs
		switch (verteilungBeginn) {
		case 'U':
			// Nichts zu Prüfen, da die Einstellungen Automatisch vorgeneommen werden
			break;
		
		case 'N':{
			if (myBeginn < start || myBeginn > ende) {
				throw new ConstrainException("Mittelwert des Beginns liegt nicht innerhalb von Start und Endzeit.");
			}
			if (sigmaSqrBeginn <= 0) {
				throw new ConstrainException("Varianz der Beginnzeiten ist nicht positiv.");
			}
		}
			break;

		default:
			throw new ConstrainException("Bezeichnung der Verteilung nicht bekannt.");
		}
		
		// Verteilungsspezifische Constrains zur Dauer der Jobs
		switch (verteilungDauer) {
		case 'U':{
			if (aDauer > ende-start) {
				throw new ConstrainException("Minimale Dauer ist länger als der Zeitraum der Gesamtzeit");
			}
			if (bDauer > ende-start) {
				throw new ConstrainException("Maximale Dauer ist länger als der Zeitraum der Gesamtzeit");
			}
			if (aDauer <= 0) {
				throw new ConstrainException("Minimale Dauer ist nicht positiv");
			}
			if (bDauer <= 0) {
				throw new ConstrainException("Maximale Dauer ist nicht positiv");
			}
			if (aDauer > bDauer) {
				throw new ConstrainException("Uneigentliches Zeitintervall, maximale Zeit ist kleiner als die minimale.");
			}
			if (bDauer-aDauer > ende-start) {
					throw new ConstrainException("Mögliche Dauer ist größer als Gesamtzeit.");
			}
		}
			break;
		case 'N':{
			if (myDauer <= 0) {
				throw new ConstrainException("Mittelwert der Dauer ist negativ.");
			}
			if (sigmaSqrDauer <= 0) {
				throw new ConstrainException("Varianz der Beginnzeiten ist nicht positiv.");
			}	
			if (myDauer > ende-start) {
				throw new ConstrainException("Dauer ist länger als der Zeitraum der Gesamtzeit");
			}
		}
			break;
		default:
			throw new ConstrainException("Bezeichnung der Verteilung nicht bekannt.");
		}
	}
	
	private void generatePseudorandomDataUU(){
		Random generator = new Random(seed);
		for (int i = 0; i < jobListe.length; i++) {
			// Beginn des Jobs (Uniformverteilt)
			jobListe[i][0] = Math.max(Math.min(generator.nextInt(bBegin - aBegin) + aBegin, ende-1), start);
			
			// Dauer des Jobs (Uniformverteilt)
			jobListe[i][1] = generator.nextInt(bDauer - aDauer) + aDauer;
			if (jobListe[i][0]+ jobListe[i][1] > ende) 
				jobListe[i][1] = ende - jobListe[i][0];
			
		System.out.println(jobListe[i][0] + "-" + jobListe[i][1]);
		}
	}
	
	private void generatePseudorandomDataNU(){
		Random generator = new Random(seed);
		for (int i = 0; i < jobListe.length; i++) {
			// Beginn des Jobs (Normalverteilt)
			jobListe[i][0] = (int) Math.max(Math.min(Math.round(generator.nextGaussian()*Math.sqrt(sigmaSqrBeginn)+myBeginn), ende-1), start);
			
			// Dauer des Jobs (Uniformverteilt)
			jobListe[i][1] = generator.nextInt(bDauer - aDauer) + aDauer;
			if (jobListe[i][0]+ jobListe[i][1] > ende) 
				jobListe[i][1] = ende - jobListe[i][0];
			
		System.out.println(jobListe[i][0] + "-" + jobListe[i][1]);
		}
	}
	
	private void generatePseudorandomDataUN(){
		Random generator = new Random(seed);
		for (int i = 0; i < jobListe.length; i++) {
			// Beginn des Jobs (Uniformverteilt)
			jobListe[i][0] = Math.max(Math.min(generator.nextInt(bBegin - aBegin) + aBegin, ende-1), start);
			
			// Dauer des Jobs (Normalverteilt)
			jobListe[i][1] = (int) Math.round(generator.nextGaussian()*Math.sqrt(sigmaSqrDauer)+myDauer);
			if (jobListe[i][0]+ jobListe[i][1] > ende) 
				jobListe[i][1] = ende - jobListe[i][0];
			
		System.out.println(jobListe[i][0] + "-" + jobListe[i][1]);
		}
	}
	
	private void generatePseudorandomDataNN(){
		Random generator = new Random(seed);
		for (int i = 0; i < jobListe.length; i++) {
			// Beginn des Jobs (Normalverteilt)
			jobListe[i][0] = (int) Math.max(Math.min(Math.round(generator.nextGaussian()*Math.sqrt(sigmaSqrBeginn)+myBeginn), ende-1), start);
			
			// Dauer des Jobs (Normalverteilt)
			jobListe[i][1] = (int) Math.round(generator.nextGaussian()*Math.sqrt(sigmaSqrDauer)+myDauer);
			if (jobListe[i][0]+ jobListe[i][1] > ende) 
				jobListe[i][1] = ende - jobListe[i][0];
			
		System.out.println(jobListe[i][0] + "-" + jobListe[i][1]);
		}
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
			sigmaSqr += Math.pow((jobListe[i][0])- my, 2);
		}
		sigmaSqr /= jobCount-1;
		return sigmaSqr;
	}

	public double getStichprobenVarianzDauer() {
		double sigmaSqr = 0;
		double my = getStichprobenMittelDauer();
		
		for (int i = 0; i < jobListe.length; i++) {
			sigmaSqr += Math.pow((jobListe[i][1])- my, 2);
		}
		sigmaSqr /= jobCount-1;
		return sigmaSqr;
	}
	
	private void saveDataFile() throws IOException{
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
			header += "\n";
			
			fw.write(header);
			
			for (int i = 0; i < jobListe.length; i++) {
				buffer = jobListe[i][0] + "-" + (jobListe[i][0]+jobListe[i][1]-1)+"\n";
				fw.write(buffer);
			}
			
			fw.close();
	}

}

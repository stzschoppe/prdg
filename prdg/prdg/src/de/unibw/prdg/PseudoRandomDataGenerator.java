package de.unibw.prdg;

import java.io.File;

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
	 * @param dataFileName
	 * @param myBeginn
	 * @param sigmaSqrBeginn
	 * @param myDauer
	 * @param sigmaSqrDauer
	 */
	public PseudoRandomDataGenerator(int jobCount, int start, int ende,
			long seed, String dataFileName, double myBeginn,
			double sigmaSqrBeginn, double myDauer, double sigmaSqrDauer) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.dataFile = new File(dataFileName);
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
			long seed, String dataFileName, double myBeginn,
			double sigmaSqrBeginn, int aDauer, int bDauer) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.dataFile = new File(dataFileName);
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
			long seed, String dataFileName, double myDauer, double sigmaSqrDauer) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.dataFile = new File(dataFileName);
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
			long seed, String dataFileName, int aDauer, int bDauer) {
		super();
		this.jobCount = jobCount;
		this.start = start;
		this.ende = ende;
		this.seed = seed;
		this.dataFile = new File(dataFileName);
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
	}
	
	public void checkConstrains() throws ConstrainException{
		
		// allgemeine Constrains
		if (jobCount <= 0) {
			throw new ConstrainException("JobCount ist kleiner oder gleich 0.");
		}
		if (start < 0) {
			throw new ConstrainException("Start der Jobs vor dem Zeitpunkt 0.");
		}
		if (start > ende) {
			throw new ConstrainException("Uneigentliches Zeitintervall, Startzeitpunkt liegt nach Endzeitpunkt");
		}
		
		
		// Verteilungsspezifische Constrains zum Beginn der Jobs
		switch (verteilungBeginn) {
		case 'U':
			// Nichts zu Prüfen, da die Einstellungen Automatisch vorgeneommen werden
			break;
		
		case 'N':
			if (myBeginn < start || myBeginn > ende) {
				throw new ConstrainException("Mittelwert des Beginns liegt nicht innerhalb von Start und Endzeit");
			}
			if (sigmaSqrBeginn <= 0) {
				throw new ConstrainException("Varianz der Beginnzeiten muss positiv sein.");
			}
			break;

		default:
			throw new ConstrainException("Bezeichnung der Verteilung nicht bekannt.");
		}
		
		// Verteilungsspezifische Constrains zur Dauer der Jobs
		switch (verteilungDauer) {
		case 'U':
			//TODO
			break;
		case 'N':
			//TODO
			break;
		default:
			throw new ConstrainException("Bezeichnung der Verteilung nicht bekannt.");
		}
		
	}
	
	

}

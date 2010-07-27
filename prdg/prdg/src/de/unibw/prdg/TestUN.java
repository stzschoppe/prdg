package de.unibw.prdg;

import java.io.File;

public class TestUN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PseudoRandomDataGenerator Generator = new PseudoRandomDataGenerator(10000, 0, 1000, 47, new File("testUN.txt"), 30., 200.);
	}

}

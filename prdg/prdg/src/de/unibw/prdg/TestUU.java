package de.unibw.prdg;

import java.io.File;

public class TestUU {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PseudoRandomDataGenerator Generator = new PseudoRandomDataGenerator(1000, 0, 10, 55, new File("testUU.txt"), 1, 5);
	}

}

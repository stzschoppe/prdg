package de.unibw.prdg.test;

import java.io.File;

import de.unibw.prdg.deprecated.XXXPseudoRandomDataGenerator;

public class TestUN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XXXPseudoRandomDataGenerator Generator = new XXXPseudoRandomDataGenerator(10000, 0, 1000, 47, new File("testUN.txt"), 30., 200.);
	}

}

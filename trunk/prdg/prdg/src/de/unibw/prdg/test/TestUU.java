package de.unibw.prdg.test;

import java.io.File;

import de.unibw.prdg.deprecated.XXXPseudoRandomDataGenerator;

public class TestUU {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XXXPseudoRandomDataGenerator Generator = new XXXPseudoRandomDataGenerator(1000, 0, 10, 55, new File("testUU.txt"), 1, 5);
	}

}

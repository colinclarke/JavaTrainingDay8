package com.hcl.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.println(">> Print the contents of a legitimate file");
		printFile("C:\\Users\\colin_clarke\\eclipse-workspace\\day8\\src\\main\\java\\testFile.txt");
		System.out.println(">> Print the contents of a non-existant file");
		printFile("nonExistantFile.txt");

		System.out.println("\n>> Test custom exceptions");
		try {
			throw new ExceptionC("This exception is type Exception C");
		} catch (ExceptionA e) {
			System.out.println(e.getClass());
			System.out.println("Exception C caught by type Exception A");
		}
	}

	static void printFile(String pathname) {
		File file = new File(pathname);
		try (Scanner reader = new Scanner(file)) {
			while (reader.hasNextLine()) {
				System.out.println(reader.nextLine());
			}
			System.out.println("Reached end of file");
		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
		}
	}
}

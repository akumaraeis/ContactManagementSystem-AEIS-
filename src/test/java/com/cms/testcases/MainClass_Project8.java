package com.cms.testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.testng.TestNG;

public class MainClass_Project8 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Please enter the path to your xml file(Regression Suite):-");
	    String path2 = scanner.nextLine();
	    
	    File file = new File(path2);
//		File file = new File("C:\\Users\\ATLAS-ADMIN\\eclipse-workspace\\AEIS-ContactCentre-Project8\\Create_MultipleAccount_testng.xml");
		if (file.exists()) {
		    TestNG testng = new TestNG();
		    List<String> suites = new ArrayList<>();
		    suites.add(file.getAbsolutePath());
		    testng.setTestSuites(suites);
		    testng.run();
		} else {
		    System.out.println("File not found: " + file.getAbsolutePath());
		}

}
}




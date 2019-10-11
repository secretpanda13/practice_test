package com.incuventure.arbitraryobject.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.incuventure.arbitaryobject.view.ElementView;
import com.incuventure.arbitraryobject.controller.FileController;
import com.incuventure.utility.FileWriter;

public class ReportFileGeneratorDemo {

	public static void main(String[] args) {

		// Input file and Populate it to An ArrayList of HashMap
		String textInputLoc = "C:\\work\\testing.txt";
		String ruleFileLoc = "C:\\work\\ruleFile.txt";
		
		FileController myController = new FileController();
		myController.ReadandPopulateMap(textInputLoc);
		
		
		ArrayList<HashMap> checkElements = myController.getElements();
		
		
		myController.generateRule(ruleFileLoc);
		System.out.println(myController.getGroupByParameter());
		ElementView.displayFilterByElements(myController.getFilterParameters());
	
		
		String attributes =ElementView.displayAttributes(myController.getAttributes().getAttributes());
		System.out.println(attributes);
		
		FileWriter.writeToFile(attributes, checkElements,myController.getFilterParameters());
		
		
	}
}


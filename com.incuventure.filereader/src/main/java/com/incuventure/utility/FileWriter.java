package com.incuventure.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.incuventure.arbitaryobject.view.ElementView;

;

public class FileWriter {

	public static void writeToFile(String Attributes,
		ArrayList<HashMap> elements, ArrayList<String> filterBy) {
		ArrayList<HashMap> notIncludedElements = new ArrayList<HashMap>();

		for (int a = 0; a < elements.size(); a++) {
			HashMap elementNth = elements.get(a);
			int booleanCount = 0;
			System.out.println("element:" + elementNth);
			for(int c=0;c<filterBy.size();c++){
				String category=filterBy.get(c).trim();
				System.out.println("category"+category);
				System.out.println(elementNth.containsValue(category));
				if(elementNth.containsValue(category)){booleanCount++;}
			}
			if(booleanCount==0){
				notIncludedElements.add(elementNth);
			}

		}
		if (filterBy.size() == 0) {
			int number = 1;
			writeToSingleFile(Attributes, elements, number);
		} else {
			for (int b = 0; b < filterBy.size(); b++) {
				System.out.println("--Generating file-----");
				System.out.println("filterBy: " + filterBy.get(b));
				writeToManyFile(Attributes, elements, b, filterBy.get(b).trim());
			}
			writeToSingleFile(Attributes, notIncludedElements, 1);
		}

	}

	public static void writeToSingleFile(String Attributes,
			ArrayList<HashMap> elements, int number) {
		PrintWriter printWriter = null;
		try {

			printWriter = new PrintWriter("C:/work/" + number + ".txt", "UTF-8");
			printWriter.println(Attributes);
			for (int a = 0; a < elements.size(); a++) {
				ElementView.displayElements(elements.get(a), printWriter);
				printWriter.println("");
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (UnsupportedEncodingException unsupportedEncodingException) {
			unsupportedEncodingException.printStackTrace();
		} finally {
			printWriter.close();
		}
	}

	public static void writeToSingleFile(String Attributes,
			ArrayList<HashMap> elements, int number, String notFilter) {
		PrintWriter printWriter = null;
		try {

			printWriter = new PrintWriter("C:/work/" + number + ".txt", "UTF-8");
			printWriter.println(Attributes);
			for (int a = 0; a < elements.size(); a++) {
				int num = ElementView.displaynotIncluded(elements.get(a),
						printWriter, notFilter);
				if (num > 0) {
					printWriter.println("");
				}
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (UnsupportedEncodingException unsupportedEncodingException) {
			unsupportedEncodingException.printStackTrace();
		} finally {
			printWriter.close();
		}
	}

	public static void writeToManyFile(String Attributes,
			ArrayList<HashMap> elements, int number, String filterElements) {
		PrintWriter printWriter = null;
		try {

			printWriter = new PrintWriter("C:/work/" + filterElements + ".txt",
					"UTF-8");
			printWriter.println(Attributes);
			for (int a = 0; a < elements.size(); a++) {
				int num = ElementView.displayElementsByFilter(elements.get(a),
						printWriter, filterElements);
				if (num > 0) {
					printWriter.println("");
				}
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (UnsupportedEncodingException unsupportedEncodingException) {
			unsupportedEncodingException.printStackTrace();
		} finally {
			printWriter.close();
		}
	}

}

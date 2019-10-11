package com.incuventure.arbitaryobject.view;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class ElementView {

	public static int displayElementsByFilter(HashMap map,
			PrintWriter printWriter, String filter) {
		int a=0;
		Object[] valueArray = map.keySet().toArray();
		for (int b = 0; b < valueArray.length; b++) {
			if (map.containsValue(filter)) {
				a++;
				if (b == valueArray.length - 1) {
					printWriter.print((String) map.get(valueArray[b]));
				} else {
					printWriter.print((String) map.get(valueArray[b]) + ", ");
				}	
			}

		}
		return a;

	}

	public static int displaynotIncluded(HashMap map,
			PrintWriter printWriter, String filter) {
		int a=0;
		Object[] valueArray = map.keySet().toArray();
		for (int b = 0; b < valueArray.length; b++) {
			if (!(map.containsValue(filter))) {
				a++;
				if (b == valueArray.length - 1) {
					printWriter.print((String) map.get(valueArray[b]));
				} else {
					printWriter.print((String) map.get(valueArray[b]) + ", ");
				}	
			}

		}
		return a;

	}
	
	public static void displayElements(HashMap map, PrintWriter printWriter) {
		Object[] valueArray = map.keySet().toArray();
		for (int b = 0; b < valueArray.length; b++) {
			if (b == valueArray.length - 1) {
				printWriter.print((String) map.get(valueArray[b]));
			} else {
				printWriter.print((String) map.get(valueArray[b]) + ", ");
			}

		}
	}

	public static void displayElements(ArrayList<HashMap> input,
			PrintWriter printWriter) {
		for (int a = 0; a < input.size(); a++) {
			HashMap map = input.get(a);
			displayElements(map, printWriter);
		}
	}

	public static void displayFilterByElements(ArrayList<String> input) {
		for (int a = 0; a < input.size(); a++) {
			System.out.println("-----------Start of filter param:" + a
					+ "-----------");
			System.out.println(input.get(a));
			System.out.println("-----------End of filter param:" + a
					+ "-----------");
		}
	}

	// Generate Attributes
	public static String displayAttributes(ArrayList<String> input) {
		String retAttributes = "";
		for (int a = 0; a < input.size(); a++) {
			if (a == input.size() - 1) {
				retAttributes += (input.get(a));
			} else {
				retAttributes += (input.get(a) + ", ");
			}

		}
		return retAttributes;
	}

}

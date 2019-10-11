package com.incuventure.utility;

import java.util.ArrayList;


public class StringUtility {

	public static boolean isEmptyOrNull(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmptyOrNull(ArrayList input) {
		return input == null || input.size() < 1;
	}

	public static ArrayList<String> convertToArraylist(String[] input) {
		ArrayList<String> inputs = new ArrayList<String>();
		for (int a = 0; a < input.length; a++) {
			inputs.add(input[a]);
		}
		return inputs;
	}

	public static String[] split(String sCurrentLine, String delimeter) {
		// TODO Auto-generated method stub
		if (!isEmptyOrNull(sCurrentLine)) {
			String trimWhiteSpace = sCurrentLine.replaceAll("\\s", "");
			return trimWhiteSpace.split(",");
		}
		return null;
	}

}

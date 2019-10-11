package com.incuventure.utility;

import java.util.ArrayList;
import java.util.HashMap;

import com.incuventure.arbitraryobject.model.FieldAttributes;

public class DataPopulator {
	
	public static HashMap<String, String> toHashMap(ArrayList arrayListCurrentLine, FieldAttributes attributes){
		HashMap<String, String> value = new HashMap<String, String>();
		for (int c = 0; c < arrayListCurrentLine.size(); c++) {
			value.put(attributes.getAttribute(c),(String) arrayListCurrentLine.get(c));
		}
		return value;
		
	}
	
	
	
	
	

}

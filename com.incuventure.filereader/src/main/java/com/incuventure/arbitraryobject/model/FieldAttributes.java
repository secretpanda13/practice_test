package com.incuventure.arbitraryobject.model;

import java.util.ArrayList;
import com.incuventure.utility.StringUtility;;

public class FieldAttributes {

	private ArrayList<String> fields;

	public ArrayList<String> getAttributes() {
		return fields;
	}

	public void setAttributes(ArrayList<String> attributes) {
		if (!StringUtility.isEmptyOrNull(attributes)) {
			this.fields = attributes;
		}
	}

	public String getAttribute(int position) {
		if (position < this.fields.size()) {
			return fields.get(position).toString();
		} else {
			return "non-existent attribute";
		}
	}
	

	public int getAttributePosition(String attribute){
		if(StringUtility.isEmptyOrNull(attribute)){
			return 0;
		} else{
			return fields.indexOf(attribute);
		}
	}
	
	public void Display(){		
		for(int a=0;a<fields.size();a++){
			System.out.println(fields.get(a));		
		}
	}

}

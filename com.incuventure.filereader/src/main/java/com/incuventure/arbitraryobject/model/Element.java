package com.incuventure.arbitraryobject.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.incuventure.arbitaryobject.view.ElementView;
import com.incuventure.utility.StringUtility;

public class Element {
	
	@SuppressWarnings("rawtypes")
	ArrayList<HashMap> elements;
	int position;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<HashMap> getElements() {
		return elements;
	}

	public void setElements(@SuppressWarnings("rawtypes") ArrayList<HashMap> elements) {
		if (!StringUtility.isEmptyOrNull(elements)) {
		this.elements = elements;
		}
	}
	
	public void Display(){
		for(int a=0;a<elements.size();a++){
			System.out.println("Row:" + a);
			HashMap map = elements.get(a);
			//ElementView.displayElements(map);
		}
	}
}

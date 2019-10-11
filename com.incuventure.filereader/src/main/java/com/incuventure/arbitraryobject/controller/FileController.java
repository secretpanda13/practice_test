package com.incuventure.arbitraryobject.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.incuventure.arbitraryobject.model.FieldAttributes;
import com.incuventure.arbitraryobject.model.Element;
import com.incuventure.utility.StringUtility;
import com.incuventure.utility.DataPopulator;



public class FileController {

	ArrayList<HashMap> elements = new ArrayList<HashMap>();
	ArrayList<String> filterParameters = new ArrayList<String>();
	FieldAttributes attributes = new FieldAttributes();
	
	public FieldAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(FieldAttributes attributes) {
		this.attributes = attributes;
	}

	String groupByParameter;
	
	

	public ArrayList<String> getFilterParameters() {
		return filterParameters;
	}

	public void setFilterParameters(ArrayList<String> filterParameters) {
		this.filterParameters = filterParameters;
	}

	public String getGroupByParameter() {
		return groupByParameter;
	}

	public void setGroupByParameter(String groupByParameter) {
		this.groupByParameter = groupByParameter;
	}

	public ArrayList<HashMap> getElements() {
		return elements;
	}

	public void setElements(ArrayList<HashMap> elements) {
		this.elements = elements;
	}

	public void ReadandPopulateMap(String fileInput) {

		BufferedReader br = null;
		try {

			String sCurrentLine;
			Element element = new Element();
			ArrayList<HashMap> elements = new ArrayList<HashMap>();

			br = new BufferedReader(new FileReader(fileInput));
			int a = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] arrayCurrentLine = StringUtility.split(sCurrentLine,
						",");
				ArrayList<String> arrayListCurrentLine = StringUtility
						.convertToArraylist(arrayCurrentLine);
				if (a == 0) {
					attributes.setAttributes(arrayListCurrentLine);
				} else {
					HashMap<String, String> value = DataPopulator.toHashMap(
							arrayListCurrentLine, attributes);
					elements.add(value);
				}
				a++;
			}
			element.setElements(elements);
			setElements(elements);
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void generateRule(String fileInput){
		BufferedReader br = null;
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(fileInput));
			int a = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				
				if (a == 0) {
					String[] group = sCurrentLine.split(" ");
					setGroupByParameter(group[group.length-1]);
					System.out.println("Group:" + group[group.length-1]);
				} else {
					String[] filter = sCurrentLine.split("=");
					String filterBy = filter[filter.length-1];
					System.out.println("FilterBy:" + filterBy);
					filterParameters.add(filterBy);
				}
				a++;
			}
			setFilterParameters(filterParameters);
			
			

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void generateReports(){
		if(filterParameters.size()==0){
			
		}
	}
	

}

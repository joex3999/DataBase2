package DBApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

import DBApp.Page;

public class Page {

	String[][] data;
	boolean[] deleted;
	int current;
	String path;

	// First Step: Constructing a page - You should initialize the variables
	// given above -
	public Page(int noCol, String path) {
		data = new String[200][noCol];
		deleted = new boolean[200];
		current = 0;
		this.path = path;
	}

	// Function1: A function that checks if the page is full
	public boolean isFull() {
		if (current == 200)
			return true;
		else
			return false;
	}

	// Function2: Inserting a record into the page
	public boolean insert(String[] val) {

		if (!isFull()) {
			insertCSV(val);
			for (int i = 0; i < val.length; i++)
				data[current][i] = val[i];
				current++;
				} else
					return false;

		return true;

	}

	public void insertCSV(String[] val) {
		try {

			FileWriter writer = new FileWriter(path);
			String newline;

			for (int i = 0; i < current; i++) {
				for (int j = 0; j < data[i].length; j++) {
					writer.append(data[i][j]);
					writer.append(j == data[i].length - 1 ? "\n" : ",");
				}
			} // old values insertion ; 

			for (int i = 0; i < val.length; i++) {
				writer.append(val[i]);
				writer.append(i == val.length - 1 ? "\n" : ",");

			}	 // new values insertion ; 
			writer.flush();
			writer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Function3: Inserting a set of records into a page - It will use
	// Function2-
	public Page getData(int[] colNum) {

		return null;
	}

}

package com.osmosis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution5 {
	//    public class Solution {
	    private static final Scanner scan = new Scanner(System.in);
	    
	    public static void main(String args[]) throws Exception {
	        // read the string filename
	        String filename;
	        filename = scan.nextLine();
	        PrintWriter pw = new PrintWriter("records_"+filename);

			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));

			String line1 = br.readLine();
			line1 = line1.substring(0, line1.indexOf(" "));
			
			Map<String, Integer> inputFileMap = new LinkedHashMap<>();

			while (line1 != null) {
				if (inputFileMap.containsKey(line1)) {
					inputFileMap.put(line1, inputFileMap.get(line1) + 1);
				} else {
					inputFileMap.put(line1, 1);
				}
				line1 = br.readLine();
				if (line1 != null) {
					line1 = line1.substring(0, line1.indexOf(" "));
				}
			}
	        		System.out.println(inputFileMap);

			for (String value : inputFileMap.keySet()) {
				pw.println(value + " " + inputFileMap.get(value));
			}
			pw.flush();
			br.close();
		}
	}
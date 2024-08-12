package com.example.findneedles;

import java.util.HashSet;
import java.util.Set;

//import com.google.gson.Gson;

//import java.util.Random;
//import com.google.gson.Gson;
//import java.util.HashSet;
//import java.util.Set;

public class TesterFinder {

	public static void main(String[] args) {
		
		
		String haystack = "Like finding a needle in a haystack";
		
		String[] needles = {"finding","needle","a","haystack"};

		findNeedles(haystack, needles);

	}
	
	public static void findNeedles(String haystack, String[] needles) {

		int maxCount = 5;
		
		//to store the random needles
		Set<String> stringSet = new HashSet<>();
		
		// error if index is greater than 5
		if (needles.length > 5) {
			//System.err.println("Too many words!");
			System.err.println("The maximum number of needles is " + maxCount); 
		}
		// create int array with same index count as needles[]
		else {

			int[] countArray = new int[needles.length];

			// new string array splitting words in haystack one per index
			for (int i = 0; i < needles.length; i++) {
				String[] words = haystack.split("[ \"\'\t\n\b\f\r]", 0);

				// finding matches
				for (int j = 0; j < words.length; j++) {

					if (words[j].compareTo(needles[i]) == 0) {
						countArray[i]++;
						stringSet.add(words[j]);
					}
				}
			}
			System.out.println("{\n\"needles\":[");
			
			for (int j = 0; j < needles.length; j++) {
				System.out.println(" {\"needle\": " + 
										"\"" + needles[j] + "\"" + 
										",\n  \"count\": " + 
										"\"" + countArray[j] + "\"}");
				if (needles[j] != needles[needles.length-1]) {
					System.out.print(",");
				}
			}
			
			System.out.println("  ]\n}");

		}
	}

}
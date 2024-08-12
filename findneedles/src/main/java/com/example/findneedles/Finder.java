package com.example.findneedles;

public class Finder {
	
	public static void findNeedles(String haystack, String[] needles) {

		int maxCount = 5;
		
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

				// word can have more than 5 words
				for (int j = 0; j < words.length; j++) {

					if (words[j].compareTo(needles[i]) == 0) {
						countArray[i]++;
					}
				}
			}
//			for (int j = 0; j < needles.length; j++) {
//				System.out.println(needles[j] + ": " + countArray[j]);
//			}
		}
	}

}

package com.example.findneedles;

import java.util.Random;
import com.google.gson.Gson;
import java.util.HashSet;
import java.util.Set;

public class TesterNumbers {

	public static void main(String[] args) {
		
		//String game = "powerball";
		String game = "pick5";
		//String game = "lotto";
		
		getLottoNumbers(game);
	}

	public static void getLottoNumbers(String game) {
		
		if (!(game.equals("pick4")|game.equals("pick5")|game.equals("lotto"))) {
			System.out.println(game + " is not a valid game type. Values must be pick4, pick5, or lotto.");
			
		}
		else {
			
			int count = 4;
			
			//set count for random numbers

			if (game.equals("pick4")) {
				count = 4;
			}
			if (game.equals("pick5")) {
				count = 5;
			}
			if (game.equals("lotto")) {
				count = 6;
			}
			
			//to store the random numbers
			Set<Integer> numbers = new HashSet<>();

			// Create an instance of Random
			Random random = new Random();

			// Generate and add the random numbers to hashset. #'s between 1-47
			for (int i = 0; i < count; i++) {
				int randomNumber = random.nextInt(47) + 1;
				numbers.add(randomNumber);

				// Generates a number between 1 and 47
				// System.out.println(randomNumber);
			}
			//create new gson object		
			 Gson gson = new Gson();	
			 
			//convert numbers to json
			 String json = gson.toJson(numbers);
			 
			 //print numbers in json format
			 System.out.println("{\n \"" + game + "\": " + json + "\n}");
			
		}

		
	}
	
	
}
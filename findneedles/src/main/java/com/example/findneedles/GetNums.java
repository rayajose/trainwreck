package com.example.findneedles;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GetNums {
	
	@GetMapping("/api/numbers")
	
	public String handleRequest(@RequestParam String game) {		
		// Capture the output of System.out.println
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		PrintStream printStream = new PrintStream(outputStream);
		PrintStream originalOut = System.out;
		
		System.setOut(printStream);

		// Call the method that prints to System.out		
		Rando.getLottoNumbers(game);
		
		// Restore the original System.out
		System.setOut(originalOut);
		
		// Return the captured output as a string
		return outputStream.toString();

	}
}

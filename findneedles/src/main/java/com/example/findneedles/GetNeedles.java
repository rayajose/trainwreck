package com.example.findneedles;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

//curl "http://localhost:8080/api/needlesget?name=John&tags=tag1&tags=tag2&tags=tag3"

public class GetNeedles {

	@GetMapping("/api/get/needles")
	
	public String handleRequest(@RequestParam String haystack, @RequestParam String[] needles) {
		
				// Capture the output of System.out.println
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

				PrintStream printStream = new PrintStream(outputStream);

				PrintStream originalOut = System.out;
				//PrintStream errorMessage = System.err;

				System.setOut(printStream);

				// Call the method that prints to System.out
				//findNeedles(haystack, needles);
				Finder.findNeedles(haystack, needles);

				// Restore the original System.out
				System.setOut(originalOut);
				

				// Return the captured output as a string
				return outputStream.toString();
		
	}

}

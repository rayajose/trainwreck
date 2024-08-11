package com.example.findneedles;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostNeedles {

	@PostMapping("/api/post/needles")

	public String getOutput(@RequestBody NeedlesDto request) {

		String haystack = request.getHaystack();
		String[] needles = request.getNeedles();

		// Capture the output of System.out.println
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		PrintStream printStream = new PrintStream(outputStream);

		PrintStream originalOut = System.out;
		//PrintStream errorMessage = System.err;

		System.setOut(printStream);

		// Call the method that prints to System.out
		Finder.findNeedles(haystack, needles);

		// Restore the original System.out
		System.setOut(originalOut);
		

		// Return the captured output as a string
		return outputStream.toString();

	}

}
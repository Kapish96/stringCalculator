package com.example.calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class NumberParserService {
	
	public final String delimiter = ",|\n";
	
	private String[] splintOnDelimiter(String numbers) {
		
		if (customDelimiter(numbers)) {
            return numbers
                    .substring(numbers.indexOf("\n") + 1)
                    .split(extractDelimiter(numbers));
        }
		
		return numbers.split(delimiter);
	}
	
	public List<Integer> fromStringToNumber(String numbers) {
		return Arrays.stream(splintOnDelimiter(numbers))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
	
	private boolean customDelimiter(String numbers) {
        return numbers.startsWith("/");
    }
	
	private String extractDelimiter(String input) {
		
        String escapedInput;
        
        int startIndex = input.indexOf("\n");

        escapedInput = input
                .substring(0, startIndex)
                .replace("//", "")
                .replace("[", "")
                .replace("]", "");
        return "\\Q" + escapedInput + "\\E";
    }

}

package com.example.calculator.service;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public final String delimiter = ",|\n";
	
	private NumberParserService numberParserService;
	
	CalculatorService(NumberParserService numberParserService){
		this.numberParserService = numberParserService;
	}

	public int sum(String input) {
		
		if(input.isEmpty()) {
			return 0;
		} 
		
		return getSum(input);
	}
	
	private int getSum(String numbers) {
		
		int sum = 0;
		List<Integer> numberSplit  = numberParserService.fromStringToNumber(numbers);
		
		for (Integer integer : numberSplit) {
			sum+=integer;
		}
		return sum;
	}
	
	class NegativesNumbersException extends IllegalArgumentException {
        NegativesNumbersException(String message) {
            super(message);
        }
    }
}

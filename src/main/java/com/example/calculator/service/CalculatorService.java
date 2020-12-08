package com.example.calculator.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		checkNegativeNumbers(numberSplit);
		for (Integer integer : numberSplit) {
			if(integer<=1000)
			sum+=integer;
		}
		return sum;
	}
	
	private void checkNegativeNumbers(List<Integer> numbers) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (Integer integer : numbers) {
            if (integer < 0) negativeNumbers.add(integer);
        }
        if (negativeNumbers.size() > 0) throw new NegativesNumbersException("Negative Numbers are not allowed: " +  concatNumbers(negativeNumbers));

    }
	
	private String concatNumbers(List<Integer> negativeNumbers) {
        return negativeNumbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

	class NegativesNumbersException extends IllegalArgumentException {
        NegativesNumbersException(String message) {
            super(message);
        }
    }
}

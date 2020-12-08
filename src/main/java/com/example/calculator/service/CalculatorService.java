package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public final String delimiter = ",|\n";

	public int sum(String input) {
		
		String[] numbers = input.split(delimiter);
		if(input.isEmpty()) {
			return 0;
		} 
		
		if(numbers.length == 1) {
			Integer.parseInt(input); 
		} else {
			return getSum(numbers);
		}
			
		return Integer.parseInt(input);
	}
	
	private int getSum(String[] numbers) {
		
		int sum = 0;
		for(int i=0;i<numbers.length;i++) {
			sum+=Integer.parseInt(numbers[i]); 
		}
		return sum;
	}
}

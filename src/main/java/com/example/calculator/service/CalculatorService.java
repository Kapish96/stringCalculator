package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int sum(String input) {
		
		String[] numbers = input.split(",");
		if(input.isEmpty()) {
			return 0;
		} 
		
		if(numbers.length == 1) {
			Integer.parseInt(input); 
		} else {
			return getSum(numbers[0],numbers[1]);
		}
			
		return Integer.parseInt(input);
	}
	
	private int getSum(String num1, String num2) {
		return Integer.parseInt(num1) + Integer.parseInt(num2);
	}
}

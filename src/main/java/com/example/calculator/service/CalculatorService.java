package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int sum(String input) {
		
		if(input.isEmpty())
			return 0;
		return Integer.parseInt(input);
	}
}

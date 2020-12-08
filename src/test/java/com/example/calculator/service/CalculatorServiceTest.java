package com.example.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorServiceTest {
	
	private CalculatorService calculatorService;
	
	@Before
	public void init() {
		calculatorService = new CalculatorService();
	}

	@Test
	public void emptyStringReturnZero() {
		assertEquals(0, calculatorService.sum(""));
	}
}

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
	
	@Test
	public void singleValueIsRetured() {
		assertEquals(1, calculatorService.sum("1"));
	}
	
	@Test
	public void twoNumbersCommaDelimiterReturnSum() {
		assertEquals(3, calculatorService.sum("1,2"));
	}
	
	@Test
	public void twoNumbersNewLineDelimitedReturnSum() {
		assertEquals(3, calculatorService.sum("1\n2"));
	}
	
	@Test
	public void threeNumbersDelimitedBothWayReturnSum() {
		assertEquals(6, calculatorService.sum("1,2,3"));
	}
}

package com.example.calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.example.calculator.service.CalculatorService.NegativesNumbersException;

public class CalculatorServiceTest {
	
	private CalculatorService calculatorService;
	private NumberParserService numberParserService;
	
	@Before
	public void init() {
		numberParserService = new NumberParserService();
		calculatorService = new CalculatorService(numberParserService);
		
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
		assertEquals(6, calculatorService.sum("1\n2,3"));
	}
	
	@Test
	public void numberWithCustomDelimiterReturnSum() {
		assertEquals(3, calculatorService.sum("//;\n1;2"));
		assertEquals(3,calculatorService.sum("//'\n1'2"));
	}
	
	@Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void negativeNumberNotAllowedThrowsException() {
        exceptionRule.expect(NegativesNumbersException.class);
        exceptionRule.expectMessage("Negative Numbers are not allowed: -1");
        calculatorService.sum("-1");
    }

    @Test
    public void negativeNumberNotAllowedThrowsException_listing_2_negative_numbers() {
        exceptionRule.expect(NegativesNumbersException.class);
        exceptionRule.expectMessage("Negative Numbers are not allowed: -1, -2");
        calculatorService.sum("-1,-2");
    }
    
    @Test
    public void notIgnoringNumbeifLessThanOrEqualTo1000() {
    	assertEquals(1003, calculatorService.sum("3,1000"));
    }
    
    @Test
    public void ignoringNumberIfGreaterThan1000() {
    	assertEquals(3, calculatorService.sum("3,1001"));
    }

}

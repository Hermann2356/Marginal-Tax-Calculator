package com.learning.j10.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.learning.j10.utilities.Utility.in;

public class TestInNumbers {

	@Test
	@DisplayName("Test A")
	public void test1() {
		String[] vowels = {"A","E","I","O","U"};
		
		String letter = "A";
		
		boolean status = in(letter, vowels);
		assertTrue(status);
		
		
	}
	
	@Test
	@DisplayName("Checking for number 10")
	public void test2() {
		Integer[] vowels = {1,2,3,4,5,22,33};
		
		Integer letter = 10;
		
		boolean status = in(letter, vowels);
		assertFalse(status);
		
		
	}
	
	@Test
	@DisplayName("Checking for number 65")
	public void test3() {
		Integer[] vowels = {1,2,3,4,5,22,33};
		
		Integer letter = 65;
		
		boolean status = in(letter, vowels);
		assertFalse(status);
		
		
	}
}

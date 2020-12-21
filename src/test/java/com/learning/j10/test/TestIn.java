package com.learning.j10.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.j10.utilities.Utility;

public class TestIn {
	
	@Test
	@DisplayName("Test X")
	public void test1() {
		Character[] vowels = {'A','E','I','O','U'};
		
		Character letter = 'X';
		
		boolean status = Utility.in(letter, vowels);
		assertFalse(status);
		
		
	}
	
	@Test
	@DisplayName("Test A")
	public void test2() {
		Character[] vowels = {'A','E','I','O','U'};
		
		Character letter = 'A';
		
		boolean status = Utility.in(letter, vowels);
		assertTrue(status);
		
		
	}
	
	@Test
	@DisplayName("Test E")
	public void test3() {
		Character[] vowels = {'A','E','I','O','U'};
		
		Character letter = 'E';
		
		boolean status = Utility.in(letter, vowels);
		assertTrue(status);
		
		
	}

}

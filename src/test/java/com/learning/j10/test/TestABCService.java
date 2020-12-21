package com.learning.j10.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.j10.model.ABC;
import com.learning.j10.services.ABCService;

public class TestABCService {

	@Test
	@DisplayName("Check for displayMode = abc, highlight = abc")
	public void test1() {
		
		ABCService service = new ABCService();
		
		String displayMode = "abc"; // vow, abc, con
		String highlight = "abc";
		
		/*
		 * displayMode = abc, highlight = abc - show everything highlight nothing
		 * displayMode = vow, highlight = abc - show vowels highlight nothing
		 * displayMode = con, highlight = abc = show constants highlight nothing 
		 * 
		 */
		
		ABC[] letter = service.getAlphabet(displayMode, highlight);
		boolean status = letter.length == 26;
		assertTrue(status);
		
		
	}
	
	@Test
	@DisplayName("Check for displayMode = vow, highlight = abc")
	public void test2() {
		
		ABCService service = new ABCService();
		
		String displayMode = "vow"; // vow, abc, con
		String highlight = "abc";
		
		/*
		 * displayMode = abc, highlight = abc - show everything highlight nothing
		 * displayMode = vow, highlight = abc - show vowels highlight nothing
		 * displayMode = con, highlight = abc = show constants highlight nothing 
		 * 
		 */
		
		ABC[] letter = service.getAlphabet(displayMode, highlight);
		boolean status = letter.length == 5;
		assertTrue(status);
		
		
	}
	
	@Test
	@DisplayName("Check for displayMode = con, highlight = abc")
	public void test3() {
		
		ABCService service = new ABCService();
		
		String displayMode = "con"; // vow, abc, con
		String highlight = "abc";
		
		/*
		 * displayMode = abc, highlight = abc - show everything highlight nothing
		 * displayMode = vow, highlight = abc - show vowels highlight nothing
		 * displayMode = con, highlight = abc = show constants highlight nothing 
		 * 
		 */
		
		ABC[] letter = service.getAlphabet(displayMode, highlight);
		boolean status = letter.length == 21;
		assertTrue(status);
		
		
	}
}

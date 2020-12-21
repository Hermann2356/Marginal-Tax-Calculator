package com.learning.j10.services;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import com.learning.j10.model.ABC;
import com.learning.j10.utilities.Utility;

public class ABCService {
	public ABC[] getAlphabet(String displayMode, String highlight) {

		Predicate<ABC> isPlaceHolder = e -> false;
		Predicate<ABC> isABC = e -> true;
		Predicate<ABC> isVowel = e -> Utility.in(e.getUpperCase(), 'A', 'E', 'I', 'O', 'U');
		Predicate<ABC> isConsonant = isVowel.negate();

		if (displayMode.equals("vow")) 
		{
			isPlaceHolder = isVowel;
			
		} 
		else if (displayMode.equals("abc")) 
		{
			isPlaceHolder = isABC;
			
		} 
		else if (displayMode.equals("con")) 
		{
			isPlaceHolder = isConsonant;
			
		}
		
		Function<ABC,ABC> funcHighlight = abc->{
			if(highlight.equals("vow") && isVowel.test(abc)) {
				abc.setHighlight("highlight");
			}
			else if(highlight.equals("con") && isConsonant.test(abc)) {
				abc.setHighlight("highlight");
			}
			
			
			return abc;
		};
		
		ABC[] letters = IntStream.rangeClosed(65, 90)
				.mapToObj(ABC::new)
				.filter(isPlaceHolder)
				.map(funcHighlight)
				.toArray(ABC[]::new);

		return letters;
	}
}

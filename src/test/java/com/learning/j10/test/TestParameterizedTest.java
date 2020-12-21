package com.learning.j10.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Month;
import java.util.EnumSet;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

//import org.junit.jupiter.params.provider.EmptySource;
//import org.junit.jupiter.params.provider.NullAndEmptySource;
//import org.junit.jupiter.params.provider.NullSource;
//import org.junit.jupiter.params.provider.ValueSource;

public class TestParameterizedTest {
	/*
	 * With the @ValueSource annotation, we can pass an array of literal values to
	 * the test method.
	 * 
	 * short (with the shorts attribute) byte (with the bytes attribute) int (with
	 * the ints attribute) long (with the longs attribute) float (with the floats
	 * attribute) double (with the doubles attribute) char (with the chars
	 * attribute) java.lang.String (with the strings attribute) java.lang.Class
	 * (with the classes attribute)
	 */

	/*
	 * JUnit 5 test runner executes this above test – and consequently, the isOdd
	 * method – six times. And each time, it assigns a different value from
	 * the @ValueSource array to the number method parameter.
	 */
	@ParameterizedTest
	@ValueSource(ints = { 1, 3, 5, -3, 15, Integer.MAX_VALUE }) // six numbers
	@DisplayName("Simple Values (1)")
	void isOdd_ShouldReturnTrueForOddNumbers(int number) {
		assertTrue(Numbers.isOdd(number));
	}

	@ParameterizedTest
	@ValueSource(strings = { "", "  " })
	@DisplayName("Simple Values (2)")
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
		assertTrue(Strings.isBlank(input));
	}

	/*
	 * We can't pass null through a @ValueSource, even for String and Class!
	 * 
	 * As of JUnit 5.4, we can pass a single null value to a parameterized test
	 * method using @NullSource:
	 */
	@ParameterizedTest
	@NullSource
	@DisplayName("Null and Empty Values (1)")
	void isBlank_ShouldReturnTrueForNullInputs(String input) {
		assertTrue(Strings.isBlank(input));
	}

	/*
	 * Since primitive data types can't accept null values, we can't use
	 * the @NullSource for primitive arguments.
	 * 
	 * Quite similarly, we can pass empty values using the @EmptySource annotation:
	 */
	@ParameterizedTest
	@EmptySource
	@DisplayName("Null and Empty Values (2)")
	void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
		assertTrue(Strings.isBlank(input));
	}

	/*
	 * For String arguments, the passed value would be as simple as an empty String.
	 * Moreover, this parameter source can provide empty values for Collection types
	 * and arrays.
	 * 
	 * In order to pass both null and empty values, we can use the
	 * composed @NullAndEmptySource annotation:
	 */
	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("Null and Empty Values (3)")
	void isBlank_ShouldReturnTrueForNullAndEmptyStrings(String input) {
		assertTrue(Strings.isBlank(input));
	}

	/*
	 * As with the @EmptySource, the composed annotation works for Strings,
	 * Collections, and arrays.
	 * 
	 * In order to pass a few more empty string variations to the parameterized
	 * test, we can combine @ValueSource, @NullSource, and @EmptySource together:
	 */
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "  ", "\t", "\n" })
	@DisplayName("Null and Empty Values (4)")
	void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input) {
		assertTrue(Strings.isBlank(input));
	}

	/*
	 * n order to run a test with different values from an enumeration, we can use
	 * the @EnumSource annotation.
	 * 
	 * For example, we can assert that all month numbers are between 1 and 12:
	 */
	@ParameterizedTest
	@EnumSource(Month.class) // passing all 12 months
	@DisplayName("(Enum) Test all month numbers are between 1 and 12:")
	void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
		int monthNumber = month.getValue();
		assertTrue(monthNumber >= 1 && monthNumber <= 12);
	}

	/*
	 * Or, we can filter out a few months by using the names attribute.
	 * 
	 * How about asserting the fact that April, September, June, and November are 30
	 * days long:
	 */
	@ParameterizedTest
	@EnumSource(value = Month.class, names = { "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" })
	@DisplayName("(Enum) Test filter out a few months by using the names attribute")
	void someMonths_Are30DaysLong(Month month) {
		final boolean isALeapYear = false;
		assertEquals(30, month.length(isALeapYear));
	}

	/*
	 * By default, the names will only keep the matched enum values. We can turn
	 * this around by setting the mode attribute to EXCLUDE:
	 */
	@ParameterizedTest
	@EnumSource(value = Month.class, names = { "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER",
			"FEBRUARY" }, mode = EnumSource.Mode.EXCLUDE)
	@DisplayName("(Enum) Test the mode attribute to EXCLUDES")
	void exceptFourMonths_OthersAre31DaysLong(Month month) {
		final boolean isALeapYear = false;
		assertEquals(31, month.length(isALeapYear));
	}

	/*
	 * In addition to literal strings, we can pass a regular expression to the names
	 * attribute:
	 */
	@ParameterizedTest
	@EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
	@DisplayName("(Enum) Test regular expression to the names attribute")
	void fourMonths_AreEndingWithBer(Month month) {
		EnumSet<Month> months = EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
		assertTrue(months.contains(month));
	}

	/*
	 * Suppose we're going to make sure that the toUpperCase() method from String
	 * generates the expected uppercase value. @ValueSource won't be enough.
	 * 
	 * In order to write a parameterized test for such scenarios, we have to:
	 * 
	 * Pass an input value and an expected value to the test method Compute the
	 * actual result with those input values Assert the actual value with the
	 * expected value So, we need argument sources capable of passing multiple
	 * arguments. The @CsvSource is one of those sources:
	 */
	@ParameterizedTest
	@CsvSource({ "test,TEST", "tEst,TEST", "Java,JAVA" })
	@DisplayName("CSV Literals (1)")
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
		String actualValue = input.toUpperCase();
		assertEquals(expected, actualValue);
	}

	/*
	 * The @CsvSource accepts an array of comma-separated values and each array
	 * entry corresponds to a line in a CSV file.
	 * 
	 * This source takes one array entry each time, splits it by comma and passes
	 * each array to the annotated test method as separate parameters. By default,
	 * the comma is the column separator but we can customize it using the delimiter
	 * attribute:
	 */
	@ParameterizedTest
	@CsvSource(value = { "test:test", "tEst:test", "Java:java" }, delimiter = ':')
	@DisplayName("CSV Literals (2)")
	void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
		String actualValue = input.toLowerCase();
		assertEquals(expected, actualValue);
	}

	/*
	 * Instead of passing the CSV values inside the code, we can refer to an actual
	 * CSV file.
	 * 
	 * For example, we could use a CSV file like:
	 * 
	 * We can load the CSV file and ignore the header column with @CsvFileSource:
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	@DisplayName("CSV File")
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(String input, String expected) {
		String actualValue = input.toUpperCase();
		assertEquals(expected, actualValue);
	}

	/*
	 * The argument sources we've covered so far are somewhat simple and share one
	 * limitation: It's hard or impossible to pass complex objects using them!
	 * 
	 * One approach to providing more complex arguments is to use a method as an
	 * argument source.
	 * 
	 * Let's test the isBlank method with a @MethodSource:
	 */
	@ParameterizedTest
	@MethodSource("provideStringsForIsBlank")
	@DisplayName("MethodSource")
	void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
		assertEquals(expected, Strings.isBlank(input));
	}

	/*
	 * The name we supply to @MethodSource needs to match an existing method.
	 * 
	 * So let's next write provideStringsForIsBlank, a static method that returns a
	 * Stream of Arguments:
	 */
	
	
	public static Stream<Arguments> provideStringsForIsBlank() {
	    return Stream.of(
	      Arguments.of(null, true),
	      Arguments.of("", true),
	      Arguments.of("  ", true),
	      Arguments.of("not blank", false)
	    );
	}
	
}

class Numbers {
	public static boolean isOdd(int number) {
		return number % 2 != 0;
	}
}

class Strings {
	public static boolean isBlank(String input) {
		return input == null || input.trim().isEmpty();
	}
}


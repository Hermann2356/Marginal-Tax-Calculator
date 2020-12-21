package com.learning.j10.test;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class TestLoop {
	
	public static boolean isEven(Integer n) {
		return n % 2 == 0;
	}
	
	public static void booboo(int n) {
		System.out.println(n * 2);
	}

	@Test
	public void test1() {
		IntConsumer x = TestLoop::booboo;
		IntConsumer y = System.out::println;
		
		IntStream.rangeClosed(1, 30)
			.filter(TestLoop::isEven)
			.forEach(x);
	}
}

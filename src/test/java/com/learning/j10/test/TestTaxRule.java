package com.learning.j10.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.learning.j10.services.TaxService;
import com.jbbwebsolutions.service.IService;

public class TestTaxRule {
	
	
	
	@Test
	@DisplayName("Testing tax paid for Single Person make 9k")
	public void test1() {
		IService<Float, Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","MFJ"); // Represents a single person
		map.put("salary",9_000f);
		
		float taxPaid = service.calculate(map);
		assertEquals(900f,taxPaid);
	}
	
	
	@Test
	@DisplayName("TestLookUp, Search for all Rules")
	public void test2() {
		IService<Float, Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","S"); // Represents a single person
		map.put("salary",9_875f);
		map.put("year", 2020);
		
		float taxPaid = service.calculate(map);
		assertEquals(987.5,taxPaid);
	}
//	
//	@Test
//	@DisplayName("Testing tax paid for Single Person make 9,875k")
//	public void test3() {
//		TaxRuleLookUpService service = new TaxRuleLookUpService();
//		Map<String, Object> search = new HashMap<>();
//		search.put("status","S");
//		search.put("year", 2020);
//		List<TaxRule> list = service.search(search);
//		int count = list.size();
//		
//		//list.forEach(System.out::println);
//		assertTrue(count > 5);
//		
//	}
//	
	@Test
	@DisplayName("Testing tax paid for Single Person make 30,250k")
	public void test4() {
		IService<Float,Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","S"); // Represents a single person
		map.put("salary",30_250f);
		
		float taxPaid = service.calculate(map);
		assertEquals(3_432.5f,taxPaid);
	}
	
	@Test
	@DisplayName("Testing tax paid for Single Person make 150,000k")
	public void test5() {
		IService<Float, Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","S"); // Represents a single person
		map.put("salary",150_000f);
		
		float taxPaid = service.calculate(map);
		assertEquals(30_079.5f,taxPaid);
	}

	@Test
	@DisplayName("Testing tax paid for Single Person make 45,400k")
	public void test6() {
		IService<Float,Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","S"); // Represents a single person
		map.put("salary",45_400f);
		
		float taxPaid = service.calculate(map);
		assertEquals(5_778f,taxPaid);
	}
	
	@Test
	@DisplayName("Testing tax paid for Single Person make 77,775k")
	public void test7() {
		IService<Float,Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","S"); // Represents a single person
		map.put("salary",77_775f);
		
		float taxPaid = service.calculate(map);
		assertEquals(12_900.5f,taxPaid);
	}

	@Test
	@DisplayName("Testing tax paid for Single Person make 44,050k")
	public void test9() {
		IService<Float,Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","S"); // Represents a single person
		map.put("salary",44_050f);
		
		float taxPaid = service.calculate(map);
		assertEquals(5_481f,taxPaid);
	}
	
	@Test
	@DisplayName("Testing tax paid for Single Person make 311,050k")
	public void test8() {
		IService<Float,Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","S"); // Represents a single person
		map.put("salary",311_050f);
		
		float taxPaid = service.calculate(map);
		assertEquals(83_662.5f,taxPaid);
	}
	
	@Test
	@DisplayName("Testing tax paid for Single Person make 999,481,599k")
	public void test10() {
		IService<Float,Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","S"); // Represents a single person
		map.put("salary",999_481_599f);
		
		float taxPaid = service.calculate(map);
		assertEquals(369_772_619f,taxPaid);
	}
	
	@Test
	@DisplayName("Testing tax paid for Married Person Filing Jointly make 19,750k")
	public void test11() {
		IService<Float,Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
		
		map.put("status","MFJ"); // Represents a Married person Filing Jointly person
		map.put("salary",19_750f);
		
		float taxPaid = service.calculate(map);
	    assertEquals(1_975f,taxPaid);
	}
	
	@Test
	@DisplayName("Testing empty HashMap<>()")
	public void test12() {
		IService<Float,Float> service = new TaxService();
		Map<String,Object> map = new HashMap<>();
				
		float taxPaid = service.calculate(map);
		//assertEquals(1_975f,taxPaid);
		assertEquals(30_079.5f,taxPaid);
	}
//	
//	@Test
//	@DisplayName("Testing tax paid for Married Person Filing Jointly make 60,500k")
//	public void test11() {
//		IService<Float,Float> service = new TaxService();
//		Map<String,Object> map = new HashMap<>();
//		
//		map.put("status","MFJ"); // Represents a Married person Filing Jointly
//		map.put("salary",60_500f);
//		
//		float taxPaid = service.calculate(map);
//		assertEquals(7_260,taxPaid);
//	}
//	
//	@Test
//	@DisplayName("Testing tax paid for Married Person Filing Jointly make 90,800k")
//	public void test12() {
//		IService<Float,Float> service = new TaxService();
//		Map<String,Object> map = new HashMap<>();
//		
//		map.put("status","MFJ"); // Represents a Married person Filing Jointly
//		map.put("salary",90_800f);
//		
//		float taxPaid = service.calculate(map);
//		assertEquals(19_976,taxPaid);
//	}
//	
//	@Test
//	@DisplayName("Testing tax paid for Married Person Filing Jointly make 155,550k")
//	public void test13() {
//		IService<Float,Float> service = new TaxService();
//		Map<String,Object> map = new HashMap<>();
//		
//		map.put("status","MFJ"); // Represents a Married person Filing Jointly
//		map.put("salary",155_550f);
//		
//		float taxPaid = service.calculate(map);
//		assertEquals(37_332,taxPaid);
//	}
//	
//	
//	@Test
//	@DisplayName("Testing tax paid for Married Person Filing Jointly make 88,100k")
//	public void test14() {
//		IService<Float,Float> service = new TaxService();
//		Map<String,Object> map = new HashMap<>();
//		
//		map.put("status","MFJ"); // Represents a Married person Filing Jointly
//		map.put("salary",88_100f);
//		
//		float taxPaid = service.calculate(map);
//		assertEquals(28_192,taxPaid);
//	}

}

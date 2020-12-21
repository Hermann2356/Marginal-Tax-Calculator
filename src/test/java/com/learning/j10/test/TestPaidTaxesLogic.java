package com.learning.j10.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.learning.j10.dao.TaxRuleCSVDAO;
import com.learning.j10.dao.TaxRuleSQLDAO;
import com.learning.j10.services.TaxService;
 

public class TestPaidTaxesLogic {

	
	@DisplayName("TaxService Test")
	@CsvSource({"2020, S, 1000f, 100f",
				"2020, S, 8000f, 800f",
				"2020, S, 9000f, 900f"})
	@ParameterizedTest
	public void test1(int year, String status, float salary, float taxOwed) {
		

		Map<String, Object> search = new HashMap<String, Object>();
		search.put("status", status);
		search.put("salary", salary);
		search.put("year", year);
		
		TaxService service = new TaxService(new TaxRuleCSVDAO());
		float taxPaid = service.calculate(search);
		
		
		assertEquals(taxPaid,taxOwed);
	}


}

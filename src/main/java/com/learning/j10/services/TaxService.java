package com.learning.j10.services;

import java.util.Map;
import java.util.function.Function;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.service.IService;
import com.learning.j10.dao.TaxRuleSQLDAO;
import com.learning.j10.model.TaxRule;
import com.learning.j10.utilities.Utility;

public class TaxService implements IService<Float, Float> {

//	private static final Predicate<TaxRule> pSingle = e -> e.getStatus().equals("S");
//	private static final Predicate<TaxRule> pHeadOfHouseHold = e -> e.getStatus().equals("HH");
//	private static final Predicate<TaxRule> pMarriedFilingJointly = e -> e.getStatus().equals("MFJ");
//	private static final Predicate<TaxRule> pMarriedFilingSingle = e -> e.getStatus().equals("MFS");
//
//	private static final Map<String, Predicate<TaxRule>> mapRules = new HashMap<>();
//
//	static {
//		mapRules.put("S", pSingle);
//		mapRules.put("HH", pHeadOfHouseHold);
//		mapRules.put("MFJ", pMarriedFilingJointly);
//		mapRules.put("MFJ", pMarriedFilingSingle);
//	}

	private IQuery<TaxRule> dao;

	public TaxService(IQuery<TaxRule> dao) {
		this.dao = dao;
	}
	
	public TaxService() {
		this.dao = new TaxRuleSQLDAO();
	}

	@Override
	public Float calculate(Map<String, Object> search) {

		/*
		 * if (search.isEmpty()) return 0f;
		 * 
		 * String status = (String) search.get("status"); float salary = (float)
		 * search.get("salary"); float taxPaid = 0f; int year = 2020;
		 * 
		 * Predicate<TaxRule> pInput = mapRules.get(status); pInput = pInput.and(e ->
		 * e.getYear() == year);
		 * 
		 * IQuery<TaxRule> doa = new TaxRuleCSVDAO(); List<TaxRule> taxRules =
		 * doa.findBy(pInput);
		 * 
		 * // Filter and retrieve Tax Rules pertaining to the appropriate Tax Bracket
		 * taxRules = taxRules.stream() .filter(taxRule -> taxRule.getYear() == 2020)
		 * .filter(taxRule -> salary >= taxRule.getRange1())
		 * .collect(Collectors.toList());
		 * 
		 * for (int i = 0; i < taxRules.size(); i++) {
		 * 
		 * TaxRule taxRule = taxRules.get(i); taxPaid += taxRules.size() == 1 ? salary *
		 * taxRule.getRate(): i == taxRules.size() - 1 ? (salary - taxRule.getRange1())
		 * * taxRule.getRate(): taxRule.getTaxableAmount() * taxRule.getRate(); }
		 * 
		 * return taxPaid;
		 */
		// Dependency Injection
		TaxRuleLookUpService service = new TaxRuleLookUpService(this.dao);

		float salary = Utility.ifNull(search::get, "salary", 150_000f);

		Function<TaxRule, TaxRule> mapper = e -> {
			boolean status = e.getRange1() <= salary;
			boolean isLastRow = salary >= e.getRange1() && salary <= e.getRange2();
			if (isLastRow) {
				float taxPaid = (salary - e.getRange1()) * e.getRate();
				e.setTaxPaid(taxPaid);
			} else if (!status) {
				e.setTaxPaid(0);
			}

			return e;
		};

		float taxPaid = (float) service.search(search)
				.stream()
				.map(mapper)
				//.peek(System.out::println)
				.mapToDouble(TaxRule::getTaxPaid).sum();

		return taxPaid;
	}

}

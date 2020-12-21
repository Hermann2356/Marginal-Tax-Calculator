package com.learning.j10.model;

import java.util.ArrayList;
import java.util.List;

public class AllTaxRules {
	private int year;
	private float taxPaid;
	private List<TaxRule> taxRules = new ArrayList<>();

	public AllTaxRules(int year, List<TaxRule> taxRules) {
		this.year = year;
		this.taxRules = taxRules;
	}
	

	public AllTaxRules(int year, float taxPaid, List<TaxRule> taxRules) {
		super();
		this.year = year;
		this.taxPaid = taxPaid;
		this.taxRules = taxRules;
	}


	public float getTaxPaid() {
		return taxPaid;
	}


	public void setTaxPaid(float taxPaid) {
		this.taxPaid = taxPaid;
	}


	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<TaxRule> getTaxRules() {
		return taxRules;
	}

	public void setTaxRules(List<TaxRule> taxRules) {
		this.taxRules = taxRules;
	}

	@Override
	public String toString() {
		return "AllTaxRules [year=" + year + ", taxRules=" + taxRules + "]";
	}

}

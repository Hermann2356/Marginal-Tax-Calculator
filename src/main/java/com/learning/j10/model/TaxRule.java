package com.learning.j10.model;

public class TaxRule {
	private int ruleNo;
	private int year;
	private float rate;
	private String status;
	private float range1;
	private float range2;
	private float taxableAmount;
	private float taxPaid;
	private String marker = "N/A";

	public TaxRule() {
	}

	public TaxRule(int ruleNo, int year, float rate, String status, float range1, float range2, float taxableAmount,
			float taxPaid) {
		this.ruleNo = ruleNo;
		this.year = year;
		this.rate = rate;
		this.status = status;
		this.range1 = range1;
		this.range2 = range2;
		this.taxableAmount = taxableAmount;
		this.taxPaid = taxPaid;
	}

	public int getRuleNo() {
		return ruleNo;
	}

	public void setRuleNo(int ruleNo) {
		this.ruleNo = ruleNo;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getRange1() {
		return range1;
	}

	public void setRange1(float range1) {
		this.range1 = range1;
	}

	public float getRange2() {
		return range2;
	}

	public void setRange2(float range2) {
		this.range2 = range2;
	}

	public float getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(float taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public float getTaxPaid() {
		return taxPaid;
	}

	public void setTaxPaid(float taxPaid) {
		this.taxPaid = taxPaid;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

	@Override
	public String toString() {
		return "TaxRule [ruleNo=" + ruleNo + ", year=" + year + ", rate=" + rate + ", status=" + status + ", range1="
				+ range1 + ", range2=" + range2 + ", taxableAmount=" + taxableAmount + ", taxPaid=" + taxPaid
				+ ", marker=" + marker + "]";
	}

}

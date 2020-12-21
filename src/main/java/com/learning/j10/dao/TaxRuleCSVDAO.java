package com.learning.j10.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jbbwebsolutions.dao.IQuery;
import static com.jbbwebsolutions.utility.CSVFileUtility.process;
import com.jbbwebsolutions.utility.FieldMetaData;
import com.learning.j10.model.TaxRule;

public class TaxRuleCSVDAO implements IQuery<TaxRule>{

	@Override
	public List<TaxRule> findAll() {
		
		List<FieldMetaData> metadatalist = new ArrayList<>();
		metadatalist.add(new FieldMetaData("ruleNo" , 0, Integer.class));
		metadatalist.add(new FieldMetaData("year" , 1, Integer.class));
		metadatalist.add(new FieldMetaData("rate" , 2, Float.class));
		metadatalist.add(new FieldMetaData("status" , 3, String.class));
		metadatalist.add(new FieldMetaData("range1" , 4, Float.class));
		metadatalist.add(new FieldMetaData("range2" , 5, Float.class));
		metadatalist.add(new FieldMetaData("taxableAmount" , 6, Float.class));
		metadatalist.add(new FieldMetaData("taxPaid" , 7, Float.class));


		String fileName = "/data/2019-2020TaxRules.csv";
		List<TaxRule> taxRule = process(TaxRule::new, metadatalist, fileName)
				.stream()
				.collect(Collectors.toList());
		
		return taxRule;
	}

}

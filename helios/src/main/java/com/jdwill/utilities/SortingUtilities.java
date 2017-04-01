package com.jdwill.utilities;

import java.time.YearMonth;
import java.util.LinkedHashMap;
import java.util.Map;

import com.jdwill.models.IncomeAndExpenseStrings;
import com.jdwill.models.IncomeAndExpenseSummary;
import com.jdwill.models.IncomesAndExpensesByMonth;

public class SortingUtilities {

	public static Map<YearMonth, IncomeAndExpenseStrings> sortIncomesAndExpensesMap(Map<YearMonth, IncomeAndExpenseStrings> incomesAndExpenses) {
		Map<YearMonth, IncomeAndExpenseStrings> sortedIncomesAndExpenses = new LinkedHashMap<YearMonth, IncomeAndExpenseStrings>();
		incomesAndExpenses.entrySet().stream()
        .sorted(Map.Entry.<YearMonth, IncomeAndExpenseStrings>comparingByKey())
        .forEachOrdered(x -> sortedIncomesAndExpenses.put(x.getKey(), x.getValue()));
		return sortedIncomesAndExpenses;
	}
}
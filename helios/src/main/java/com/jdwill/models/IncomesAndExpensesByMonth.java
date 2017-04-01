package com.jdwill.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class IncomesAndExpensesByMonth {
	private Map<String, IncomeAndExpenseStrings> monthlyIncomesAndExpenses;

	@JsonAnyGetter
	public Map<String, IncomeAndExpenseStrings> getIncomesAndExpensesByMonth() {
		return monthlyIncomesAndExpenses;
	}
	public void setIncomesAndExpensesByMonth(Map<String, IncomeAndExpenseStrings> incomesAndExpensesByMonth) {
		this.monthlyIncomesAndExpenses = incomesAndExpensesByMonth;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((monthlyIncomesAndExpenses == null) ? 0 : monthlyIncomesAndExpenses.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncomesAndExpensesByMonth other = (IncomesAndExpensesByMonth) obj;
		if (monthlyIncomesAndExpenses == null) {
			if (other.monthlyIncomesAndExpenses != null)
				return false;
		} else if (!monthlyIncomesAndExpenses.equals(other.monthlyIncomesAndExpenses))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IncomesAndExpensesByMonth [monthlyIncomesAndExpenses=" + monthlyIncomesAndExpenses + "]";
	}
}
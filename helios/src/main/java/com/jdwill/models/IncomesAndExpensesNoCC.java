package com.jdwill.models;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomesAndExpensesNoCC {
	private Map<String, IncomeAndExpenseStrings> monthlyIncomesAndExpenses;
	@JsonProperty("excluded-credit-card-payments")
	private List<MinimumTransactionData> excluded_credit_card_payments;
	
	@JsonAnyGetter
	public Map<String, IncomeAndExpenseStrings> getMonthlyIncomesAndExpenses() {
		return monthlyIncomesAndExpenses;
	}
	public void setMonthlyIncomesAndExpenses(Map<String, IncomeAndExpenseStrings> monthlyIncomesAndExpenses) {
		this.monthlyIncomesAndExpenses = monthlyIncomesAndExpenses;
	}
	public List<MinimumTransactionData> getExcluded_credit_card_payments() {
		return excluded_credit_card_payments;
	}
	public void setExcluded_credit_card_payments(List<MinimumTransactionData> excluded_credit_card_payments) {
		this.excluded_credit_card_payments = excluded_credit_card_payments;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((excluded_credit_card_payments == null) ? 0 : excluded_credit_card_payments.hashCode());
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
		IncomesAndExpensesNoCC other = (IncomesAndExpensesNoCC) obj;
		if (excluded_credit_card_payments == null) {
			if (other.excluded_credit_card_payments != null)
				return false;
		} else if (!excluded_credit_card_payments.equals(other.excluded_credit_card_payments))
			return false;
		if (monthlyIncomesAndExpenses == null) {
			if (other.monthlyIncomesAndExpenses != null)
				return false;
		} else if (!monthlyIncomesAndExpenses.equals(other.monthlyIncomesAndExpenses))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IncomesAndExpensesNoCC [monthlyIncomesAndExpenses=" + monthlyIncomesAndExpenses
				+ ", excluded_credit_card_payments=" + excluded_credit_card_payments + "]";
	}
}
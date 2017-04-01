package com.jdwill.models;

import java.math.BigDecimal;

public class IncomeAndExpenseSummary {
	private BigDecimal spent;
	private BigDecimal income;
	
	public IncomeAndExpenseSummary() {
	}
	public IncomeAndExpenseSummary(BigDecimal spent, BigDecimal income) {
		this.spent = spent;
		this.income = income;
	}
	
	public BigDecimal getSpent() {
		return spent;
	}
	public void setSpent(BigDecimal spent) {
		this.spent = spent;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((income == null) ? 0 : income.hashCode());
		result = prime * result + ((spent == null) ? 0 : spent.hashCode());
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
		IncomeAndExpenseSummary other = (IncomeAndExpenseSummary) obj;
		if (income == null) {
			if (other.income != null)
				return false;
		} else if (!income.equals(other.income))
			return false;
		if (spent == null) {
			if (other.spent != null)
				return false;
		} else if (!spent.equals(other.spent))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "IncomeAndExpenseSummary [spent=" + spent + ", income=" + income + "]";
	}
}
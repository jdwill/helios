package com.jdwill.models;

public class IncomeAndExpenseStrings {

	private String spent;
	private String income;
	
	public IncomeAndExpenseStrings() {
	}
	public IncomeAndExpenseStrings(String spent, String income) {
		this.spent = spent;
		this.income = income;
	}
	
	public String getSpent() {
		return spent;
	}
	public void setSpent(String spent) {
		this.spent = spent;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
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
		IncomeAndExpenseStrings other = (IncomeAndExpenseStrings) obj;
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
		return "IncomeAndExpenseStrings [spent=" + spent + ", income=" + income + "]";
	}
}

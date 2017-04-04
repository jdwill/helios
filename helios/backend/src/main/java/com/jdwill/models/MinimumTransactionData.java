package com.jdwill.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MinimumTransactionData {
	@JsonProperty("transaction-id")
	private String transaction_id;
	private String merchant;
	@JsonProperty("transaction-time")
	private String transaction_time;
	private Double amount;
	private String categorization;
	
	public MinimumTransactionData() {
	}
	public MinimumTransactionData(String transaction_id, String merchant, 
			String transaction_time, Double amount, String categorization) {
		this.transaction_id = transaction_id;
		this.merchant = merchant;
		this.transaction_time = transaction_time;
		this.amount = amount;
		this.categorization = categorization;
	}
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getTransaction_time() {
		return transaction_time;
	}
	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCategorization() {
		return categorization;
	}
	public void setCategorization(String categorization) {
		this.categorization = categorization;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((categorization == null) ? 0 : categorization.hashCode());
		result = prime * result + ((merchant == null) ? 0 : merchant.hashCode());
		result = prime * result + ((transaction_id == null) ? 0 : transaction_id.hashCode());
		result = prime * result + ((transaction_time == null) ? 0 : transaction_time.hashCode());
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
		MinimumTransactionData other = (MinimumTransactionData) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (categorization == null) {
			if (other.categorization != null)
				return false;
		} else if (!categorization.equals(other.categorization))
			return false;
		if (merchant == null) {
			if (other.merchant != null)
				return false;
		} else if (!merchant.equals(other.merchant))
			return false;
		if (transaction_id == null) {
			if (other.transaction_id != null)
				return false;
		} else if (!transaction_id.equals(other.transaction_id))
			return false;
		if (transaction_time == null) {
			if (other.transaction_time != null)
				return false;
		} else if (!transaction_time.equals(other.transaction_time))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MinimumTransactionData [transaction_id=" + transaction_id + ", merchant=" + merchant
				+ ", transaction_time=" + transaction_time + ", amount=" + amount + ", categorization=" + categorization
				+ "]";
	}
}
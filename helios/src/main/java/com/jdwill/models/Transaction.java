package com.jdwill.models;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * A model of a user's individual transaction.
 * @author Jason Williams
 *
 */
public class Transaction {
	@JsonProperty("transaction-id")
	private String transaction_id;
	@JsonProperty("account-id")
	private String account_id;
	@JsonProperty("raw-merchant")
	private String raw_merchant;
	private String merchant;
	@JsonProperty("is-pending")
	private String is_pending;
	@JsonProperty("transaction-time")
	private String transaction_time;
	private Double amount;
	@JsonProperty("previous-transaction-id")
	private String previous_transaction_id;
	private String categorization;
	//WARNING: Only for testing
	@JsonProperty("memo-only-for-testing")
	private String memo_only_for_testing;
	//WARNING: Only for testing
	@JsonProperty("payee-name-only-for-testing")
	private String payee_name_only_for_testing;
	@JsonProperty("clear-date")
	private Double clear_date;
	
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getRaw_merchant() {
		return raw_merchant;
	}
	public void setRaw_merchant(String raw_merchant) {
		this.raw_merchant = raw_merchant;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getIs_pending() {
		return is_pending;
	}
	public void setIs_pending(String is_pending) {
		this.is_pending = is_pending;
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
	public String getPrevious_transaction_id() {
		return previous_transaction_id;
	}
	public void setPrevious_transaction_id(String previous_transaction_id) {
		this.previous_transaction_id = previous_transaction_id;
	}
	public String getCategorization() {
		return categorization;
	}
	public void setCategorization(String categorization) {
		this.categorization = categorization;
	}
	public String getMemo_only_for_testing() {
		return memo_only_for_testing;
	}
	public void setMemo_only_for_testing(String memo_only_for_testing) {
		this.memo_only_for_testing = memo_only_for_testing;
	}
	public String getPayee_name_only_for_testing() {
		return payee_name_only_for_testing;
	}
	public void setPayee_name_only_for_testing(String payee_name_only_for_testing) {
		this.payee_name_only_for_testing = payee_name_only_for_testing;
	}
	public Double getClear_date() {
		return clear_date;
	}
	public void setClear_date(Double clear_date) {
		this.clear_date = clear_date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_id == null) ? 0 : account_id.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((categorization == null) ? 0 : categorization.hashCode());
		result = prime * result + ((clear_date == null) ? 0 : clear_date.hashCode());
		result = prime * result + ((is_pending == null) ? 0 : is_pending.hashCode());
		result = prime * result + ((memo_only_for_testing == null) ? 0 : memo_only_for_testing.hashCode());
		result = prime * result + ((merchant == null) ? 0 : merchant.hashCode());
		result = prime * result + ((payee_name_only_for_testing == null) ? 0 : payee_name_only_for_testing.hashCode());
		result = prime * result + ((previous_transaction_id == null) ? 0 : previous_transaction_id.hashCode());
		result = prime * result + ((raw_merchant == null) ? 0 : raw_merchant.hashCode());
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
		Transaction other = (Transaction) obj;
		if (account_id == null) {
			if (other.account_id != null)
				return false;
		} else if (!account_id.equals(other.account_id))
			return false;
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
		if (clear_date == null) {
			if (other.clear_date != null)
				return false;
		} else if (!clear_date.equals(other.clear_date))
			return false;
		if (is_pending == null) {
			if (other.is_pending != null)
				return false;
		} else if (!is_pending.equals(other.is_pending))
			return false;
		if (memo_only_for_testing == null) {
			if (other.memo_only_for_testing != null)
				return false;
		} else if (!memo_only_for_testing.equals(other.memo_only_for_testing))
			return false;
		if (merchant == null) {
			if (other.merchant != null)
				return false;
		} else if (!merchant.equals(other.merchant))
			return false;
		if (payee_name_only_for_testing == null) {
			if (other.payee_name_only_for_testing != null)
				return false;
		} else if (!payee_name_only_for_testing.equals(other.payee_name_only_for_testing))
			return false;
		if (previous_transaction_id == null) {
			if (other.previous_transaction_id != null)
				return false;
		} else if (!previous_transaction_id.equals(other.previous_transaction_id))
			return false;
		if (raw_merchant == null) {
			if (other.raw_merchant != null)
				return false;
		} else if (!raw_merchant.equals(other.raw_merchant))
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
		return "Transaction [transaction_id=" + transaction_id + ", account_id=" + account_id + ", raw_merchant="
				+ raw_merchant + ", merchant=" + merchant + ", is_pending=" + is_pending + ", transaction_time="
				+ transaction_time + ", amount=" + amount + ", previous_transaction_id=" + previous_transaction_id
				+ ", categorization=" + categorization + ", memo_only_for_testing=" + memo_only_for_testing
				+ ", payee_name_only_for_testing=" + payee_name_only_for_testing + ", clear_date=" + clear_date + "]";
	}
}
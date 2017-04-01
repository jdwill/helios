package com.jdwill.models;

public class CrystalBallArguments {

	private CommonArguments args;
	private Double year;
	private Double month;
	
	public CrystalBallArguments() {
		args = new CommonArguments();
	}
	public CrystalBallArguments(Double year, Double month) {
		this();
		this.year = year;
		this.month = month;
	}
	
	public CommonArguments getArgs() {
		return args;
	}
	public void setArgs(CommonArguments args) {
		this.args = args;
	}
	public Double getYear() {
		return year;
	}
	public void setYear(Double year) {
		this.year = year;
	}
	public Double getMonth() {
		return month;
	}
	public void setMonth(Double month) {
		this.month = month;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((args == null) ? 0 : args.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		CrystalBallArguments other = (CrystalBallArguments) obj;
		if (args == null) {
			if (other.args != null)
				return false;
		} else if (!args.equals(other.args))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CrystalBallArguments [args=" + args + ", year=" + year + ", month=" + month + "]";
	}
}
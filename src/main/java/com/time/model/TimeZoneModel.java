package com.time.model;

public class TimeZoneModel {
	private String abbreviation;
	private String timezone;
	private String datetime;

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	@Override
	public String toString() {
		return "TimeZoneModel [abbreviation=" + abbreviation + ", timezone=" + timezone + ", datetime=" + datetime
				+ "]";
	}

}
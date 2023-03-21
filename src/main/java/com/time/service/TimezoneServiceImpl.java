package com.time.service;

import java.time.ZoneId;
import java.time.zone.ZoneRulesException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.time.model.TimeZoneModel;

@Service
public class TimezoneServiceImpl implements ITimezoneService {

	private final String WORLD_TIME_API_URL = "http://worldtimeapi.org/api/timezone/%s";

	@Override
	public TimeZoneModel getTimeZoneDetails(String timezone) {
		if (!isValidTimezone(timezone)) {
			throw new IllegalArgumentException("Invalid timezone: " + timezone);
		}
		return getTimeZoneData(timezone);
	}

	private TimeZoneModel getTimeZoneData(String timezone) {
		String url = String.format(WORLD_TIME_API_URL, timezone);
		RestTemplate restTemplate = new RestTemplate();
		TimeZoneModel response = restTemplate.getForObject(url, TimeZoneModel.class);
		return response;
	}

	private boolean isValidTimezone(String timezone) {
		List<String> usTimezones = Arrays.asList("America/New_York", "America/Chicago", "America/Denver",
				"America/Los_Angeles");
		if (!usTimezones.contains(timezone)) {
			return false;
		}
		try {
			ZoneId.of(timezone);
		} catch (ZoneRulesException e) {
			return false;
		}
		return true;
	}
}
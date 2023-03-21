package com.time.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.time.model.TimeZoneModel;

@RunWith(MockitoJUnitRunner.class)
class TimezoneServiceImplTest {

	private static final String WORLD_TIME_API_URL = "http://worldtimeapi.org/api/timezone/%s";

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private TimezoneServiceImpl timezoneService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetTimeZoneDetailsWithValidTimeZoneReturnsTimeZoneModel() {
		TimeZoneModel expected = new TimeZoneModel();
		when(restTemplate.getForObject(String.format(WORLD_TIME_API_URL, "America/New_York"), TimeZoneModel.class))
				.thenReturn(expected);

		TimeZoneModel actual = timezoneService.getTimeZoneDetails("America/New_York");

		assertNotNull(actual);
	}

	@Test
	void testGetTimeZoneDetailsWithInvalidTimeZoneThrowsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> timezoneService.getTimeZoneDetails("Invalid Timezone"));
	}

}

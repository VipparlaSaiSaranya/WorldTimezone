package com.time.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.time.model.TimeZoneModel;
import com.time.service.ITimezoneService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class TimezoneControllerTest {

	@Mock
	private ITimezoneService iTimezoneService;

	@InjectMocks
	private TimezoneController timezoneController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetTimeReturnsTimeZoneDetails() {
		TimeZoneModel expected = new TimeZoneModel();
		when(iTimezoneService.getTimeZoneDetails(anyString())).thenReturn(expected);

		ResponseEntity<TimeZoneModel> actual = timezoneController.getTime("America/New_York");

		assertEquals(HttpStatus.OK, actual.getStatusCode());
		assertEquals(expected, actual.getBody());
	}

	@Test
	void testGetTimeWithInvalidTimeZoneReturnsInternalServerError() {
		when(iTimezoneService.getTimeZoneDetails(anyString())).thenThrow(new IllegalArgumentException());

		ResponseEntity<TimeZoneModel> actual = timezoneController.getTime("Invalid Timezone");

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, actual.getStatusCode());
	}
}

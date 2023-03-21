package com.time.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.time.model.TimeZoneModel;
import com.time.service.ITimezoneService;

@RestController
public class TimezoneController {

	@Autowired
	private ITimezoneService iTimezoneService;

	/**
	 * Returns time zone details
	 * 
	 * @param timezone
	 * @return
	 */
	@GetMapping("/time")
	public ResponseEntity<TimeZoneModel> getTime(@RequestParam String timezone) {
		TimeZoneModel response = null;
		if (Objects.isNull(timezone)) {
			return new ResponseEntity<TimeZoneModel>(response, HttpStatus.BAD_REQUEST);
		} else {
			try {
				response = iTimezoneService.getTimeZoneDetails(timezone);
				return new ResponseEntity<TimeZoneModel>(response, HttpStatus.OK);
			} catch (Exception ex) {
				return new ResponseEntity<TimeZoneModel>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
}

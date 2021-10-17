package com.company.app.service;

import java.net.UnknownHostException;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {

	//String getClientIp(HttpServletRequest request);
	
	String getIpAddress() throws UnknownHostException;
	
	String getOperatingSystem(HttpServletRequest request);
	
	String getBrowser(HttpServletRequest request);
	
	//List<T> getTimeZone (Locale clientLocale, ZoneId clientZoneId);
	String getTimeZone(Locale clientLocale, ZoneId clientZoneId);
}

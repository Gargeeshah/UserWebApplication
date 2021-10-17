package com.company.app.controller;


import java.net.UnknownHostException;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.company.app.service.RequestService;

@Controller
public class UserController<T> {


	
	@Autowired
	private RequestService requestService;
	
//	public String testHandler (Locale clientLocale, ZoneId clientZoneId) {
//
//        ZoneOffset serverZoneOffset = ZoneOffset.ofTotalSeconds(
//                  TimeZone.getDefault().getRawOffset() / 1000);
//
//        String clientZonetime = clientZoneId.normalized().getId();
//        
//        return String.format("client timeZone: %s" +
//                                       "<br/> " +
//                                       "server timeZone: %s" +
//                                       "<br/>" +
//                                       " locale: %s%n",
//                             clientZoneId.normalized().getId(),
//                             serverZoneOffset.getId(),
//                             clientLocale);
//    }

	@RequestMapping("/")
	public String getUserSytemDetails(HttpServletRequest request, Model model,Locale clientLocale,ZoneId clientZoneId) throws UnknownHostException {
		
		String clientIp = requestService.getIpAddress();
		String clientOs = requestService.getOperatingSystem(request);
		String clientBrowser = requestService.getBrowser(request);
		//List<T> getTimeZone = requestService.getTimeZone(clientLocale,clientZoneId);
		String getTimeZone = requestService.getTimeZone(clientLocale, clientZoneId);
		model.addAttribute("clientOs",clientOs);
		model.addAttribute("clientIp",clientIp);
		model.addAttribute("clientBrowser",clientBrowser);
		model.addAttribute("getTimeZone", getTimeZone);
		
		return "home";
		
	}
	
	
}

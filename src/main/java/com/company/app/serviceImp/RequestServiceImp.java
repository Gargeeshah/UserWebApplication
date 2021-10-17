package com.company.app.serviceImp;

import java.net.InetAddress;


import java.net.UnknownHostException;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.company.app.service.RequestService;

@Service
public class RequestServiceImp  implements RequestService {

	
	
//	public String getClientIp(HttpServletRequest request) {
//		String ip = request.getHeader("X-Forwarded-For");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//	}

	@Override
	public String getIpAddress() throws UnknownHostException {
		InetAddress IpAddress = InetAddress.getLocalHost();
		String ipaddress = IpAddress.getHostAddress();
		return ipaddress;
		
	}

	@Override
	public String getOperatingSystem(HttpServletRequest request) {
		
		 final String osName = System.getProperty("os.name");
		 return osName;
//		final String browserDetails = request.getHeader("User-Agent");
//
//        //=================OS=======================
//        final String lowerCaseBrowser = browserDetails.toLowerCase();
//        if (lowerCaseBrowser.contains("windows")) {
//            return "Windows";
//        } else if (lowerCaseBrowser.contains("mac")) {
//            return "Mac";
//        } else if (lowerCaseBrowser.contains("x11")) {
//            return "Unix";
//        } else if (lowerCaseBrowser.contains("android")) {
//            return "Android";
//        } else if (lowerCaseBrowser.contains("iphone")) {
//            return "IPhone";
//        } else {
//            return "UnKnown, More-Info: " + browserDetails;
//        }
//    
//	}

	}

	@Override
	public String getBrowser(HttpServletRequest request) {
	        final String browserDetails = request.getHeader("User-Agent");
	
	        final String user = browserDetails.toLowerCase();
	       
	        String browser = "";
	       
	        //===============Browser===========================
	        if (user.contains("msie")) {
	            String substring = browserDetails.substring(browserDetails.indexOf("MSIE")).split(";")[0];
	            browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
	        } else if (user.contains("safari") && user.contains("version")) {
	            browser = (browserDetails.substring(browserDetails.indexOf("Safari")).split(" ")[0]).split(
	                    "/")[0] + "-" + (browserDetails.substring(
	                    browserDetails.indexOf("Version")).split(" ")[0]).split("/")[1];
	        } else if (user.contains("opr") || user.contains("opera")) {
	            if (user.contains("opera"))
	                browser = (browserDetails.substring(browserDetails.indexOf("Opera")).split(" ")[0]).split(
	                        "/")[0] + "-" + (browserDetails.substring(
	                        browserDetails.indexOf("Version")).split(" ")[0]).split("/")[1];
	            else if (user.contains("opr"))
	                browser = ((browserDetails.substring(browserDetails.indexOf("OPR")).split(" ")[0]).replace("/",
	                                                                                                           "-")).replace(
	                        "OPR", "Opera");
	        } else if (user.contains("edg")){
	        	browser = (browserDetails.substring(browserDetails.indexOf("Edg")).split(" ")[0]).replace("/", "-");
	        } 
	        else if (user.contains("chrome")) {
	            browser = (browserDetails.substring(browserDetails.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
	        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1) || (user.indexOf(
	                "mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf(
	                "mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1)) {
	            //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
	            browser = "Netscape-?";

	        } else if (user.contains("firefox")) {
	            browser = (browserDetails.substring(browserDetails.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
	        } else if (user.contains("rv")) {
	            browser = "Internet Explorer";
	        }
	        else {
	            browser = "UnKnown, More-Info: " + browserDetails;
	        	
	        }

	        return browser;
	    }

	@Override
	public String getTimeZone(Locale clientLocale, ZoneId clientZoneId) {
		ZoneOffset serverZoneOffset = ZoneOffset.ofTotalSeconds(
              TimeZone.getDefault().getRawOffset() / 1000);
		String clientTimeZone = clientZoneId.normalized().getId();
		return clientTimeZone;
	}

//	@Override
//	public List<T> getTimeZone(Locale clientLocale, ZoneId clientZoneId) {
//		ZoneOffset serverZoneOffset = ZoneOffset.ofTotalSeconds(
//                TimeZone.getDefault().getRawOffset() / 1000);
//		
//		String clientTimeZone = clientZoneId.normalized().getId();
//		String serverZone = serverZoneOffset.getId();
//		Locale locale = clientLocale;
//		List<T> timezone = new ArrayList<>();
//		timezone.add( (T) clientTimeZone);
//		timezone.add( (T) serverZone);
//		timezone.add( (T) locale);
//		
//		
//		
//		return timezone;
//		
//	}


	
	
	

	
}
	
package com.company.app;

import java.util.Locale;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Component
public class AcceptHeaderLocaleTzCompositeResolver implements LocaleContextResolver {
	    private LocaleContextResolver localeContextResolver;
	    private AcceptHeaderLocaleResolver acceptHeaderLocaleResolver;

	    public AcceptHeaderLocaleTzCompositeResolver (LocaleContextResolver localeContextResolver) {
	        this.localeContextResolver = localeContextResolver;
	        acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
	        acceptHeaderLocaleResolver.setDefaultLocale(Locale.getDefault());
	    }

	   

		@Override
		public Locale resolveLocale(HttpServletRequest request) {
			 return acceptHeaderLocaleResolver.resolveLocale(request);
		}

		@Override
		public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		acceptHeaderLocaleResolver.setLocale(request, response, locale);

		}

		@Override
		public LocaleContext resolveLocaleContext(HttpServletRequest request) {
			 return localeContextResolver.resolveLocaleContext(request);
		}

		@Override
		public void setLocaleContext(HttpServletRequest request, HttpServletResponse response,
				LocaleContext localeContext) {
			localeContextResolver.setLocaleContext(request, response, localeContext);
		}
}

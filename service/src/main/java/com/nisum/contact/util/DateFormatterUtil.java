package com.nisum.contact.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class DateFormatterUtil {

	private static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String SIMPLE_ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";

	private DateFormatterUtil() {
	}

	public static String formatDate(Date date) {
		final DateFormat formatDate = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
		return formatDate.format(date);
	}

	public static String formatDateToISO(Date date) {
		final DateFormat formatDateToISO = new SimpleDateFormat(SIMPLE_ISO_DATE_FORMAT);
		return formatDateToISO.format(date);
	}

	public static Date fromText(String dateText, SimpleDateFormat format) {
		Date retValue = null;
		try {
			retValue = format.parse(dateText);
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
		return retValue;
	}

	public static Date fromISOFormatText(String dateText) {
		final DateFormat fromISOFormatText = new SimpleDateFormat(SIMPLE_ISO_DATE_FORMAT);
		Date retValue = null;
		try {
			retValue = fromISOFormatText.parse(dateText);
		} catch (ParseException e) {
			log.debug(e.getMessage());
		}
		return retValue;
	}

}

package com.openbank.onlinebanking.util;

import static com.openbank.onlinebanking.util.ApplicationConstants.DATE_FORMAT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppUtil {
	private static Logger log = LoggerFactory.getLogger(AppUtil.class);

	static SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
	static String regexDDMMYYYY="^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
	
	public static Date getDateFromStr(String strDate) {
		Date date = null;
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
			log.error("Parsing Date {}",e);
		}
		return date;
	}
	
	public static boolean isAValidDDMMYYYYDate(String date) {
		return Pattern.matches(regexDDMMYYYY, date);
	}

	public static void main(String a[]) throws ParseException {
		System.out.println(getDateFromStr("10/10/2012"));
		System.out.println(getDateFromStr("1022/10/2012"));
	}
}

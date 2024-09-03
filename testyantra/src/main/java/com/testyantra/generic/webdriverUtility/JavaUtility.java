package com.testyantra.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandomNumber() {
	Random random =new Random();
	int radnum = random.nextInt(1000);
	return radnum;
}
public String getSystemdateYYYYDDMM() {
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	String actualsystemdate = sim.format(date);
	return actualsystemdate;
}
public String getrequiredDateFormat(int days) {
	SimpleDateFormat sim =new SimpleDateFormat("dd-MM-yyyy");
	Calendar cal = sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String requireddate = sim.format(cal.getTime());
	return requireddate;
}
}

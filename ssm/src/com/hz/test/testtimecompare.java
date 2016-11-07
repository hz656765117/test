package com.hz.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class testtimecompare {
	public static void main(String[] args) {
		String timing = "2016-09-31 08:30:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss");
		String nowTime = sdf.format(new Date());
		int res = nowTime.compareTo(timing);
		System.out.println(res);
	}
}

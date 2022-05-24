package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonDate {
	public static  Date getDate(String date) {
		Date date1=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(date==null) {
			date1=new Date();
		}else {
		try {
			date1=sdf.parse(date);
				System.out.println(date1);
		
		}catch (Exception e) {
e.printStackTrace();		}
		}
		return date1;
		
	}
}

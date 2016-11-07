package com.hz.test;

import java.io.File;
import java.util.Date;

import com.hz.base.utils.DateUtil;

public class TestFile {
	public static void main(String[] args) {
		String name = DateUtil.convertDateToString("yyyyMM", new Date());
		String path = "E:" + File.separator+"upload"+ File.separator+ "pic"+ File.separator +  name;
		boolean success = TestFile.makeDirectory(path);
		System.out.println(success);
	}
	
	public static boolean makeDirectory(String path){
		File file = new File(path);
		return (file.exists() && file.isDirectory()) ? true : file.mkdirs();
	}
	
	
}

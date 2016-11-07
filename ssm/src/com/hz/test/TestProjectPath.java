package com.hz.test;

public class TestProjectPath {
	public static void main(String[] args) {
		String currentPath=	new TestProjectPath().getpath();
		System.out.println(System.getProperty("user.dir"));
		System.out.println(currentPath);
	}
	public String  getpath(){
		String currentPath=getClass().getResource(".").getFile().toString();
		return currentPath;
	}
}

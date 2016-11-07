package com.hz.test;

public class TestSub {
	public static void main(String[] args) {
		String name = "ddd.hz11.png";
		String[] ss = name.split(".");
		int s = name.lastIndexOf(".");
		String suffix = name.substring(name.lastIndexOf(".")+1);
		System.out.println(ss);
		System.out.println(s);
		System.out.println(suffix);
	}
}

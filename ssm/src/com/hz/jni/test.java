package com.hz.jni;

import java.util.UUID;

public class test {
	public static void main(String[] args) {
		System.out.println("hello");
		UUID uuid  = UUID.randomUUID();
		System.out.println(uuid.toString());
		System.out.println(uuid.getLeastSignificantBits());
		System.out.println(uuid.getMostSignificantBits());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
	}
}

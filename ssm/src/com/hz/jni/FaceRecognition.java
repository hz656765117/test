package com.hz.jni;

public class FaceRecognition {
	public native int validPic(String sourceUrl,String signUrl);
	
	public static void main(String[] args) {
    	 System.loadLibrary("hi");
    	 FaceRecognition tNative = new FaceRecognition();
         int result = tNative.validPic("","");
         System.out.println(result);
     }
}

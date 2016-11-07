package com.hz.jni;

public class TestJni {
	public native String saySame(String name);
	public native boolean validPic(String url);
	public native void sayHello();
 
    public static void main(String[] args) {
        // System.loadLibrary("sayhello");
    	// System.loadLibrary("MSVCP120D");
    	 System.out.println("执行main方法");
    	 System.loadLibrary("hi");
         TestJni tNative = new TestJni();
         tNative.sayHello();    
         String same =  tNative.saySame("huangzhuo");
         System.out.println(same);
         boolean success =  tNative.validPic("图片路径，用于识别");
         System.out.println(success);
     }
	
}

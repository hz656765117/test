package com.hz.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class testIO {
	
	/**
	 * 写文件 
	 * @param path 文件路径
	 * @param buf  文件内容  字节数组
	 * @return
	 */
	public static boolean writeFileByBytes(String path , byte[] buf){
		 FileOutputStream o = null;
         
	        try {
	            o = new FileOutputStream(path);
	           
	            o.write(buf);
	             
	        } catch (IOException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            if(o != null) {
	                try {
	                    o.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        } 
		return true;
	}
	
	public static byte[] readFile(String path){
		FileInputStream i = null;
		byte[] buf = null;
        try {
            i = new FileInputStream(path);
            buf = new byte[i.available()];
            i.read(buf);
            System.out.println(new String(buf));
             
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(i != null) {
                try {
                    i.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return buf;
	}
	
	
	public static void main(String[] args ) {
        
        String path = "E:" + File.separator +  "test1.txt";
        String path1 = "E:" + File.separator +  "test12.txt";
////        String str = "hz is a good boy\r\n really 黄卓";
////        byte[] buf = str.getBytes();
////        boolean success = testIO.writeFileByBytes(path, buf);
////        System.out.println(success);
  
        FileInputStream i = null;
        FileOutputStream o = null;
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
         
        try {
            i = new FileInputStream(path);
            o = new FileOutputStream(path1);
            bi = new BufferedInputStream(i);
            bo = new BufferedOutputStream(o);
             
            byte[] buf = new byte[1024];
            int temp = 0;
            while((temp = bi.read(buf)) != -1) {
            	System.out.println(temp);
                bo.write(buf,0,temp);
            }
            System.out.println(temp);
             
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bi != null) {
                try {
                    i.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bo != null) {
                try {
                    o.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
        
        
        
        
        
//        FileInputStream i = null;
//        
//        try {
//            i = new FileInputStream(path);
//             
//            //方式一：单个字符读取
//            //需要注意的是，此处我用英文文本测试效果良好
//            //但中文就悲剧了，不过下面两个方法效果良好
//           /* int ch = 0;
//            while((ch=i.read()) != -1){
//                System.out.print((char)ch);
//            }*/
//             
//            //方式二：数组循环读取
//           
///*            byte[] buf = new byte[1024];
//            int len = 0;
//            while((len = i.read(buf)) != -1) {
//                System.out.println(new String(buf,0,len));
//            }*/
//            
//             
//             
//            //方式三：标准大小的数组读取
//            
//            //定一个一个刚好大小的数组
//            //available()方法返回文件的字节数
//            //但是，如果文件过大，内存溢出，那就悲剧了
//            //所以，亲们要慎用！！！上面那个方法就不错
//            byte[] buf = new byte[i.available()];
//            i.read(buf);
//            //因为数组大小刚好，所以转换为字符串时无需在构造函数中设置起始点
//            System.out.println(new String(buf));
//             
//             
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(i != null) {
//                try {
//                    i.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        
        
        
    }
       
    
   
}

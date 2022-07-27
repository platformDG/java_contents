package com.dgstory.a220624.test01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int totalBytes = 0;
		
		try {
			try {
				fis = new FileInputStream("test.txt");
				fos = new FileOutputStream("test_copy.txt");
				for(int readByte; (readByte = fis.read()) != -1; ){
//					System.out.write(readByte);
					fos.write(readByte);
					totalBytes++;
				}
			}finally {
				fos.close();
				fis.close();
			}
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("\n전체 바이트수 : " +  totalBytes + " bytes.");
	}
}

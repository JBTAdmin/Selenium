package com.blog.junitTests;

import java.io.IOException;

import com.blog.utility.ExcelOperationsUsingPOI;

public class ReadExcelData {

	public static void main(String[] args) {
		try {
			ExcelOperationsUsingPOI.readExcel("E:\\Selenium", "ReadUsingPOI.xlsx", "Demographics");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

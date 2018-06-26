package com.blog.junitTests;

import javax.mail.MessagingException;

import com.blog.utility.SendMail;

/*
 * Invokes SendMail.java 
 */
public class InvokeMail {
	public static void main(String[] args) throws MessagingException {
		
		//String to[] = {"test2@gmail.com","test3@gmail.com"};
		String to[] = {"test2@gmail.com"};
		
		SendMail.send("test1@gmail.com", to, "JUnit Report", "Check the PDF attachment.");		

	}
}

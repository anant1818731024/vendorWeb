package com.anant.spring.boot.util;

public interface EmailUtil {

	public void sendEmail(String toAddress, String subject, String body);
	
}

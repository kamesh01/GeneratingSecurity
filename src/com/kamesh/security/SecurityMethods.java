package com.kamesh.security;

public interface SecurityMethods {
	char[] generatePassword(int length) throws Exception;

	char[] generateOTP(int length) throws Exception;

	boolean authenticate() throws Exception;
}

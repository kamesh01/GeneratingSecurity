package com.kamesh.security;

import java.util.Random;
import java.util.Scanner;

class Secure implements SecurityMethods {

	@Override
	public char[] generatePassword(int length) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Generating Password pleases wait..... ");
		Thread.sleep(1000);
		System.out.print("Your new password is : ");
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
//		String symbols = "!@#$%^&*_=+-/.?<>)";
		String symbols = "!@#$%^&*_=+-?)";

		String passwordValues = Capital_chars + Small_chars + numbers + symbols;

		Random rnd = new Random();

		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			password[i] = passwordValues.charAt(rnd.nextInt(passwordValues.length()));
		}
		return password;
	}

	@Override
	public char[] generateOTP(int length) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Generating OTP..... ");
		Thread.sleep(1000);
		System.out.print("Your OTP is : ");
		String numbers = "0123456789";

		Random rnd = new Random();
		char[] otp = new char[length];

		for (int i = 0; i < length; i++) {
			otp[i] = numbers.charAt(rnd.nextInt(numbers.length()));
		}
		return otp;
	}

	@Override
	public boolean authenticate() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Authenticating your credential......");
		Thread.sleep(2000);
		return true;
	}
}

public class GeneratSecurity {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\t\t@@@@@___Security Methods Sample___@@@@@\n\n");
		System.out.println("Select your security option : \n1. Generate Password\n2. Generate OTP");
		try {
			int selection = sc.nextInt();
			// Creating object for security class to use its method
			SecurityMethods security = new Secure();

			switch (selection) {
			case 1:
				System.out.println("*****You have selected password generator method*****\n\n");
				// calling the authentication method before providing any service
				security.authenticate();
				System.out.println("Enter length of the password : ");
				int length = sc.nextInt();
				System.out.println(security.generatePassword(length));
				break;

			case 2:
				System.out.println("*****You have selected password generator method*****\n\n");
				// calling the authentication method before providing any service
				security.authenticate();
				System.out.println(security.generateOTP(6));
				break;

			default:
				System.out.println("Please enter any valid option\nThank you for visiting...");
				System.exit(1);
				break;
			}

		} finally {
			sc.close();
		}
	}
}

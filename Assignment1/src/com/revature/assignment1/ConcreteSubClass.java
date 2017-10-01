package com.revature.assignment1;

public class ConcreteSubClass extends AbstractMethod {

	@Override
	public Boolean checkUpperChar(String str1) {

		for (int i = 0; i < str1.length() - 1; i++) {
			char c = str1.charAt(i);
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;

	}

	@Override
	public void convertChar(String str2) {

		StringBuilder sb = new StringBuilder(str2);
		for (int i = 0; i < sb.length(); i++) {
			char charStr = sb.charAt(i);
			if (Character.isLowerCase(charStr)) {
				sb.setCharAt(i, Character.toUpperCase(charStr));
			} else {
				sb.charAt(i);
			}
		}
		System.out.println(sb.toString());
	}

	@Override
	public void convertInputStr(String str3) {

		try {
			int i = Integer.parseInt(str3);
			i = i + 10;

			System.out.println("Integer= " + i);
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}

	}

}

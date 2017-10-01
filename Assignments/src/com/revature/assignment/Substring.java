package com.revature.assignment;

public class Substring {
 
	static String substring(String str, int idx, int len) {
		  return str.substring(idx, str.offsetByCodePoints(idx, len));
		}
}

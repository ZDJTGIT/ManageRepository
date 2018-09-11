package com.zd.manager.core.util;

public class StringUtils {
	public static String humpToUnderline(String str) {
		char[] array = str.toCharArray();
		int k = 0;
		for(int i=0;i<array.length;i++) {
			if(array[i]<='Z'&&array[i]>='A') {
				StringBuilder sb = new StringBuilder(str);
				str = sb.replace(i+k,i+k+1,String.valueOf(array[i]+=32)).toString();
				String str1 = str.substring(0, i+k);
				String str2 = str.substring(i+k);
				str = str1+"_"+str2;
				k+=1;
			}
		}
		return str;
	}
}

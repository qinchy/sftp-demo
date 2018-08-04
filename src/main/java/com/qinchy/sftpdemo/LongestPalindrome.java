package com.qinchy.sftpdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
class Solution5 {
    public String longestPalindrome(String s) {
      if (s == null || s.length() < 2) {
			return s;
		}
		
		int maxLength = 0;
		String longest = null;
		
		int length = s.length();
		boolean[][] table = new boolean[length][length];
		
		// 单个字符都是回文
		for (int i = 0; i < length; i++) {
			table[i][i] = true;
			longest = s.substring(i, i+1);
			maxLength = 1;
		}
		
		// 判断两个字符是否是回文
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i+1] = true;
				longest = s.substring(i, i + 2);
				maxLength = 2;
			}
		}
		
		// 求长度大于2的字串是否是回文串
		for (int len = 3; len <= length; len++) {
			//同一个字符串会取子串比较
			//i是每个字符的索引,j也是索引但是它的范围要比i小1
			for (int i = 0, j; (j = i + len - 1) <= length - 1; i++) {
				if (s.charAt(i) == s.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
					if(table[i][j] && maxLength < len) {
						longest = s.substring(i, j + 1);
						maxLength = len;
					}
				}else {
					table[i][j] = false;
				}
			}
		}
		
		return longest;  
    }
}

public class LongestPalindrome {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
//        return Json.value(input).toString();
		return "";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            String ret = new Solution5().longestPalindrome(s);
            
            String out = (ret);
            
            System.out.print(out);
        }
    }
}
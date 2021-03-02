package com.leetcode.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution
 * @Description: leetcode 无重复字符的最长子串 maxlength[i]表示包含字符串第i位的无重复字符的最长子串长度
 *               sub[i]表示包含字符串第i位的无重复字符的最长子串
 *               则如果字符串的第i位在sub[i-1]中没有出现过，则maxlength[i]=maxlength[i-1]+1;
 *               否则，posiTemp表示字符串的第i位在sub[i-1]中出现的s字符串下标，则maxlength[i]= i -
 *               posiTemp;
 * @author: huangzhongjie
 * @date: 2018年4月22日 下午9:57:17
 */

public class Solution3 {

	public int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> mapPositon = new HashMap<Character, Integer>();

		// 标示无重复字符的最长子串的开始下标
		int posiBegin = 0;

		int result = 0;

		// 包含字符串第i位的无重复字符最长子串的长度
		int noRepeatLength = 0;

		for (int i = 0; i < s.length(); i++) {

			Integer posiTemp = mapPositon.get(s.charAt(i));
			mapPositon.put(s.charAt(i), i);
			/*
			 * 第i位在sub[i-1](表示包含字符串第i-1位的无重复字符的最长子串)中出现过，则sub[i]为开始下标为posiTemp +
			 * 1结束下标为i的子字符串
			 */
			if (null != posiTemp && posiTemp >= posiBegin) {
				noRepeatLength = i - posiTemp;
				posiBegin = posiTemp + 1;

			}
			/*
			 * 第i位在sub[i-1](表示包含字符串第i-1位的无重复字符的最长子串)没有出现
			 * 则sub[i]为开始下标为posiBegin结束下标为i的子字符串
			 */
			else {
				noRepeatLength++;
			}

			result = Math.max(result, noRepeatLength);
		}

		return result;
	}

}
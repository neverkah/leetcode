package com.leetcode.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution
 * @Description: leetcode ���ظ��ַ�����Ӵ� maxlength[i]��ʾ�����ַ�����iλ�����ظ��ַ�����Ӵ�����
 *               sub[i]��ʾ�����ַ�����iλ�����ظ��ַ�����Ӵ�
 *               ������ַ����ĵ�iλ��sub[i-1]��û�г��ֹ�����maxlength[i]=maxlength[i-1]+1;
 *               ����posiTemp��ʾ�ַ����ĵ�iλ��sub[i-1]�г��ֵ�s�ַ����±꣬��maxlength[i]= i -
 *               posiTemp;
 * @author: huangzhongjie
 * @date: 2018��4��22�� ����9:57:17
 */

public class Solution3 {

	public int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> mapPositon = new HashMap<Character, Integer>();

		// ��ʾ���ظ��ַ�����Ӵ��Ŀ�ʼ�±�
		int posiBegin = 0;

		int result = 0;

		// �����ַ�����iλ�����ظ��ַ���Ӵ��ĳ���
		int noRepeatLength = 0;

		for (int i = 0; i < s.length(); i++) {

			Integer posiTemp = mapPositon.get(s.charAt(i));
			mapPositon.put(s.charAt(i), i);
			/*
			 * ��iλ��sub[i-1](��ʾ�����ַ�����i-1λ�����ظ��ַ�����Ӵ�)�г��ֹ�����sub[i]Ϊ��ʼ�±�ΪposiTemp +
			 * 1�����±�Ϊi�����ַ���
			 */
			if (null != posiTemp && posiTemp >= posiBegin) {
				noRepeatLength = i - posiTemp;
				posiBegin = posiTemp + 1;

			}
			/*
			 * ��iλ��sub[i-1](��ʾ�����ַ�����i-1λ�����ظ��ַ�����Ӵ�)û�г���
			 * ��sub[i]Ϊ��ʼ�±�ΪposiBegin�����±�Ϊi�����ַ���
			 */
			else {
				noRepeatLength++;
			}

			result = Math.max(result, noRepeatLength);
		}

		return result;
	}

}
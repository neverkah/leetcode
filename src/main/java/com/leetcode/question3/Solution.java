package com.leetcode.question3;


 /**
  * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @ClassName: Solution2 
 * @Description: leetcode ���ظ��ַ�����Ӵ�
 * �����������Ϊ1��2��3..���Ӵ������ظ����ȵ���Ӵ�
 * @author: huangzhongjie
 * @date: 2018��4��22�� ����9:15:05  
 */
 
public class Solution {

	public int lengthOfLongestSubstring(String s) {

		// int[i]��ʾs��iλ��i+jλ���Ӵ��Ƿ����ظ�
		int[] flag = new int[s.length()];

		boolean isRepeated = false;

		int result = 0;

		for (int j = 0; j < s.length(); j++) {
			for (int i = j; i < s.length(); i++) {
				isRepeated = false;
				for (int k = i - j; k <= i - j + 1 && k < i; k++) {
					if (flag[k] == 1) {
						flag[i - j] = 1;
						isRepeated = true;
						break;
					}
					if (k==i-j&&s.charAt(i) == s.charAt(k)) {
						flag[i - j] = 1;
						isRepeated = true;
						break;
					}
				}
				if (!isRepeated) {
					result = j + 1;
				}
			}
		}

		return result;

	}

//	public static void main(String[] args) {
//		Solution3 solution2 = new Solution3();
//		int a1 = solution2.lengthOfLongestSubstring("jlygy");
//		int a2 = solution2.lengthOfLongestSubstring("bbbbb");
//		int a3 = solution2.lengthOfLongestSubstring("pwwkew");
//
//		System.out.println(a1);
//
//		System.out.println(a1 + " " + a2 + " " + a3);
//	}


}
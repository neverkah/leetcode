package com.leetcode.question2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		ListNode l1 = null;
		// 取l1 next节点的临时变量
		ListNode l1temp = null;
		ListNode l2 = null;
		// 取l2 next节点的临时变量
		ListNode l2temp = null;

		boolean isFirst = true;
		char temp;

		String s = in.nextLine();

		for (int i = 0; i < s.length(); i++) {
			temp = s.charAt(i);

			if (temp == ')') {
				if (isFirst) {
					isFirst = false;
				} else {

					break;
				}

			}

			else if (temp >= '0' && temp <= '9') {
				if (isFirst) {
					if (l1temp == null) {
						l1temp = l1 = new ListNode(temp - 48);
					} else {
						l1temp = l1temp.next = new ListNode(temp - 48);
					}

				} else {
					if (l2temp == null) {
						l2temp = l2 = new ListNode(temp - 48);
					} else {
						l2temp = l2temp.next = new ListNode(temp - 48);
					}

				}
			}

		}
		Solution solution = new Solution();
		ListNode listNodeResult = solution.addTwoNumbers(l1, l2);

		// System.out.println(listNodeResult);
		int position = 0;
		ListNode listNodeTemp = listNodeResult;
		while (null != listNodeTemp) {
			if (0 == position) {
				System.out.print(listNodeTemp.val + " ");
			} else if (listNodeTemp.next != null) {
				System.out.print("-> " + listNodeTemp.val + " ");
			} else {
				System.out.print("-> " + listNodeTemp.val);
			}
			listNodeTemp = listNodeTemp.next;
			position++;
		}

	}
}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

}
/*
https://leetcode.com/problems/add-two-numbers/
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		// 取l1 next节点的临时变量
		ListNode tempListNodeResult = null;

		ListNode resultListNode = l1;

		// 进位
		int carry = 0;
		// 两个数对应数位相加计算结果
		int temp = 0;
		while (l1 != null || l2 != null || carry != 0) {
			temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
			if (null == tempListNodeResult) {
				resultListNode.val = (temp + carry) % 10;
				tempListNodeResult = resultListNode;

			} else {
				if (tempListNodeResult.next == null) {
					tempListNodeResult.next = new ListNode((temp + carry) % 10);
				} else {

					tempListNodeResult.next.val = (temp + carry) % 10;
				}
				tempListNodeResult = tempListNodeResult.next;
			}
			carry = (temp + carry) / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}

		}

		return resultListNode;
	}

}

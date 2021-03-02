package com.leetcode.question3;

import java.util.HashMap;

public class Solution4 {
    public int lengthOfLongestSubstring(String s) {  
        if (s == null || s.length() == 0) {  
            return 0;  
        }  
          
        //http://fisherlei.blogspot.com/2012/12/leetcode-longest-substring-without.html  
        // 使用hashmap 来记录各个字符最后出现的位置，如果之前出现过，则需要将窗口在前面截断，否则当前长度  
        // 应该在上一个长度加1；  
          
        int len = s.length();  
        int max = 0;  
        int last = 0;  
          
        HashMap h = new HashMap();  
        for (int i = 0; i < len; i++) {  
            char c = s.charAt(i);  
            if (h.containsKey(c)) {  
                // go back the the last index and count again.  
                i = (Integer) h.get(c);  
                h.clear();  
                last = 0;  
                continue;  
            } else {  
                last++;  
            }  
            h.put(s.charAt(i), i);  
            max = Math.max(max, last);  
        }  
          
        return max;  
    }  
    
    public static void main(String[] args) {
    	Solution4 solution = new Solution4();
    	
    	//int x = solution.lengthOfLongestSubstring("abcabcbb");
    	
    	//System.out.println(x);
    	
    
    	for(int i = 1;i<=3;i++){
    		if(i==2){
    			
    			continue;
    		}
    		System.out.println(i);
    	}
	}
}  
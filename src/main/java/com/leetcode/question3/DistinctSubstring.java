package com.leetcode.question3;
import java.util.HashMap;
import java.util.Map;


public class DistinctSubstring {

    public int longestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }
        //charPositionͳ��A��ÿ���ַ�֮ǰ���ֵ�λ��

        Map<Character, Integer> charPosition = new HashMap<Character, Integer>();

        //preArr������s[i-1]��β������£�����ظ��Ӵ��ĳ���

        int[] preArr = new int[s.length()];


        char[] str2charArr = s.toCharArray();

        //��ͷ��β����str2charArr��ͳ�Ƴ���ÿ���ַ�Ϊ��ǰλ�õ���ǰ����ظ��Ӵ��ĳ���
        for(int i=0; i<s.length(); i++){

            Integer lastPosOfChar = charPosition.get(str2charArr[i]);

          if(lastPosOfChar == null){//˵����ǰ�ַ���һ�γ���

              //��������ظ��Ӵ��ĳ���

              preArr[i] = i == 0 ? 1 : preArr[i-1] + 1;

              //��¼��ǰ�ַ����ֵ�λ��

              charPosition.put(str2charArr[i], i);

          }

          else{//��ǰ�ַ����ǵ�һ�γ���(��Ȼ���ǵ�һ�γ��֣���Ҳ�����ڵ�һ��λ��),Ҳ����֮ǰ���ֹ����ַ�

              //��ȡǰһ���ַ�����ظ��Ӵ��ĳ���

              int aPos = lastPosOfChar + 1;

              int unRepeatLen = preArr[i-1];

              int bPos = i - unRepeatLen;

              if(aPos >= bPos){

                  //��ǰλ�õ�����ظ��Ӵ�����

                  preArr[i] = i - aPos + 1;

              }

              else{

                  //��ǰλ�õ�����ظ��Ӵ�����

                  preArr[i] = i - bPos + 1;

              }

              //���µ�ǰ�ַ����ֵ�λ��

              charPosition.put(str2charArr[i], i);

          }

      }

      //����preArr,���ֵ��Ϊ����

      int max = preArr[0];

      for(int i: preArr) if(i > max) max = i;


      return max;

  }
    
    public static void main(String[] args) {
    	DistinctSubstring solution = new DistinctSubstring();
    	
    	int x = solution.longestSubstring("");
    	
    	System.out.println(x);
	}

}
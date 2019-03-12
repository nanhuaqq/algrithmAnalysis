package com.qq.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStrWithOutRepeat {
    /**
     * 这个方法还可以改进
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char [] chars = s.toCharArray();
        int len = chars.length;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int count = 0, max = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (charMap.get(c) == null) {
                count++;
            } else {
                i = charMap.get(c);
                count = 0;
                charMap.clear();
                continue;
            }
            max = Math.max(max, count);
            charMap.put(c, i);
        }
        return max;
    }

    public static int lengthOfLongestSubStr(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> charSet = new HashSet<>();
        int len = s.length();
        int i = 0, j = 0;
        int count = 0;
        while (i < len && j < len){
            if (charSet.contains(s.charAt(j))) {
                charSet.remove(s.charAt(i++));
            } else {
                charSet.add(s.charAt(j++));
                count = Math.max(count, j - i);
            }
        }
        return count;
    }
}

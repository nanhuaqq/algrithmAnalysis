package com.qq.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {


    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int len = strs.length;
        String commonPrefix = strs[0];
        int commonLen = commonPrefix.length();
        for (int i = 1; i < len; i++) {
            String compareStr = strs[i];
            commonLen = Math.min(commonLen, compareStr.length());
            for (int j = 0; j < commonLen; j++) {
                if (commonPrefix.charAt(j) == compareStr.charAt(j)) {
                    continue;
                } else {
                    commonLen = j;
                    break;
                }
            }
        }

        return commonPrefix.substring(0, commonLen);
    }
}

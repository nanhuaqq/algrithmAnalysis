package com.qq.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }


        char [] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            char pop = stack.pop();
            if (!isMatch(pop, chars[i])) {
                stack.push(pop);
                stack.push(chars[i]);
            }
        }

        return stack.isEmpty();
    }

    public boolean isMatch(char a, char b){
        if ((a == '(' && b == ')')
                || (a == '{' && b == '}')
                || (a == '[' && b == ']')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        String testStr = "";
        System.out.println(solution.isValid(testStr));
    }
}

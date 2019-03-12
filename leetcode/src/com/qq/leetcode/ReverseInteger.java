package com.qq.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 */
public class ReverseInteger {

    public int reverse(int num) {


        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
//            if ((rev * 10 + pop) > Integer.MAX_VALUE) {
//                return 0;
//            }
            //考虑溢出 要改写上述判定式  2147483647
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

//            if ((rev * 10 + pop) < Integer.MIN_VALUE) {
//                return 0;
//            }
            //考虑溢出 要改写上述判定式  -2147483648
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }


            rev = rev * 10 + pop;

        }

        return rev;
    }

    public static void main(String[] args) {
        int testInt = 120;
        ReverseInteger solution = new ReverseInteger();
        System.out.println(solution.reverse(testInt));
    }
}

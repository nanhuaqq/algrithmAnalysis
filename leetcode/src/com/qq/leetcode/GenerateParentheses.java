package com.qq.leetcode;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        int bitCount = 2 * n;

        BitSet initBitset = new BitSet(bitCount);
        initBitset.set(0, true);
        initBitset.set(bitCount - 1, false);

        List<BitSet> bitSets = new ArrayList<>();


        if (n == 1) {
            bitSets.add(initBitset);
            return convertBitToString(bitSets, 2);
        }

        treeSet(initBitset, 1, bitCount, bitSets);

        List<String> results = convertBitToString(bitSets, bitCount);
        return results;
    }

    public void treeSet(BitSet initBitset, int indexStart, int n, List<BitSet> bitSets) {
        //递归的结束条件
        if (indexStart >= n - 1) {
            return;
        }

        BitSet leftBitSet = new BitSet(n);
        leftBitSet.clear();
        leftBitSet.or(initBitset);

        BitSet rightBitSet = new BitSet(n);
        rightBitSet.clear();
        rightBitSet.or(initBitset);

        leftBitSet.set(indexStart, true);
        rightBitSet.set(indexStart, false);

        final int leftTrueCount = getTrueCount(leftBitSet);
        final int leftFalseCount = getFalseCount(leftBitSet, indexStart);
        final int rightFalseCount = getFalseCount(rightBitSet, indexStart);
        final int rightTrueCount = getTrueCount(rightBitSet);

        if (indexStart == n - 2) {
            if (leftTrueCount <= n / 2) {
                bitSets.add(leftBitSet);
            }
            if (rightFalseCount <= n/2 - 1) {
                bitSets.add(rightBitSet);
            }
        } else if (indexStart < n - 2){
            if (leftTrueCount <= n / 2 && leftFalseCount <= leftTrueCount) {
                treeSet(leftBitSet, indexStart + 1, n, bitSets);
            }
            if (rightFalseCount <= n / 2 - 1 && rightFalseCount <= rightTrueCount) {
                treeSet(rightBitSet, indexStart + 1, n, bitSets);
            }
        }
    }

    public int getTrueCount(BitSet bitSet) {
        int len = bitSet.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (bitSet.get(i)) {
                count ++;
            }
        }
        return count;
    }

    public int getFalseCount(BitSet bitSet, int endIndex) {
        int count = 0;
        for (int i = 0; i <= endIndex; i++) {
            if (!bitSet.get(i)) {
                count++;
            }
        }
        return count;
    }


    public void printResult(List<String> results) {
        if (results == null || results.isEmpty()) {
            return;
        }

        int len = results.size();
        for (int i = 0; i < len; i++) {
            System.out.println(results.get(i));
        }
    }

    public List<String> convertBitToString(List<BitSet> bitSets, int bitCount) {
        ArrayList<String> results = new ArrayList<>();
        if (bitSets == null || bitSets.isEmpty()) {
            return results;
        }
        int len = bitSets.size();
        for (int i = 0; i < len; i++) {
            BitSet bitSet = bitSets.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < bitCount; j++) {
                sb.append(bitSet.get(j) ? "(" : ")");
            }
            results.add(sb.toString());
        }
        return results;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.printResult(generateParentheses.generateParenthesis(3));
    }
}

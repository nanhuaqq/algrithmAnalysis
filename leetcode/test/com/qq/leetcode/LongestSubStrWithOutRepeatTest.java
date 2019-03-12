package com.qq.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubStrWithOutRepeatTest {
    private String emptyStr = " ";
    private String testStrOne = "abcabcbb";
    private String testStrTwo = "dvdf";

    @Test
    public void testStrOne(){
        int count = LongestSubStrWithOutRepeat.lengthOfLongestSubStr(testStrOne);
        Assert.assertEquals(3, count);
    }

    @Test
    public void testEmptyStr(){
        int count = LongestSubStrWithOutRepeat.lengthOfLongestSubStr(emptyStr);
        Assert.assertEquals(1, count);
    }

    @Test
    public void tesTwoStr(){
        int count = LongestSubStrWithOutRepeat.lengthOfLongestSubStr(testStrTwo);
        Assert.assertEquals(3, count);
    }
}

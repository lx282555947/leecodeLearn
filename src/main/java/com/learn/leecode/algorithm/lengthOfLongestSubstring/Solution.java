package com.learn.leecode.algorithm.lengthOfLongestSubstring;

import com.learn.leecode.datastructure.ListNode;
import com.learn.leecode.utils.PrintUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Solution {

    /**
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     *
     * 输入: s = ""
     * 输出: 0
     * @param args
     */
    public static void main(String[] args) {
        String s = "pwwkew";
        String s2 = "";
        String s3 = " ";
        String s4 = "abba";
        final int max = lengthOfLongestSubstring(s4);
        System.out.println(max);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        final int length = s.length();
        int startIndex = 0;
        int max = 0;
        String maxSubStr = null;
        for (int i = 0; i < length; i++) {
            final char currentChar = s.charAt(i);
            //查询字符在map中是否存在
            final Integer preIndex = map.get(currentChar);
            if (Objects.nonNull(preIndex) && preIndex >= startIndex) {
                startIndex = preIndex + 1;
            }
            map.put(currentChar, i);
            //判断长度
            int len = i - startIndex + 1;
            if (max < len) {
                max = len;
                maxSubStr = s.substring(startIndex, i + 1);
                System.out.println(maxSubStr);
            }
        }
        return max;
    }


}

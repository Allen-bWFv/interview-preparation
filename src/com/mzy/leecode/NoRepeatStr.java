package com.mzy.leecode;

import java.util.*;

public class NoRepeatStr {


    public static void main(String[] args) {
        String val = "asdasdsss";
        System.out.println(lengthOfLongestSubstring(val));
    }

    public static int lengthOfLongestSubstring(String s) {
        //顺序的遍历即可，所有不重复的检测，然后有一个最长的值
        //这里肯定需要一个容器记录不重复的字符串，然后一个数字记录长度
        //可以检查是否重复的话，应该用数组存储会比较好，取比较快，然后
        HashSet<Character> repeat = new HashSet<>();
        int maxSize = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            boolean contains = repeat.contains(c);
            if (contains){
                //需要移除的字符应该是第一个重复的字符之前的所有
                l = repeat.size() > l ? repeat.size() : l;
                int i1 = s.indexOf(c, maxSize);
                for (int j = maxSize; j <= i1; j++) {
                    repeat.remove(s.charAt(j));
                }
                repeat.add(c);
                maxSize = i1+1;
            }else {
                repeat.add(c);
            }
        }
        System.out.println("maxsize:" + maxSize + " l:" + l + "  repeat.size:" + repeat.size());
        return (l >= repeat.size()) ? l : repeat.size();
    }
}

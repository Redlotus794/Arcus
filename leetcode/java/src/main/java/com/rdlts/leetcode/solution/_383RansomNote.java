package com.rdlts.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

 Each letter in magazine can only be used once in ransomNote.

 Example 1:

 Input: ransomNote = "a", magazine = "b"
 Output: false
 Example 2:

 Input: ransomNote = "aa", magazine = "ab"
 Output: false
 Example 3:

 Input: ransomNote = "aa", magazine = "aab"
 Output: true


 Constraints:

 1 <= ransomNote.length, magazine.length <= 105
 ransomNote and magazine consist of lowercase English letters.
 */
public class _383RansomNote {

    // 初始解答
//    public static boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character, Integer> magazineMap = new HashMap<>();
//
//        for (int i = 0; i < magazine.length(); i++) {
//            final Character c = magazine.charAt(i);
//            final Integer occur = magazineMap.get(c);
//            if (occur == null) {
//                magazineMap.put(c, 1);
//            } else {
//                magazineMap.put(c, occur + 1);
//            }
//        }
//
//       for (int i = 0; i < ransomNote.length(); i++) {
//           final Character current = ransomNote.charAt(i);
//           final Integer usageTimes = magazineMap.get(current);
//           if (usageTimes == null || usageTimes == 0) {
//               return false;
//           }
//
//           magazineMap.put(current, usageTimes - 1);
//       }
//
//       return true;
//    }

    // 官方解答
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine)); // Output: false

        ransomNote = "aa";
        magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine)); // Output: false

        ransomNote = "aa";
        magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine)); // Output: true
    }
}

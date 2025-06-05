package com.rdlts.leetcode.solution;

/**
 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

 Given a string s, return true if it is a palindrome, or false otherwise.

 Example 1:

 Input: s = "A man, a plan, a canal: Panama"
 Output: true
 Explanation: "amanaplanacanalpanama" is a palindrome.
 Example 2:

 Input: s = "race a car"
 Output: false
 Explanation: "raceacar" is not a palindrome.
 Example 3:

 Input: s = " "
 Output: true
 Explanation: s is an empty string "" after removing non-alphanumeric characters.
 Since an empty string reads the same forward and backward, it is a palindrome.


 Constraints:

 1 <= s.length <= 2 * 105
 s consists only of printable ASCII characters.
 */
public class _125ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int firstIdx = 0;
        int lastIdx = s.length() - 1;

        if (firstIdx == lastIdx) {
            return true;
        }

        while (firstIdx < lastIdx) {
            if (isAlphaNumeric(s.charAt(firstIdx))) {
                if (isAlphaNumeric(s.charAt(lastIdx))) {
                    if (Character.toLowerCase(s.charAt(firstIdx)) != Character.toLowerCase(s.charAt(lastIdx))) {
                        return false;
                    }
                    firstIdx++;
                    lastIdx--;
                } else {
                    lastIdx--;
                }
            } else {
                firstIdx++;
            }
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        // 测试代码
        String s = "A man , a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println("Is the string a palindrome? " + result);

        s = "race a car";
        result = isPalindrome(s);
        System.out.println("Is the string a palindrome? " + result);

        s = " ";
        result = isPalindrome(s);
        System.out.println("Is the string a palindrome? " + result);


    }
}

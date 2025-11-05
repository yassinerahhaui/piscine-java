// package Palindrome;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            reversed.append(ch);
        }
        return s.equals(reversed.toString());
    }
}
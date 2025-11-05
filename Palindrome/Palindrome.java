// package Palindrome;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            reversed.append(ch);
        }
        return s.toLowerCase().equals(reversed.toString().toLowerCase());
    }
}
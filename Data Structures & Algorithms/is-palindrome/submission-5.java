class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        int l;
        int r = s.length() - 1;
        s = s.toLowerCase();

        for (l = 0; l < r; l++, r--) {
            while (!isAlphanumeric(s.charAt(l)) && l < r) {
                l++;
            }

            while (!isAlphanumeric(s.charAt(r)) && l < r) {
                r--;
            }

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAlphanumeric(Character c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
}

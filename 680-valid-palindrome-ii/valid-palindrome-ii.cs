public class Solution {
    public bool ValidPalindrome(string s) {
        int left = 0, right = s.Length - 1;

        while (left < right) {
            if (s[left] == s[right]) {
                left++; 
                right--;
            } else {
                return Check(s, left + 1, right) || Check(s, left, right - 1);
            }
        }
        return true;
    }

    bool Check(string s, int l, int r) {
        while (l < r) {
            if (s[l++] != s[r--]) return false;
        }
        return true;
    }
}
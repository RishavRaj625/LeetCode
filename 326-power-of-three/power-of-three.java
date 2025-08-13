class Solution {
    public boolean isPowerOfThree(int n) {
         if (n <= 0) return false; // negative numbers and zero are not powers of three
        
        while (n % 3 == 0) { // keep dividing while divisible by 3
            n /= 3;
        }
        
        return n == 1;
    }
}
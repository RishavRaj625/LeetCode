class Solution {
    public int maximum69Number (int num) {

         char[] digits = String.valueOf(num).toCharArray();
        
        // Traverse left to right, change the first '6' to '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        
        // Convert back to integer
        return Integer.parseInt(new String(digits));
    }
}
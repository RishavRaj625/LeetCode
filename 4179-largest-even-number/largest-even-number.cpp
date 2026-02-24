class Solution {
public:
    string largestEven(string s) {
        int j;
        for(j = s.size() - 1; j >= 0; j--) {
            if(s[j] == '2') break;
        }
        return s.substr(0, j + 1);
    }
};
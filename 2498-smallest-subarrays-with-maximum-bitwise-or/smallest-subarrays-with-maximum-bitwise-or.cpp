class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
         int n = nums.size();
        vector<int> answer(n, 1);
        vector<int> last_pos(32, -1);

        for (int i = n - 1; i >= 0; --i) {
            for (int b = 0; b < 32; ++b) {
                if ((nums[i] >> b) & 1) {
                    last_pos[b] = i;
                }
            }

            int farthest = i;
            for (int b = 0; b < 32; ++b) {
                if (last_pos[b] != -1) {
                    farthest = max(farthest, last_pos[b]);
                }
            }

            answer[i] = farthest - i + 1;
        }

        return answer;
    }
};
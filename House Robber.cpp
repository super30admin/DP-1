//Time Complexity- O(n)
//Space Complexity- O(1)

class Solution {
public:
    int rob(vector<int>& A) {
        int prev2 = 0, prev = 0, cur = 0;
        for(auto i : A) {
            cur = max(prev, i + prev2);
            prev2 = prev;
            prev = cur;
        }
        return cur;
    }
};
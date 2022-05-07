//Time = O(N)
//Space = O(1)

//We track the best before the ith house is robbed and rested 
//And we track the best before the ith house is rested and robbed
//And if are robbing the current house, we get more loot, else we skip and loot remains same

class Solution {
public:
    int rob(vector<int>& nums) {
        auto currentBest = 0, previousBest = 0;
        for(auto num : nums)
        {
            auto temporary = currentBest;
            currentBest = max(currentBest, previousBest + num);
            previousBest = temporary;
        }
        return currentBest;
    }
};

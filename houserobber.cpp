class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() < 2) return nums[0];//single element in the array,so return the element itself

        vector<int> maxloot(nums.size());//declare a new array to track the max loot

        maxloot[0] = nums[0];
        maxloot[1] = max(nums[0],nums[1]);//max of 1st and 2nd since you cant loot both

        for(int i = 2;i < nums.size();i++){
            maxloot[i] = max(maxloot[i-1],maxloot[i-2] + nums[i]);
            //case 1 : looting current house -> check current 'i'house value in nums and 'i-2' in maxloot
            //case 2 : skipping the current house -> check 'i-1' value in maxloot
            //final step : compare and update in maxloot
        }

        return maxloot[nums.size() - 1 ];
        //return the last element of maxloot
    }
};
//Time Complexity: O(n)
//Space Complexity:

//Run on Leetcode: Failed for a few testcases

class Solution {
    public int rob(int[] nums) {
        int amount=0;
        for(int i=0;i<nums.length;i=i+2){
            amount+=nums[i];
        }
        return amount;
    }
}

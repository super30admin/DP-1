//Brute Force Solution 
//TC = O(2^N) - exponential 

class Solution {
public:
    int rob(vector<int>& nums) {
         if(nums.size()==0) return 0;
        return helper(nums,0,0);
    }
    
    int helper(vector<int>& nums, int index, int robbed){
        //base
        //Note: we are incrementing index by 2 in choose cases - so we can exceed the nums size too
        if(index>=nums.size()) return robbed; 
        //logic
        int case1 = helper(nums,index+2,robbed+nums[index]); //choose
        int case2 = helper(nums,index+1,robbed); //dont choose
        return std::max(case1,case2);
    }
};


//DP Solution - Time complexity optimzed by removing repeating subproblem computations
//TC = O(N)
//SC = O(N)

class Solution {
public:
    int rob(vector<int>& nums) {
        int size = nums.size();
        if(size==0) return 0;
        if(size==1) return nums[0];
        vector<int> dp(size);
        
        dp[0]=nums[0];
        dp[1]= std::max(nums[0],nums[1]);
        
        for(int i=2;i<size;i++){
            dp[i] = std::max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[size-1];
    }
};


// DP Solution - We can further optimize space by using only 3 variables

class Solution {
public:
    int rob(vector<int>& nums) {
        int size = nums.size();
        if(size==0) return 0;
        if(size==1) return nums[0];
        
        int twoBehind = nums[0]; //two steps behind
        int oneBehind = std::max(nums[0],nums[1]); //one step behind
        
        for(int i=2;i<size;i++){
            int current = std::max(oneBehind, nums[i] + twoBehind);
            twoBehind = oneBehind;
            oneBehind = current;
        }
        return oneBehind;
    }
};

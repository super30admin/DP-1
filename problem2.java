//Brute Force No Memoization

// Height of the tree: No.of houses
// Time Complexity :  O(2^height)
// Space Complexity :  O(height)
// Did this code successfully run on Leetcode :  No
// Any problem you faced while coding this :  No


class BruteForce {
    int findSolution(int[] nums, int index){
        if(index>=nums.length){
            return 0;
        }
        int robThis= nums[index]+findSolution(nums,index+2);
        int dontRob= findSolution(nums,index+1);
        return Math.max(robThis,dontRob);
    }
    public int rob(int[] nums) {
        return findSolution(nums,0);
    }
}



//Memoization using Hashmap

// Time Complexity :  No.of houses
// Space Complexity :  No.of houses
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this :  No

// Top Down Approach using Memoization



class Solution {

    HashMap<Integer,Integer> dp= new HashMap<>();

    int findSolution(int[] nums, int index){

        if(index>=nums.length){
            return 0;
        }

        if(dp.containsKey(index)){
            return dp.get(index);
        }

        int robThis= nums[index]+findSolution(nums,index+2);
        int dontRob= findSolution(nums,index+1);

        dp.put(index,Math.max(robThis,dontRob));

        return dp.get(index);
    }
    public int rob(int[] nums) {
        return findSolution(nums,0);
    }
}




// Bottom Up Approach- Back to front
// TC SC O(n)

class Solution {
    public int rob(int[] nums) {
        int[] dp= new int[nums.length+2];

        for(int i=nums.length-1; i>=0; i--){
            dp[i]=Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return dp[0];
    }
}


// Bottom Up Approach- Front to Back
// TC SC O(n)

class Solution {
    public int rob(int[] nums) {
        int[] dp= new int[nums.length+2];

        for(int i=0; i<dp.length-2; i++){
            dp[i+2]=Math.max(dp[i+1],nums[i]+dp[i]);
        }
        return dp[dp.length-1];
    }
}
/**
Leet Code Submitted : YES
Space Complexity : O(N*2)
Time Complexity : O(N)
The idea is to store decisions of previous max in a two dimensional array if we are choosing the house or not
column 0 will store the max money robber will make if he/she chooses the house and column 1 will store the money robber make if he/she not choses the house
**/

class Solution {
    public int rob(int[] nums) {
        
        int max = 0;
        if(nums == null || nums.length < 1)
            return max;
        
        int[][] decision = new int[nums.length][2];
        
        decision[0][0] = nums[0];
        decision[0][1] = 0;
        
        for(int i=1; i<nums.length; i++){
            decision[i][0] = decision[i-1][1] + nums[i]; //Chosen the house
            decision[i][1] = Math.max(decision[i-1][0],decision[i-1][1]);
        }
        //return decision(nums,0,max) ; 
        return Math.max(decision[nums.length -1][0],decision[nums.length-1][1]);
    }
    
    //For Recursion
    /*int decision(int[] nums,int i,int max){
        if(i >= nums.length)
            return max;
    
        return (Math.max(decision(nums,i+2,max+nums[i]),decision(nums,i+1,max)));
        
    }*/
}
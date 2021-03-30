public class Problem2 {
    //House Robber Problem
    // Time Complexity :O(n)
    // Space Complexity :O(1) constant
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :NO


    // Your code here along with comments explaining your approach
    ///we initalize  two variables skip and take
    //at each iteration, we check if we want to take or skip
    //that variable
    public static void main(String[] args){
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums){
        if(nums == null || nums.length ==0)
            return 0;
        int skip=0, take= 0;
        for(int i = 0;i< nums.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            //if you rob this house, then consider skip of previous 
            // house and value of this house
            take = temp + nums[i];

        }
        return Math.max(skip, take);
    }
    
}

//Time Complexity: 2^nums (Exponential)
//Space Complexity: O(N) where N is the number of stack calls

//Approach: Brute Force - Recursive 

class Robber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int amount)
    {
        if(index >= nums.length) return amount;
        
        //case 0
        int case0 = helper(nums, index+1, amount);
        //case 1
        int case1 = helper(nums, index+2, amount + nums[index]);
        return Math.max(case0, case1);
    }
}


//Time Complexity: O(N) where N is the length of nums array
//Space Complexity: O(1)

//Approach: Dynamic Programming

class Robber2 {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int skip = 0; int take  = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + nums[i];
        }
        return Math.max(skip,take);
    }
}

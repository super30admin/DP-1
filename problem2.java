//Time Complexity = O(n)
//Space Complexity = O(1)


class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int skip= 0;
        int take = 0;
        for(int num:nums){
            int temp = take;
             take = num+skip;
             skip = Math.max(temp,skip);
            
        }
        return Math.max(take,skip);
    }

    }


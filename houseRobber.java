//runtime complexity O(n) ---> n is size of nums
//space complexity O(n) ---> n is size of nums
class Solution {
    public int rob(int[] nums) {
        int [][] amt = new int[nums.length][2];
        amt[0][0] = 0;
        amt[0][1] = nums[0];
        for(int i=1; i<amt.length; i++){
            
            amt[i][0] = Math.max(amt[i-1][0], amt[i-1][1]);
            amt[i][1] = amt[i-1][0] + nums[i];
        }
        return Math.max(amt[amt.length-1][0], amt[amt.length-1][1]);
        }
    }
/*
  Time Complexity: O(N), N operations on N elements
  Space Complexity: O(N); Extra N memory to store N elements of nums
*/

/* 
Approach: 
  1. Find the length of the nums array = n
  2. Create the new array maxAmount with the length equal to n + 1 which stores the sum of the 
     money robbed comparing the house robbing combinations
  3. If there is no house present then the value returned will be 0;
  4. Store 0 in the last index of maxAmount
  5. Store the last element of nums in the second last index of maxAmount
  6. Iterate from n - 2 to 0, execute
     maxAmount[i] = Math.max(maxAmount[i + 1], (maxAmount[i + 2] + nums[i]))
  7. At the end of the loop the result will be stored at the first index of maxAmount array
  8. Return maxAmount[0];   
*/



class RobHouse {
    public int rob(int[] nums) {
        int n = nums.length; 
        int[] maxAmount = new int[ n + 1];
        maxAmount[n] = 0;
        maxAmount[ n - 1] = nums[n - 1]; 
        if(n == 0) return 0;
        for(int  i = n - 2 ; i >= 0 ; i--){
            maxAmount[i] = Math.max(maxAmount[i + 1], (maxAmount[i + 2] + nums[i]));
        }
        return maxAmount[0];
        
    }
}
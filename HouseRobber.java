

/* With DP
 * T(C) : O(n) for n unique sub problems. we do eliminate repetitive calculations for repetitive same sub problems
 * S(C) : O(n) input is an array O[n] so it donesnt count but dp[n] array is auxiliary.
 * 
 * Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 * 
 * 
 * 
 * 
 * */

public class HouseRobber {


		public static int rob(int[] nums) {
		//useless brute force approach
		    //i tried to get sum of odd and even sequences and //returning max of that but it fails when you have [2,1,1,2]
		    //then i realized that i would need to do all //combinations which was bad.
//		 		int fsum=0; int ssum = 0;
//		 		System.out.println("fsum start: "+ fsum);
//		 		System.out.println("ssum start: "+ ssum);
//		 		for (int i = 0; i < nums.length; i++ ) {
//		 			System.out.print("index :" +i);
//		 			System.out.print("\tnums : "+ nums[i]);
//		 			System.out.print("\tfsum: "+ fsum+"\n");
						
//		 			fsum += nums[i++];
//		 		}
//		 		for (int i = 1; i < nums.length; i++ ) {
//		 			System.out.print("index :" +i);
//		 			System.out.print("\tnums : "+ nums[i]);
//		 			System.out.print("\tfsum: "+ fsum+"\n");
						
//		 			ssum += nums[i++];
//		 		}
				
//		 		if (fsum > ssum)
//		 		return fsum;
//		 		else
//		 			return ssum;
				
		  //Solution with DP   
		//not happy coz i had to learn DP then solve this
		//did not come to me like an epiphany    
		    //i did come up with the the accumulation of max values
			//for memoization idea though but had to research to solve it
		    /*
		     * pseudocode
		     * 
		     * Logic Explanation below
		     * 
		     * compare max value of (sum of i and i-2, i-1)
		     *  for (int i = 2; i<dp.length;i++){
		        dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
		    }
		     * 
		     * 
		     * index:       0    1     2     3     	4     5
		     * 
		     * nums array:  1    2     2     3     	2     1
		     * 
		     * dp array:    1    2     3     5    	5     6
		     * 
		     * at index 2 look at nums array: max (nums[0]+nums[2] :  1 + 2, dp[1] : 2) makes dp[2] = 3
		     * 
		     * dp[2] = max(3,2)
		     * dp[3] = max(5,3)
		     * dp[4] = max(5,5)
		     * dp[5] = max(6,5)
		     * 
		     * 
		     * 
		     */
			//if only one item in array then return that item.
		    if(nums.length == 1){
		        return nums[0];
		    }
		    
		    int dp[] = new int[nums.length];
		    dp[0] = nums[0];
		    dp[1] = Math.max(nums[0],nums[1]);
		    for (int i = 2; i<dp.length;i++){
		        dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
		    }
		    return dp[nums.length-1];

		    
			}
		}
	










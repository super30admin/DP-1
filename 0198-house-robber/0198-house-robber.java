/*
Approach:
We are given an array nums where each element represents the amount of money at each house.
Constraint: We cannot rob 2 adjusant houses

Solution(Top-Down Dynamic Programming with Memoization):
- At each house 'i', we decide between:
 1. Robbing house 'i' -> we add 'nums[i]' and skip to house 'i+2'
 2. Skipping house 'i' -> we go directly to 'i+1'
-We use recursion to explore both options and store (memoize) the result to cache
to avoid redundant calculations for the same subproblem.

 */
/*
Steps:
1. Array to store intermediate results(memoization)
2. Step1: Initialize memo array of fixed size (100 is enough for constraints)
Fill it with -1 to indcate that values are not yet computed
3. Step 2: Start the recursive function from the first house(index 0)
4. Recursive function to compute the maximum money that can be robbed from index i onwards
5. Base case 1: If the index goes beyond the last house, return 0 (nothing to rob)
6. Base Case 2: If already computed for this index, return cached value.
7. Step 3: Recursive Cases:-
8. Option 1: Skip current house and rob from the next house
9. Option 2: Rob current house, add its money, and skip to i+2
10. Step4: Take the maximum of both choices and store it in memo
11. Return the result


*/

class Solution {

    private int[] memo;

    public int rob(int[] nums) {
        this.memo = new int[100];
        Arrays.fill(this.memo,-1);

        return this.robFrom(0, nums); 
        
    }

    private int robFrom(int i, int[] nums){
        if(i>=nums.length){
            return 0;
        }

        if(this.memo[i]>-1){
            return this.memo[i];
        }


        int skipCurrent = robFrom(i+1, nums);

        int robCurrent = nums[i] + robFrom(i+2, nums);

        int result = Math.max(skipCurrent, robCurrent);

        this.memo[i] = result;

        return result;
    }

}

/**
Time Complexity: O(n)

1. Each house index 'i' is visited at most once due to memoization.
2. For each index, we do constant work(2 recursive calls, cached after first time)
3. So total time is linear in number of houses.


Space Complexity: O(n)

1. The memo array stores value per index (O(n) space)
2. Additionally, recursion stack takes up to O(n) space in the worst case.
(due to max recursion dept being equal to number of houses.)
 */
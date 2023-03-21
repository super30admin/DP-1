class Solution {
    
	Time: O(N)
    public int rob(int[] nums) {
        
            HashMap<Integer, Integer> cache = new HashMap<>();
        int index_zero = dfs(nums, 0, cache);
        int index_one = dfs(nums, 1, cache);
        

	return Math.max(index_zero, index_one);

    
    }

    public int dfs(int[] nums, int index, HashMap<Integer, Integer>cache){

	    if(index == nums.length){
		    return 0;
        }

        if(cache.containsKey(index)){
            return cache.get(index);
    }
	
    int max_answer = 0;	
        for(int i = index + 2; i < nums.length; i++){
            
            max_answer = Math.max(max_answer, dfs(nums, i, cache));

    }
    cache.put(index, max_answer + nums[index]);
    return max_answer + nums[index];

        
    }

}
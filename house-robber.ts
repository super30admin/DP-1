// Time complexity- O(n), n= number of houses
// Space complecity - O(1)
function robHouse(nums: number[]): number {
	let rob1 = 0;
	let rob2 = 0;

	// [rob1,rob2,i,i+1, i+2 ... nums.length -1]
	for (let i = 0; i < nums.length; i++) {
		let temp = Math.max(nums[i] + rob1, rob2);
		rob1 = rob2;
		rob2 = temp;
	}

	return rob2;
}

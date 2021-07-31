# Time Complexity: O(N) Looping over the array once
# Space Complexity: O(N), we use an extra array for score.
def rob(nums: list[int]) -> int:
    score = [0,0]
    for i in range(len(nums)-1,-1,-1):
        score.insert(0,max(score[0],nums[i] + score[1]))
    return score[0]
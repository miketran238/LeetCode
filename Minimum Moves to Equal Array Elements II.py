class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        nums.sort()
        if len(nums)%2!=0:
            sum1=0
            mid=nums[len(nums)//2]
            for i in range(len(nums)):
                sum1=sum1+abs(mid-nums[i])
            return sum1
        else:
            sum_left=0
            sum_right=0
            mid_right=nums[len(nums)//2]
            mid_left=nums[len(nums)//2-1]
            for i in range(len(nums)):
                sum_left+=abs(mid_left-nums[i])
                sum_right+=abs(mid_right-nums[i])
            return min(sum_left,sum_right)

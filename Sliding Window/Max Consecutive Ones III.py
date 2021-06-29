class Solution:
    def longestOnes(self, nums: List[int], K: int) -> int:
        i,res = 0,0
        for j in range(len(nums)):
            if nums[j] == 0:
                K -= 1
            if K >= 0:
                res = max(res, j - i + 1)
            while K < 0:
                if nums[i] == 0:
                    K += 1
                i += 1
        return res

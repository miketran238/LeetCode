class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        res = 0
        i = 0
        hmap = defaultdict(int)
        cur = 0
        for j in range(0, len(nums)):
            while nums[j] in hmap:
                hmap[nums[i]] -= 1
                if hmap[nums[i]] == 0:
                    del hmap[nums[i]]
                cur -= nums[i]
                i += 1
            hmap[nums[j]] += 1
            cur += nums[j]
            res = max(res, cur)
        return res

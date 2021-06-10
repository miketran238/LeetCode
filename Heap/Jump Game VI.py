class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        heap = [(-nums[0],0)] # first item is the value, second item is index 
        result = nums[0]  # handles case where there is just 1 item
        
        for i in range(1,len(nums)):
            #print(heap)
            #it doesn't matter if the out-of-bound index is not at the peak of the heap,
            #we only need to pop it when it is at the peak position
            while heap[0][1] < i-k:
                heapq.heappop(heap)
            result = nums[i] - heap[0][0]
            heapq.heappush(heap, (-result,i))

        return result

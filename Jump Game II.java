class Solution {
    public int jump(int[] nums) {
        LinkedList<Integer> pq = new LinkedList<>(); //[numberOf Jump, index]
        pq.add(0); 
        int[] memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        int maxIdx = 0;
        while ( ! pq.isEmpty() ) {
            int idx = pq.pop(), jump = memo[idx];
            // System.out.println(idx + " " + jump);
            if ( idx == nums.length - 1) return memo[idx];
            for(int i = 1; i <= nums[idx] && i < nums.length-idx; i++) //finding the next jump
            {
                if ( idx + i < maxIdx ) continue;
                maxIdx = idx + i;
                // System.out.println("Here " + (idx+i) + " Old value  " + memo[idx+i] + " New value " + jump);
                if (memo[idx + i] > jump + 1) {
                    memo[idx + i] = jump + 1;
                    pq.add( idx + i );
                }
            }

        }
        return -1;
    }
}

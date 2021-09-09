/*
Day 01- Array Nesting
A zero-indexed array A of length N contains all integers from 0 to N-1.
Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
Suppose the first element in S starts with the selection of element A[i] of index = i,
the next element in S should be A[A[i]], and then A[A[A[i]]]…
By that analogy, we stop adding right before a duplicate element occurs in S.
Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 6
Explanation:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
Note:
N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of A is an integer within the range [0, N-1].
 */
public class Day01 {
    public static void main(String[] args) throws Exception {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(nums));
    }


    /**
     * Approach 1: Brute Force [Time Limit Exceeded]
     */
    public class Solution {
        public int arrayNesting(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                }
                while (start != nums[i]);
                res = Math.max(res, count);

            }
            return res;
        }
    }

    /**
     *  Approach 2: Using Visited Array
     *  Requires understanding the pattern of the cycle
     *  There's must be a cycle like nums[0],nums[2],nums[5] and back to nums[0].
     *  This cycle will not interfere with others,eg nums[1]
     *  After understand this, we can apply
     */
    public static int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    /**
     * Approach 3: Without Using Extra Space
     * Algorithm
     * In the last approach, the visited array is used just to keep a track of the elements of the array which have already been visited.
     * Instead of making use of a separate array to keep track of the same, we can mark the visited elements in the original array nums itself.
     * Since, the range of the elements can only be between 1 to 20,000,
     * we can put a very large integer value Integer.MAX_VALUE at the position which has been visited.
     * The rest process of traversals remains the same as in the last approach.
     *
     * Complexity Analysis
     *  Time complexity : O(n). Every element of the nums array will be considered at most once.
     *  Space complexity : O(1). Constant Space is used.
     */
    class Solution {
        public int arrayNesting(int[] nums) {
            int rst = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != Integer.MAX_VALUE) {
                    int start = nums[i], count = 0;
                    while (nums[start] != Integer.MAX_VALUE) {
                        int temp = start;
                        start = nums[start];
                        count++;
                        nums[temp] = Integer.MAX_VALUE;
                    }

                    rst = Math.max(rst, count);
                }
            }
            return rst;
        }
    }
}

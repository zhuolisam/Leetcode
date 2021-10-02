//Partition to K Equal Sum Subsets
public class Day30 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i : nums)
            sum += i;

        if (sum % k != 0)
            return false;       //this is one important characteristics. The result of sum divide by parts must be equal

        boolean[] visited = new boolean[nums.length];

        return dfs(nums, k, nums.length - 1, 0, sum / k, visited); //start from the largest number
    }

    private boolean dfs(int[] nums, int k, int idx, int sum, int target, boolean[] visited) {
        if (k == 0) return true;

        if (sum == target) {
            return dfs(nums, k - 1, nums.length - 1, 0, target, visited);
        }

        for (int i = idx; i >= 0; i--) {
            if (visited[i] || nums[i] + sum > target)
                continue;

            visited[i] = true;  //if not visited, then can try

            if (dfs(nums, k, i - 1, sum + nums[i], target, visited))
                return true;

            visited[i] = false; //if tried, but failed, then put it back to false
        }
        return false; //failed finding pairs, return false
    }
}

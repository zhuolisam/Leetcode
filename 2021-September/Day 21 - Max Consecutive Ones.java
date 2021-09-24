public class Day21 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int bin : nums) {
            if (bin == 1) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                if (max >= nums.length) {
                    return max;
                }
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}

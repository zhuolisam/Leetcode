//Sort Array By Parity II
public class Day28 {
    /*
    Approach 1
     */
    public int[] sortArrayByParityII(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length; i += 2) //we only check the numbers on even place
            if (nums[i] % 2 == 1) {             //if the number on even place is not even, then find a substitution from odd place
                while (nums[j] % 2 == 1)        //we find its substitution from infront, if the number on odd place is already odd, don't touch it and find the next one
                    j += 2;

                // Swap nums[i] and nums[j] after found its substitution
                int tmp = nums[i];              
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        return nums;
    }
    
    /*
    Approach 2: Separate even and odd number then add them alternately into one list
     */
}

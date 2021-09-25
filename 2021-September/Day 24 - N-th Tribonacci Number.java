//Day 24 - N-th Tribonacci Number
public class Day24 {

    /**
     * Approach1: Dynamic Programming
     */
    public int tribonacci(int n) {
        int[] f = new int[38];  //since the problem limits 0<=n<=37
        f[0] = 0;
        f[1] = f[2] = 1;

        for (int i = 3; i < n+1 || i < f.length; i++) {
            f[i] = f[i-1] + f[i-2] +f[i-3];
        }

        return f[n];
    }


    /**
     * Approach2: Recursion
     */
    public int tribonacci2(int n) {
        if (n <= 0)
            return 0;

        if (n <= 2)
            return 1;

        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

  
}

public class Day22 {
    /**
     * Approach 1： Dynamic Programming
     */
    public static int maxLength(List<String> arr) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);   //dynamic programming, keep a record of each pairingss
        int res = 0; //count of highest length
        for (String s : arr) {
            int a = 0, dup = 0;

            //this loop is to check whether a string contains duplicate char
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a'); //a will store the char mask of a string, eg for 'un',the mask is 100000010000000000000， which is 1056768 in decimal
            }

            if (dup > 0) continue; //is this string contains duplicate(dup > 0) then skip

            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0) continue;  //condition:if mask conflicts, then skip
                dp.add(dp.get(i) | a);   //add the mask of current string into List
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));  //count total 1's, which means total non-duplicate char
            }
        }
        return res;
    }
}

/**
 * Approach 2： DFS
 */
class Solution {
    private int result = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)    return 0;

        dfs(arr, "", 0);
        return result;
    }

    private void dfs(List<String> arr, String path, int idx) {
        boolean isUniqueChar = isUniqueChars(path);

        if (isUniqueChar) {
            result = Math.max(path.length(), result);
        }

        if (idx == arr.size() || !isUniqueChar) {
            return;
        }

        for (int i = idx; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }

    }

    private boolean isUniqueChars(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

}

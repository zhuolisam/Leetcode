public class Day25 {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList();
        boolean[][][] visited = new boolean[n][m][k + 1];
        visited[0][0][0] = true;
        q.offer(new int[]{0, 0, 0});
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] info = q.poll();
                int r = info[0];
                int c = info[1];
                int curK = info[2];

                if (r == n - 1 && c == m - 1) {
                    return res;
                }

                for (int[] dir : dirs) {  //filling in the next possible path
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;
                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {

                        /*
                        this condition is the main point
                        if curK=nextK is now 0, means it is in the original track,
                        if next is obstacle, then it makes nextK = 1, which means divert to other track(which cleared the obstacle)
                        if nextK is already 1 and next is not obstacle, then nextK will remain 1, which means the diverted track
                        if nextK is already 1 and next is obstacle, then nextK will become 2, a diverted track again(which cleared the obstacle)
                         */
                        if (grid[nextR][nextC] == 1) {
                            nextK++;
                        }

                        /*
                        this condition is the main point
                        if nextK is/became 1, then it means is is in track 1(cleared one obstacle)
                        if track exceeded k, then not valid(cannot clear more than k obstacle), the next path will not be added
                         */
                        if (nextK <= k && !visited[nextR][nextC][nextK]) {
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new int[]{nextR, nextC, nextK});
                        }

                        //think this like a 3d grid, when it cleared one obstacle, it creates a new track in the z-axis

                    }
                }
            }
            res++; //什么都没有就走一步
        }
        return -1;
    }
}

public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        ArrayList<Integer> minPath = triangle.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                minPath.set(j, triangle.get(i).get(j)
                    + Math.min(minPath.get(j), minPath.get(j + 1)));
            }
        }
        return minPath.get(0);
    }
}
import java.util.Arrays;
import java.util.ArrayList;

public class MinimumAdjustmentCost {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        int[] pre = new int[100];
        int[] cur = new int[100];
        for (int v = 1; v <= 100; v++) {
            pre[v - 1] = Math.abs(v - A.get(0));
        }
        for (int i = 2; i <= A.size(); i++) {
            cur = new int[100];
            Arrays.fill(cur, Integer.MAX_VALUE);
            for (int v = 1; v <= 100; v++) {
                int start = Math.max(1, v - target);
                int end = Math.min(100, v + target);
                for (int k = start; k <= end; k++) {
                    cur[v - 1] = Math.min(cur[v - 1], 
                        Math.abs(A.get(i - 1) - v) + pre[k - 1]);
                }
            }
            pre = cur;
        }
        int minCost = Integer.MAX_VALUE;
        for (int cost : cur) {
            minCost = Math.min(minCost, cost);
        }
        return minCost;
    }

    public static void main(String[] args) {
        MinimumAdjustmentCost test = new MinimumAdjustmentCost();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(12,3,7,4,5,13,2,8,4,7,6,5,7));
        int target = 2;
        System.out.println(test.MinAdjustmentCost(A, target));
    }
}
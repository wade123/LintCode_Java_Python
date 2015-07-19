public class SearchForARange {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.size() == 0) {
            result.add(-1);
            result.add(-1);
            return result;
        }
        int start = 0;
        int end = A.size() - 1;
        int leftBound;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A.get(start) == target) {
            leftBound = start;
        } else if (A.get(end) == target) {
            leftBound = end;
        } else {
            result.add(-1);
            result.add(-1);
            return result;
        }

        int low = 0;
        int high = A.size() - 1;
        int rightBound;
        while (low + 1 < high) {
            int middle = low + (high - low) / 2;
            if (A.get(middle) <= target) {
                low = middle;
            } else {
                high = middle;
            }
        }
        rightBound = (A.get(high) == target) ? high : low;
        result.add(leftBound);
        result.add(rightBound);
        return result;
    }
}
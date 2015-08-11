class MergeSortedArrayTwo {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if ((A == null || A.size() == 0) && (B == null || B.size() == 0)) {
            return result;
        } else if (A == null || A.size() == 0) {
            return B;
        } else if (B == null || B.size() == 0) {
            return A;
        }
        int p = 0;
        int q = 0;
        while (p < A.size() && q < B.size()) {
            if (A.get(p) < B.get(q)) {
                result.add(A.get(p++));
            } else {
                result.add(B.get(q++));
            }
        }
        while (p < A.size()) {
            result.add(A.get(p++));
        }
        while (q < B.size()) {
            result.add(B.get(q++));
        }
        return result;
    }
}
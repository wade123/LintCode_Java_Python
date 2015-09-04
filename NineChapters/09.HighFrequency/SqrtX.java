class SqrtX {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
// binary search: sqrt(n) <= (n +  1) / 2
    public int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x / 2 + 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left <= x / left && (left + 1) > x / (left + 1)) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        SqrtX test = new SqrtX();
        System.out.println(test.sqrt(999999999));
    }
}

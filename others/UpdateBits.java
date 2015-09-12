class UpdateBits {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        int mask = 1;
        for (int k = 0; k < j - i; k++) {
            mask = (mask << 1) + 1;
        }
        mask <<= i;
        n &= (~mask);
        return n | (m << i);
    }

    public static void main(String[] args) {
        UpdateBits test = new UpdateBits();
        System.out.println(test.updateBits(-2147483648,-1,0,31));
    }
}


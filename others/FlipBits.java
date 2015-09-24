class FlipBits {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (a & 1) ^ (b & 1);
            a >>= 1;
            b >>= 1;
        }
        return count;
    }

    public static int bitSwapRequired(int a, int b) {
        int xor = a ^ b;
        int step = 0;
        for (int i = 0; i < 32; i++) {
            step += xor & 1;
            xor >>= 1;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(FlipBits.bitSwapRequired(1, -1));
    }
}
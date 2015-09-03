class FastPower {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (b == 1) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return a % b;
        }
        long half = fastPower(a, b, n / 2);
        half = (half * half) % b;
        if (n % 2 == 0) {
            return (int) half; 
        } else {
            half = (half * a) % b;
            return (int) half;
        }
    }
};

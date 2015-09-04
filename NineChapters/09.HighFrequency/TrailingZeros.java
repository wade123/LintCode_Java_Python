class TrailingZeros {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long result = 0;
        while (n >= 5) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
};
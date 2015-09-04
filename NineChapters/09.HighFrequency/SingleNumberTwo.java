public class SingleNumberTwo {
    /**
     * @param A : An integer array
     * @return : An integer 
     */
    public int singleNumberII(int[] A) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int number : A) {
            twos |= ones & number;
            ones ^= number;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
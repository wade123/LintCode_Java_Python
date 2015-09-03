class HashFunction {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        if (key == null || key.length == 0) {
            return 0;
        }
        int hashValue = 0;
        int length = key.length;
        for (int i = 0; i < length; i++) {
            hashValue = hashValue * 33 + key[i];
            hashValue %= HASH_SIZE;
        }
        return hashValue;
    }

    public static void main(String[] args) {
        HashFunction test = new HashFunction();
        char[] key = "ubuntu".toCharArray();
        System.out.println(test.hashCode(key, 1007));
    }
};

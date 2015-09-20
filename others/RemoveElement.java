public class RemoveElement {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0;
        for (int element : A) {
            if (element != elem) {
                A[i] = element;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();
        int[] A = {1,2,3};
        int elem = 1;
        System.out.println(test.removeElement(A, elem));
    }
}


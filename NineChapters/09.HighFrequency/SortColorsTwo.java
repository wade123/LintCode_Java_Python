import java.util.Arrays;

class SortColorsTwo {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int left = 1;
        int right = k;
        int start = 0;
        int end = colors.length - 1;
        while (left < right) {
            int i = start;
            while (i <= end) {
                if (colors[i] == left) {
                    swap(colors, i, start);
                    i++;
                    start++;
                } else if (colors[i] == right) {
                    swap(colors, i, end);
                    end--;
                } else {
                    i++;
                }
            }
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColorsTwo test = new SortColorsTwo();
        int[] colors = {3, 2, 4, 2, 1, 3, 4, 1};
        int k = 4;
        test.sortColors2(colors, k);
        System.out.println(Arrays.toString(colors));
    }
}
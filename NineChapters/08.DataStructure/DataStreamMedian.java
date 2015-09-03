import java.util.*;

public class DataStreamMedian {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        } 
        int length = nums.length;
        int[] median = new int[length];
        Queue<Integer> minHeap = new PriorityQueue<>(10);
        Queue<Integer> maxHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
        for (int i = 0; i < length; i++) {
            if (minHeap.size() == maxHeap.size()) {
                if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                    maxHeap.offer(nums[i]);
                } else {
                    if (nums[i] <= minHeap.peek()) {
                        maxHeap.offer(nums[i]);
                    } else {
                        maxHeap.offer(minHeap.poll());
                        minHeap.offer(nums[i]);
                    }
                }
            } else {
                if (nums[i] >= maxHeap.peek()) {
                    minHeap.offer(nums[i]);
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(nums[i]);
                }
            }
            median[i] = maxHeap.peek();
        }
        return median;
    }

    public static void main(String[] args) {
        DataStreamMedian test = new DataStreamMedian();
        int[] nums = {4, 5, 1, 3, 2, 6, 0};
        System.out.println(Arrays.toString(test.medianII(nums)));
        
    }
}
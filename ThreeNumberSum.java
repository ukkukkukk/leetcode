import java.util.*;

class Program {
    public static List < Integer[] > threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        List < Integer[] > list = new ArrayList < Integer[] > ();

        for (int i = 0; i < array.length - 2; i++) {
            int start = i + 1;
            int end = array.length - 1;

            while (start < end) {
                int currentSum = array[i] + array[start] + array[end];
                if (currentSum == targetSum) {
                    Integer[] result = new Integer[] {
                        array[i], array[start], array[end]
                    };
                    list.add(result);
                    start++;
                    end--;
                } else if (currentSum > targetSum)
                    end--;
                else if (currentSum < targetSum)
                    start++;

            }
        }

        return list;
    }
}
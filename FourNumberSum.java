import java.util.*;

class Program {
    public static List < Integer[] > fourNumberSum(int[] array, int targetSum) {

        Hashtable < Integer, ArrayList < ArrayList < Integer >>> table = new Hashtable < Integer, ArrayList < ArrayList < Integer >>> ();

        ArrayList < Integer[] > results = new ArrayList < Integer[] > ();

        for (int i = 0; i < array.length; i++) {
            for (int y = i + 1; y < array.length; y++) {
                int sumOfPair = array[i] + array[y];

                int target = targetSum - sumOfPair;

                if (table.containsKey(target)) {
                    ArrayList < ArrayList < Integer >> targetPairs = table.get(target);

                    for (ArrayList < Integer > pair: targetPairs) {

                        ArrayList < Integer > result = new ArrayList < Integer > (pair);
                        result.add(array[i]);
                        result.add(array[y]);

                        results.add(result.toArray(new Integer[0]));
                    }
                }
            }

            //if you go through array in single pass and generate pairs to add to table, then you won't have duplicates

            for (int y = i - 1; y >= 0; y--) {
                int sumToAdd = array[i] + array[y];

                ArrayList < ArrayList < Integer >> list;

                ArrayList < Integer > pair = new ArrayList < Integer > ();
                pair.add(array[i]);
                pair.add(array[y]);

                if (table.containsKey(sumToAdd)) {
                    list = table.get(sumToAdd);
                } else {
                    list = new ArrayList < ArrayList < Integer >> ();
                }
                list.add(pair);
                table.put(sumToAdd, list);
            }
        }

        return results;

    }
}
import java.util.*;

class Program {
    public static List < List < Integer >> getPermutations(List < Integer > array) {
        // Write your code here.
        List < Integer > currentPermutation = new ArrayList < Integer > ();
        List < Integer > visitedIndices = new ArrayList < Integer > ();
        List < List < Integer >> result = new ArrayList < List < Integer >> ();

        getPermutations(array, result, visitedIndices, currentPermutation);

        return result;

    }

    public static void getPermutations(List < Integer > array, List < List < Integer >> result, List < Integer > visitedIndices, List < Integer > currentPermutation) {

        if (visitedIndices.size() == array.size()) {
            if (array.size() != 0)
                result.add(currentPermutation);

            return;
        }

        for (int i = 0; i < array.size(); i++) {
            if (visitedIndices.contains(i))
                continue;

            List < Integer > currentPermutationNew = new ArrayList < Integer > (currentPermutation);
            List < Integer > visitedIndicesNew = new ArrayList < Integer > (visitedIndices);

            currentPermutationNew.add(array.get(i));
            visitedIndicesNew.add(i);

            getPermutations(array, result, visitedIndicesNew, currentPermutationNew);

        }

        return;

    }

}
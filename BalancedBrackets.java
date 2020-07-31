import java.util.*;

class Program {
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Hashtable < Character, Character > lookUpClosingBracket = new Hashtable < Character, Character > ();
        lookUpClosingBracket.put('{', '}');
        lookUpClosingBracket.put('(', ')');
        lookUpClosingBracket.put('[', ']');

        Stack < Character > stack = new Stack < Character > ();

        for (int i = 0; i < str.length(); i++) {
            char currentBracket = str.charAt(i);

            if (currentBracket == '{' || currentBracket == '(' || currentBracket == '[')
                stack.push(currentBracket);
            else if (currentBracket == '}' || currentBracket == ')' || currentBracket == ']') {
                if (stack.isEmpty())
                    return false;

                char openingBracket = (Character) stack.pop();

                char expectedClosingBracket = lookUpClosingBracket.get(openingBracket);

                if (currentBracket != expectedClosingBracket)
                    return false;
            }

        }

        if (!stack.isEmpty())
            return false;

        return true;
    }
}
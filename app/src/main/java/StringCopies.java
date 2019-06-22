/**
 * 2. Given a string and a non-empty substring sub, compute recursively if at least n copies
 *  of sub appear in the string somewhere, possibly with overlapping. N will be non-negative.
 *
 *         strCopies("catcowcat", "cat", 2) → true
 *         strCopies("catcowcat", "cow", 2) → false
 *         strCopies("catcowcat", "cow", 1) → true
 */

public class StringCopies {
    public static void main(String[] args) {

        int testStr1 = strCopies("catcowscocatcows", "cows");   // 2 occurrences
        int testStr2 = strCopies("tigerbeertigtigertiger", "tiger");    // 3 occurrences
        int testStr3 = strCopies("catcowcats", "cat"); // 2 occurrences
        int testStr4 = strCopies("cat", "cats"); // 0 occurrences

        if(testStr1 == 2)
            System.out.println("True");
        else
            System.out.println("False");

        if(testStr2 == 3)
            System.out.println("True");
        else
            System.out.println("False");

        // should print false
        if(testStr3 == 1)
            System.out.println("True");
        else
            System.out.println("False");

        if(testStr4 == 0)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static int strCopies(String s1, String s2) {
        // if the length of our first string if 0, or if it's less than the length of our second, return 0;
        if (s1.length() == 0 || s1.length() < s2.length()) {
            return 0;
        }

        // replace first occurrence
        if (s1.contains(s2)) {
            String result = s1.replaceFirst(s2, "");
            return 1 + strCopies(result, s2);
        }
        else{
            return 0;
        }
    }
}

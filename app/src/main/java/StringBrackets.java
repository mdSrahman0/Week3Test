import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 1. Create a program which checks if the string has the correct order of parenthesis/brackets.
 * ({})[] = true, []{]}[ = false
*/

public class StringBrackets {
    public static void main(String[] args) {

        boolean balanced = false;
        String s = "({})[()]";

        balanced = isBalanced(s);

        if(balanced){
            System.out.println("Balanced");
        }
        if(!balanced){
            System.out.println("Not Balanced");
        }
    } // end main

    // isBalanced returns true if the string contains the correct order of
    // parenthesis/brackets
    public static boolean isBalanced(String str) {

        char[] c = str.toCharArray();

        // we implement a stack (first in, last out). Store the
        Stack stack = new Stack(c);

        // loop thru the char array
        for (int i = 0; i < c.length; i++) {

            // if the first char is starting paren, push it to stack
            if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
            }

            // is the char an ending paren?
            if (c[i] == ')' || c[i] == '}' || c[i] == ']') {

                // if there is an ending paren with no opening, return false
                if (stack.isEmpty()) {
                    return false;
                }

                // compare our current element to the element
                // on top of the stack. if they're an open and close pair, pop that element
                // and continue with for loop
                else {
                    if(stack.peek() == '(' && c[i] == ')') {
                        stack.pop();
                    } else if (stack.peek() == '{' && c[i] == '}') {
                        stack.pop();
                    } else if (stack.peek() == '[' && c[i] == ']') {
                        stack.pop();
                    }
                }
            } // end outer if
        } // end massive for loop

        if (stack.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    } // end isBalanced
} // end class

    // an inner stack class for working with character arrays
    class Stack {

        private char[] charArray;
        private int stackSize;
        private int top = -1; // -1 means stack is empty

        public Stack(char[] c) {
            stackSize = c.length;
            charArray = new char[c.length];
        }

        // check if the stack hasn't exceeded the stacksize. Only then
        // can we add an element to the top.
        public void push(char input) {
            if (top + 1 < stackSize) {
                top++;
                charArray[top] = input; // place that index at the top index
            }
        }

        // pop the top element from the stack
        public char pop() {
            if (top >= 0) {
                // return the top element, then decrement top value
                return charArray[top--];
            } else {
                System.out.println("Stack is empty");
                return '0';
            }
        }

        public boolean isEmpty() {
            if (top == -1)
                return true;
            else
                return false;
        }

        public char peek() {
            return charArray[top];
        }
}

package chapter.three;

/*
    Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary
    stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the
    following operations: push, pop, peek, and isEmpty.
 */
public class Problem5 {

    // O(n^2) time in worst case where stack sorted in reverse order
    // O(n) space for temp stack
    public static Stack sort(Stack input) {
        Stack temp = new Stack();
        while (!input.isEmpty()) {
            int cur = input.pop();
            if (!temp.isEmpty() && cur > temp.peek()) {
                while (!temp.isEmpty() && cur > temp.peek()) {
                    input.push(temp.pop());
                }
            }
            temp.push(cur);
        }
        return temp;
    }
}

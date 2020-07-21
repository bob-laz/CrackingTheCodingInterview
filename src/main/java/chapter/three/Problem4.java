package chapter.three;

/*
    Implement a MyQueue class which implements a queue using two stacks.
 */
public class Problem4 {

    static class MyQueue {
        Stack forward, reverse;

        public MyQueue() {
            forward = new Stack();
            reverse = new Stack();
        }

        public void add(int data) {
            forward.push(data);
        }

        public int remove() {
            shiftStacks();
            return reverse.pop();
        }

        public int peek() {
            shiftStacks();
            return reverse.peek();
        }

        public boolean isEmpty() {
            return forward.isEmpty() && reverse.isEmpty();
        }

        private void shiftStacks() {
            if (reverse.isEmpty()) {
                while (!forward.isEmpty()) {
                    reverse.push(forward.pop());
                }
            }
        }
    }
}

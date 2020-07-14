package chapter.three;

import java.util.EmptyStackException;

/*
    Describe how you could use a single array to implement three stacks.
 */
public class Problem1 {

    static class MultiStack {
        private final int[] sizes;
        private final int[] stacks;
        private final int stackSize;
        private final int numStacks = 3;

        public MultiStack(int stackSize) {
            stacks = new int[3 * stackSize];
            sizes = new int[numStacks];
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int data) {
            checkStackNum(stackNum);
            if (isFull(stackNum)) {
                throw new IllegalStateException("Stack is full");
            }
            int index = sizes[stackNum] + stackNum * stackSize;
            stacks[index] = data;
            sizes[stackNum]++;
        }

        public int pop(int stackNum) {
            checkStackNum(stackNum);
            if (isEmpty(stackNum)) {
                throw new EmptyStackException();
            }
            sizes[stackNum]--;
            int index = sizes[stackNum] + stackNum * stackSize;
            return stacks[index];
        }

        public int peek(int stackNum) {
            checkStackNum(stackNum);
            if (isEmpty(stackNum)) {
                throw new EmptyStackException();
            }
            int index = sizes[stackNum] - 1 + stackNum * stackSize;
            return stacks[index];
        }

        public boolean isFull(int stackNum) {
            checkStackNum(stackNum);
            return sizes[stackNum] == stackSize;
        }

        public boolean isEmpty(int stackNum) {
            checkStackNum(stackNum);
            return sizes[stackNum] == 0;
        }

        private void checkStackNum(int stackNum) {
            if (stackNum >= numStacks) {
                throw new IndexOutOfBoundsException("stack number " + stackNum + " does not exist. Indexing is zero based");
            }
        }
    }
}

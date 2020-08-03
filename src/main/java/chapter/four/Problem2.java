package chapter.four;

import java.util.Arrays;

/*
 Given a sorted (increasing order) array with unique integer elements, write an algorithm to create
 a binary search tree with minimal height.
*/
public class Problem2 extends BinarySearchTree {

  // run time O(n*log(n)) since we must iterate over the array with n elements
  // and each insertion takes O(log(n)). Inefficient solution, but this was the first solution I
  // came up with. This also creates copies of the array which takes O(n) time, possibly making this
  // solution O(n^2*log(n)), not totally sure.
  // O(1) space, no additional space used
  public void insertMinimalTree(int[] sortedArray) {
    int length = sortedArray.length;
    if (length == 1) {
      insert(sortedArray[0]);
    } else if (length > 1) {
      insert(sortedArray[length / 2]);
      insertMinimalTree(Arrays.copyOfRange(sortedArray, 0, length / 2));
      insertMinimalTree(Arrays.copyOfRange(sortedArray, length / 2 + 1, length));
    }
  }

  // slightly optimized solution that does not use array copy, still O(n*log(n))
  public void insertMinimalTreeMod(int[] sortedArray) {
    insertMinimalTreeModRecursive(sortedArray, 0, sortedArray.length - 1);
  }

  private void insertMinimalTreeModRecursive(int[] sortedArray, int start, int end) {
    int mid = (start + end) / 2;
    if (end >= start) {
      insert(sortedArray[mid]);
      insertMinimalTreeModRecursive(sortedArray, start, mid - 1);
      insertMinimalTreeModRecursive(sortedArray, mid + 1, end);
    }
  }

  // O(n) optimized solution that builds the tree as we iterate over the array, so no O(log(n))
  // insertion for every element.
  public void createMinimalTree(int[] sortedArray) {
    root = createMinimalTreeRecursive(sortedArray, 0, sortedArray.length - 1);
  }

  private Node createMinimalTreeRecursive(int[] sortedArray, int start, int end) {
    if (end < start) {
      return null;
    }
    int mid = (start + end) / 2;
    Node n = new Node(sortedArray[mid]);
    n.left = createMinimalTreeRecursive(sortedArray, start, mid - 1);
    n.right = createMinimalTreeRecursive(sortedArray, mid + 1, end);
    return n;
  }
}

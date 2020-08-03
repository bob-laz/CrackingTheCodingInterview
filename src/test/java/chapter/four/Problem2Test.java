package chapter.four;

import org.junit.jupiter.api.Test;

class Problem2Test {

  @Test
  public void minimalTreeTest() {
    int[] oddLengthSortedArray = new int[] {1, 2, 3, 4, 5, 6, 7};
    int[] evenLengthSortedArray =
        new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    System.out.println("Odd length, original implementation:");
    Problem2 bst = new Problem2();
    bst.insertMinimalTree(oddLengthSortedArray);
    bst.printTree();

    System.out.println("-------------");

    System.out.println("Odd length, no array copy implementation:");
    bst = new Problem2();
    bst.insertMinimalTreeMod(oddLengthSortedArray);
    bst.printTree();

    System.out.println("-------------");

    System.out.println("Odd length, optimized implementation:");
    bst = new Problem2();
    bst.createMinimalTree(oddLengthSortedArray);
    bst.printTree();

    System.out.println("-------------");

    System.out.println("Even length, original implementation:");
    bst = new Problem2();
    bst.insertMinimalTree(evenLengthSortedArray);
    bst.printTree();

    System.out.println("-------------");

    System.out.println("Even length, no array copy implementation:");
    bst = new Problem2();
    bst.insertMinimalTreeMod(evenLengthSortedArray);
    bst.printTree();

    System.out.println("-------------");

    System.out.println("Even length, optimized implementation:");
    bst = new Problem2();
    bst.createMinimalTree(evenLengthSortedArray);
    bst.printTree();
  }
}

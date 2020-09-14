package chapter.four;

public class NodeParent {

  int data;
  NodeParent left, right, parent;

  public NodeParent(int data) {
    this.data = data;
    parent = null;
    left = null;
    right = null;
  }

  public void setLeft(NodeParent left) {
    this.left = left;
    left.parent = this;
  }

  public void setRight(NodeParent right) {
    this.right = right;
    right.parent = this;
  }
}
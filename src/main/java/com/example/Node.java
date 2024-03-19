package com.example;

import java.util.Optional;

public class Node {

  public Node left, right, parent;
  public Integer key;
  public Color color;

  public boolean isNil() {
    return key == null;
  }

  public Node() {
    color = Color.BLACK;
  }

  private Node(Integer key) {
    this.key = key;
    this.color = Color.RED;
    left = NIL;
    right = NIL;
  }

  public static Node create(Integer key) {
    Node root = new Node(key);
    root.color = Color.BLACK;
    return root;
  }

  public Node add(int key) {
    Node node= new Node(key);
    Node current = this;
    boolean insertLeft= false;
    Node p = current;

    while (!current.isNil()) {
      p = current;
      if (key < current.key) {
        current = current.left;
        insertLeft = true;
      }
      else {
        current = current.right;
        insertLeft = false;
      }
    }

    if (insertLeft) {
      p.left = node;
    }
    else {
      p.right = node;
    }

    node.parent = p;

    BlackRedTreeBalancer.fixInsertion(node);

    return node;
  }

  public boolean isLeftChild(){
    return this.parent.left.equals(this);
  }

  public boolean isRightChild(){
    return this.parent.right.equals(this);
  }

  public boolean isRoot() {
    return this.key != null && this.parent == null;
  }

  public boolean isRed(){
    return this.color == Color.RED;
  }

  private static Node NIL = new Node();

  @Override
  public String toString(){
    return String.format("%s-%s", this.equals(NIL) ? "NIL" : key.toString(), color);
  }

  public boolean uncleIsRed() {
    return parent.parent.left.isRed() || parent.parent.right.isRed();
  }

  public Node getUncle() {
    return parent.isLeftChild() ? parent.parent.right : parent.parent.left;
  }

  public Node getGrandparent() {
    return parent.parent;
  }

  public Node getRoot() {
    Node t = this;
    while (!t.isRoot()) {
      t = t.parent;
    }

    return t;
  }

  public Node getParent() {
    return parent;
  }
}
package com.example;

public class BlackRedTreeBalancer {

  public static void fixInsertion(Node t){
    // корень - всегда черный
    if (t.isRoot()) {
      t.color = Color.BLACK;
      return;
    }
    int i = 0;
    // нужно продолжать балансировку, пока родитель красный, чтобы исключить нарушение правила:
    // у красной вершины могут быть только черные дети
    while (!t.isRoot() && t.parent.isRed()) {
      // если обрабатывает правая
      if (t.isRightChild()) {
        leftRotation(t);
        t = t.left;
      }
      else if (t.parent.parent.right.isRed()) {
        t.parent.color = Color.BLACK;
        t.parent.parent.right.color = Color.BLACK;
        t.parent.parent.color = Color.RED;
        t = t.parent.parent;
      }
      else if (!t.parent.parent.right.isRed()) {
        t.parent.color = Color.BLACK;
        t.parent.parent.right.color = Color.BLACK;
        t.parent.parent.color = Color.RED;
        t = t.parent.parent;
      }

    }
  }

  public static void leftRotation(Node t) {
    //      10R
    //    /     \
    //   A      12R
    //      12R
    //    /     \
    //   10R     B
    //  /  \
    // A   C
    var parent = t.parent;

    parent.right = t.left;
    t.left = parent;
    t.parent = parent.parent;
    t.parent.left = t;
    parent.parent = t;

  }

  public static void rightRotation(Node t) {
    //      10R
    //    /     \
    //   A      12R
    //      12R
    //    /     \
    //   10R     B
    //  /  \
    // A   C
    var parent = t.parent;

    parent.right = t.left;
    t.left = parent;
    t.parent = parent.parent;
    t.parent.left = t;
    parent.parent = t;

  }

}

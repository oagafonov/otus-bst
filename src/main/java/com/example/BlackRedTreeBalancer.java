package com.example;

public class BlackRedTreeBalancer {

  public static void fixInsertion(Node t){
    //       GP
    //      /   \
    //     P     U
    //    / \   / \
    //   N   A B   C
    // корень - всегда черный
    if (t.isRoot()) {
      t.color = Color.BLACK;
      return;
    }
    int i = 0;
    // нужно продолжать балансировку, пока родитель красный, чтобы исключить нарушение правила:
    // у красной вершины могут быть только черные дети
    while (!t.isRoot() && t.getParent().isRed()) {

      var uncle = t.getUncle();
      var parent = t.getParent();
      var grandparent = t.getGrandparent();

      if (uncle.isRed()) {
        // если папа и дядя - красные: перекрашиваем их и дедушку
        // продолжаем обработку с дедушки поскольку он стал красным и нужно проверить соблюдения п3

        uncle.color = Color.BLACK;
        parent.color = Color.BLACK;
        grandparent.color = Color.RED;
        t = grandparent;
      }
      else {
        // дядя черный
        if (t.isRightChild()) {
          leftRotation(t);
          rightRotation(parent);
          parent.color = Color.BLACK;
          grandparent.color = Color.RED;
          break;
        }
      }
    }
    t.getRoot().color = Color.BLACK;
  }

  public static void leftRotation(Node t) {
    //      GP
    //       |
    //       P
    //      / \
    //     A   t
    //        / \
    //       C   B
    //
    //     GP
    //      |
    //      t
    //     / \
    //    P   B
    //   / \
    //  A   C
    var parent = t.parent;

    parent.right = t.left;
    t.left = parent;
    t.parent = parent.parent;
    t.parent.left = t;
    parent.parent = t;

  }

  public static void rightRotation(Node t) {
    //      GP
    //       |
    //       P
    //      / \
    //     t   A
    //    / \
    //   C   B
    //
    //     GP
    //      |
    //      t
    //     / \
    //    C   P
    //       / \
    //      B   A
    var parent = t.getParent();
    var grandparent = t.getGrandparent();
    t.parent = grandparent;
    grandparent.left = t;
    parent.parent = t;
    parent.left = t.right;
    t.right = parent;
  }

}

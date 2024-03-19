package com.example;

import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.function.Consumer;

public class App {


  static void printUsingDFS(Node node){
    Queue<Node> q = new ArrayDeque<>();
    q.add(node);
    Node n;
    int counter = 1;
    int row = 0;
    while ((n = q.poll()) != null) {

      System.out.printf("%s ", n);
      if (counter == Math.pow(2, row)) {
        counter = 1;
        row++;
        System.out.println();
      }
      else {
        counter++;
      }
      if (!n.isNil()) {
        q.add(n.left);
        q.add(n.right);
      }
    }
  }

  public static void main(String[] args) {
    Node bts = Node.create(20);
    bts.add(10);
//    bts.add(9);
    bts.add(12);
//    bts.add(25);
//    bts.add(22);
//    bts.add(26);

    printUsingDFS(bts);
  }
}

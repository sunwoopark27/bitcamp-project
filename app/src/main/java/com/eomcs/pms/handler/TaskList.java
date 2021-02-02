package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Task;

public class TaskList {
  static final int LENGTH = 100;

  private Node first;
  private Node last;
  private int size = 0;  

  public void add(Task t) {

    Node node = new Node(t);

    if (last == null) {
      last = node;
      first = node;
    } else { 
      last.next = node; 
      node.prev = last; 
      last = node; 
    }

    this.size++;
  }

  public Task[] toArray() {

    Task[] arr = new Task[this.size];
    Node cursor = first;
    int i = 0;
    while(cursor != null) {
      arr[i++] = cursor.task;
      cursor = cursor.next;
    }

    return arr;
  }

  public Task get(int taskNo){
    Node cursor = first;
    while (cursor != null) {
      Task t = cursor.task;
      if (t.getNo() == taskNo) {
        return t;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public void delete(int taskNo) {

    Node cursor = first;
    while (cursor != null) {
      if (cursor.task.getNo() == taskNo) {
        if (first == last) {
          first = last = null;
          break;
        }
        if (cursor == first) {
          first = cursor.next;
          cursor.prev = null;
        } else {
          cursor.prev.next = cursor.next;
          if (cursor.next != null) {
            cursor.next.prev = cursor.prev;
          }
        }
        if (cursor == last) {
          last = cursor.prev;
        }
        this.size--;
        break;
      }
      cursor = cursor.next;
    }
  }


  static class Node {
    Task task;
    Node next;
    Node prev;

    Node(Task t) {
      this.task = t;
    }
  }
}

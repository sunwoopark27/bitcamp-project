package com.eomcs.util;

public class List {

  private Node first;
  private Node last;
  protected int size = 0;


  public void add(Object o) {
    Node node = new Node(o);

    if (last == null) { // 연결 리스트의 첫 항목이라면,
      last = node;
      first = node;
    } else { // 연결리스트에 이미 항목이 있다면, 
      last.next = node; // 현재 마지막 상자의 다음 상자가 새 상자를 가리키게 한다.
      node.prev = last; // 새 상자에서 이전 상자로서 현재 마지막 상자를 가리키게 한다. 
      last = node; // 새 상자가 마지막 상자가 되게 한다.
    }

    size++;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];

    Node cursor = this.first;
    int i = 0;

    while (cursor != null) {
      arr[i++] = cursor.obj;
      cursor = cursor.next;
    }
    return arr;
  }

  public Object get(int index) {

    if(index < 0 || index >= this.size) {
      return null;
    }

    Node cursor = first;
    int count = 0;
    while (cursor != null) {
      if (index == count++) {
        return cursor.obj;
      }
      cursor = cursor.next;
    }
    return null;
  }

  public boolean delete(Object obj) {

    int count = 0;
    Node cursor = first;
    while (cursor != null) {
      if (cursor.obj.equals(obj)) {
        this.size--;
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
        break;
      }
      cursor = cursor.next;
    }
    return false;
  }

  public Object delete(int index) {

    if(index < 0 || index >= this.size) {
      return null;
    }

    Object deleted = null;

    int count = 0;
    Node cursor = first;
    while (cursor != null) {
      if (index == count++) {
        deleted = cursor.obj;
        this.size--;
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
        break;
      }
      cursor = cursor.next;
    }
    return deleted;
  }


  public int indexOf(Object obj) {
    Object[] list = this.toArray();
    for(int i = 0; i < list.length; i++) {
      if(list[i].equals(obj)) {
        return i;
      }
    }
    return -1;
  }

  public int size() {
    return this.size;
  }

  private static class Node {
    Object obj;
    Node next;
    Node prev;

    Node(Object o) {
      this.obj = o;
    }
  }

  public Iterator iterator() throws CloneNotSupportedException{

    return new Iterator() {

      int cursor = 0; // 어디까지 꺼냈는지

      @Override
      public boolean hasNext() {
        // 로컬 클래스에서 바깥 클래스의 인스턴스 주소 사용할 떄는
        // => 바깥 클래스명.this
        // 예) List.this
        return cursor < List.this.size();
      }

      @Override
      public Object next() {
        return List.this.get(cursor++);
        // 위의 문장은 컴파일 하면 다음 문장으로 바뀐다.
        //    int temp = cursor;
        //    cursor = cursor + 1;
        //    return list.get(temp);
      }
    };

  }



}

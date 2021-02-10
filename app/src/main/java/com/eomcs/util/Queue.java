package com.eomcs.util;

public class Queue extends List implements Cloneable {

  public boolean offer(Object e) { //element 항목
    this.add(e);
    return true;
  }

  public Object poll() {
    return this.delete(0);
  }

  @Override
  public Queue clone() throws CloneNotSupportedException {
    Queue queue = new Queue();
    Object[] values = this.toArray();
    for (Object value : values) {
      queue.offer(value);
    }
    return queue;
  }

  @Override
  public Iterator iterator() throws CloneNotSupportedException {

    Queue queue = this.clone();

    return new Iterator() {

      // 만약 로컬 클래스에서 바깥 메서드의 로컬 변수를 사용한다면,
      // 컴파일러는 로컬 변수의 값을 저장할 필드를 자동 생성한다

      @Override
      public boolean hasNext() {
        // 로컬 클래스에서는 바깥 메서드의 로컬 변수를 직접 사용할 수 있다.
        // => 실제적으로는 로컬 클래스에 자동 생성된 필드를 가르킨다.
        // 내부적으로 그렇다는 거야 간단하게 기억해
        // 
        return queue.size() > 0;
      }

      @Override
      public Object next() {
        // 로컬 클래스에서는 바깥 메서드의 로컬 변수를 직접 사용할 수 있다.
        // => 실제적으로는 로컬 클래스에 자동 생성된 필드를 가르킨다.
        return queue.poll();
      }
    };

  }



}

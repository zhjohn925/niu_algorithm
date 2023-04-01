// Stack :  LIFO
// TO DO:
//    How to build Queue data structure by using Stack
//    data = { 1, 2, 3, 4, 5}
//    Data Stack                   Helper Stack





public static class ArrayStack {
  private Integer[] arr;
  private Integer index;
  
  public ArrayStack(int initSize) {
    if (initSize < 0) {
      throw new IllegalArgumentException("The init size is less than 0");
    }
    arr = new Integer[initSize];
    size = 0;
  }
  
  public Integer peek() {
    if (index==0) return null;
    reture arr[index-1];
  }
  
  public void push(int obj) {
    if (size == arr.length) {
      throw new ArrayIndexOutOfBoundsException("The queue is full");
    }
    arr[index++] = obj;
  }
  
  public Integer pop() {
    if (index == 0) {
      throw new ArrayIndexOutOfBoundsException("The queue is empty");
    }
    return arr[--index];
  }  
}


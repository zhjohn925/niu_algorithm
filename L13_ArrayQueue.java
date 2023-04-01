// Use array to implement Queue data structure, FIFO, first in first out
// TO DO:
//    How to build Stack (LIFO) data structure by using Queue (FIFO) ? 
//    - need two Queues
//      data: {1, 2, 3, 4, 5}
//                   Data Queue                             Helper Queue
//      push 1..5    5, 4, 3, 2, 1
//      pop and push to Helper (leave last data)  ------->  4, 3, 2, 1     
//      pop          5
//      swap Data queue and Helper queue
//                   tempQ = DataQ
//                   DataQ = HelperQ
//                   HelperQ = tempQ
//      Repeat the loop
//                   Helper Queue                            Data Queue
//       

public static class ArrayQueue {
  private Integer[] arr;
  private Integer size;    // number of data in the Queue
  private Integer start;   // index to pop.
  private Integer end;     // index to push.  consider "start" to catch up "end"
  
  public ArrayQueue(int initSize) {
    if (initSize < 0) {
      throw new IllegalArgumentException("The init size is less than 0");
    }
    arr = new Integer[initSize];
    size = 0;
    start = 0;
    end = 0;
  }
  public Integer peek() {
    if (size == 0) {
      return null;
    }
    return arr[start];
  }
  
  public void push(int obj) {
    if (size == arr.length) {
      throw new ArrayIndexOutOfBoundsException("The queue is full");
    }
    size++;
    arr[end] = obj;
    // wrap back to the beginning if reaching to the end
    end = end == arr.length - 1 ? 0 : end+1;
  }
  
  public Integer poll() {
    if (size == 0) {
      throw new ArrayIndexOutOfBoundsException("The queue is empty");
    }
    size--;
    int tmp = start;
    //wrap back to the beginning if reaching to the end
    start = start == arr.length - 1 ? 0 : start+1;
    return arr[tmp];
  }
  
}

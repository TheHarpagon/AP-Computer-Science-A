import java.util.ArrayList;

public class Queue {
  private ArrayList<Object>data;
  public Queue() {
    data = new ArrayList<Object>();
  }
  
  public void enqueue(Object o) {
    data.add(o);
  }
  
  public Object dequeue() {
    return data.remove(0);
  }
  
  public String toString() {
    return data.toString();
  }
  
  public int size() {
    return data.size();
  }
  
  public void bubbleSort() {
    for (int i = 0; i < data.size() - 1; i++) {
      for (int j = 0; j < data.size() - 1 - i; j++) {
        if (data.get(j).toString().compareTo(data.get(j + 1).toString()) > 0) {
          Object a = data.remove(i);
          data.add(i + 1, a);
        }
      }
    }
  }
}
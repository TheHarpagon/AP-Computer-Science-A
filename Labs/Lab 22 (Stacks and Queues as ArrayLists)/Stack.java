import java.util.ArrayList;

public class Stack {
  private ArrayList<String> data;
  public Stack() {
    data = new ArrayList<String>();
  }
  
  public void push(String s) {
    data.add(0, s);
  }
  
  public String pop() {
    return data.remove(0);
  }
  
  public String toString() {
    return data.toString();
  }
  
  public int size() {
    return data.size();
  }
}
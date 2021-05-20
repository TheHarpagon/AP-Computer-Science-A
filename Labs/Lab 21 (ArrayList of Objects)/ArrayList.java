public class ArrayList {
  private Object[] objectList;

  public ArrayList() {
    objectList = null;
  }

  public int size() {
    if (objectList == null)
      return 0;
    return objectList.length;
  }

  public boolean add(Object obj) {
    if (objectList == null) {
      Object[] newObjectList = new Object[1];
      newObjectList[0] = obj;
      objectList = newObjectList;
      return true;
    }
    Object[] newArray = new Object[size() + 1];
    for (int i = 0; i < size(); i++)
      newArray[i] = objectList[i];
    newArray[newArray.length - 1] = obj;
    objectList = newArray;
    return true;
  }
  
  public void add(int index, Object obj) {
    assert (index == 0) && (objectList == null) || objectList != null && index <= objectList.length && index >= 0: "Error: add()";
    if (objectList == null) {
      add(obj);
      return;
    }

    Object[] copy = new Object[size() + 1];
    for (int i = index; i < size(); i++)
      copy[i + 1] = objectList[i];
    
    for (int i = 0; i < index; i++)
      copy[i] = objectList[i];
    
    copy[index] = obj;
    objectList = copy;
  }

  public Object get(int index) {
    return objectList[index];
  }

  public Object remove(int index) {
    Object[] copy = new Object[size() - 1];
    Object rv = objectList[index];
    // [0 1 2 3 4 5 6 7 8 9]
    for (int i = 0; i < index; i++)
      copy[i] = objectList[i];
    for (int i = index + 1; i < size(); i++)
      copy[i - 1] = objectList[i];
    objectList = copy;
    return rv;
  }

  public String toString() {
    String rv = "[";
    for (int i = 0; i < size(); i++)
      rv += (i != size() - 1) ? objectList[i] + ", " : objectList[i] + "]";
    return rv;
  }
}
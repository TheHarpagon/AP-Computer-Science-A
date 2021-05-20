class Main {
  private static Grade grade = new Grade();
  public static void main(String[] args) {
    try {
      System.out.println("Testing Part 1: static methods");
      int[] a = {1, 2, 3};
      int[] b = Stack.copyArray(a);
      System.out.println("1. Matching elements: (These should all be true)");
      for (int i = 0; i < a.length; i++)
        System.out.println("Element " + i + ":\t" + score(a[i]==b[i]));
      b[0] = 0;
      System.out.println("\n2. Creating new array, not returning pointer:");
      System.out.println("Pass:\t" + score(a[0] == 1));
    
      int[] c = {11, 12, 13}, d = {14, 15}, e = Stack.append(c, d);
      boolean passAppend = true;
      System.out.println("\n3. Append");
      for (int i = 0; i < e.length; i++) {
        if (e[i] != 11 + i)
          passAppend = false;
      }
      System.out.println("Basic:\t" + score(passAppend));
      passAppend = true;
      e = Stack.append(c,null);
      for (int i = 0; i < c.length; i++) {
        if (e[i] != 11 + i)
          passAppend = false;
      }
      passAppend &= c.length == e.length;
      e = Stack.append(null, d);
      for (int i = 0; i < d.length; i++) {
        if (e[i] != 14 + i)
          passAppend = false;
      }
      passAppend &= d.length == e.length;   
      System.out.println("Null:\t" + score(passAppend));
    
      boolean passClass = true;
      System.out.println("\nTesting Part 2-4: Class definition");
      Stack s = new Stack();
      int[] f = s.getStorage();
      passClass = f != null;
      if (passClass) {
        f[0] = 8;
        passClass &= s.getStorage()[0] != 8;
      }
      System.out.println("Safe storage:\t" + score(passClass));
    
      System.out.println("\nTesting Part 5: Push/Pop functions");
      boolean passPop = true;
      Stack t = new Stack();
      for (int i = 0; i < 10; i++)
        t.push(i + 1);
      System.out.println("Push10:\t\t" + score(t.getNumberOfElements() == 10));
      for (int i = 0; i < 5; i++)
        passPop &= t.pop() == 10 - i;
      System.out.println("Pop5:\t\t" + score(passPop));
      passPop = true;
      for (int i = 0; i < 5; i++)
        t.push(i);
      for (int i = 0; i < 10; i++)
        passPop &= t.getStorage()[i] == i + 1 - i / 5 * 6;
      System.out.println("PushPop:\t" + score(passPop));
    
      t = new Stack();
      for (int i = 0; i < 110; i++)
        t.push(i);
      System.out.println("Push110:\t" + score(t.getStorage().length == 200));
      for (int i = 110; i < 200; i++)
        t.push(i);
      System.out.println("Push200:\t" + score(t.getStorage().length == 200));
      for (int i = 200; i < 5001; i++)
        t.push(i);
      System.out.println("Push5k:\t" + score(t.getStorage().length == 5100));
    
      System.out.println("\nTesting Part 6: toString()");
      Stack u = new Stack();
      String g = "";
      for (int i = 1; i <= 10; i++) {
        u.push(i);
        g += ", " + i;
      }
      g = "[" + g.substring(2) + "]";
      System.out.println("[1-10]:\t\t" + score(u.toString().equals(g)));
      u = new Stack();
      System.out.println("[]:\t\t\t" + score(u.toString().equals("[]")));
    }
    catch (Exception e) {
      System.out.println("\n\nYour code crashed. You will not continue earning points beyond this point.");
    }
    System.out.println("\n\nTotal Score: " + grade + "/15");
  }
  public static boolean score (boolean b) {
    if (b)
      grade.grade++;
    return b;
  }
}

class Grade {
  int grade = 0;
  public String toString() {
    return "" + grade;
  }
}
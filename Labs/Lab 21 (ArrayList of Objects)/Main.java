public class Main {
  public static void main(String[] args) {
    // building the dictionary with the french terms and definitions/translations
    Dictionary dictionnaire = new Dictionary();
    String[] words = {"Le taureau", "La vache", "La tortue", "Le canard", "Le cochon", "La chèvre", "Le poulet", "Une poule", "Le lapin", "Le mouton", "La brebis"};
    String[] defs = {"The bull", "The cow", "The turtle", "The duck", "The pig", "The goat", "The chicken", "A hen", "The rabbit", "The sheep", "The ewe"};
    fillDictionary(dictionnaire, words, defs);
    
    // starts the quiz using the previously assigned dictionary
    dictionnaire.randomFlashCard();
    
    // runs teacher test code to grade the lab
    gradeLab();
  }
  
  public static void fillDictionary(Dictionary d, String[] words, String[] defs) {
    for (int i = 0; i < words.length; i++) {
      d.add(words[i], defs[i]);
    }
  }
  
  public static int grade = 0;
  public static void gradeLab() {
    try {
      ArrayList a1 = new ArrayList();
      Object[] o1 = new Object[10];
      for (int i = 0; i < 10; i++) {
        o1[i] = new Object();
        a1.add(o1[i]);
      }
      boolean test=true;
      for (int i = 0; i < 10; i++) {
        test &= o1[i] == a1.get(i);
      }
      System.out.println("\n1. add(o): " +
        score(test));
    }
    catch (Exception e1) {
      System.out.println("\n\n1. Your code crashed.");
    }
    
    try {
      ArrayList a1 = new ArrayList();
      Object[] o1 = new Object[10];
      for (int i = 0; i < 10; i++) {
        o1[i] = new Object();
        a1.add(0, o1[i]);
      }
      boolean test = true;
      for (int i = 0; i < 10; i++) {
        test &= o1[9 - i] == a1.get(i);
      }
      System.out.println("2. add(i,o): " +
        score(test));
    }
    catch (Exception e1) {
      System.out.println("\n\n2. Your code crashed.");
    }
  
  
    try {
      ArrayList a1 = new ArrayList();
      Object[] o1 = new Object[10];
      for (int i = 0; i < 10; i++) {
        o1[i] = new Object();
        a1.add(o1[i]);
      }
      a1.remove(3);
      boolean test=true;
      for (int i = 0; i < 3; i++) {
        test &= o1[i] == a1.get(i);
      }
      for (int i = 4; i < 10; i++) {
        test &= o1[i] == a1.get(i - 1);
      }
      System.out.println("3. remove: " +
        score(test));
    }
    catch (Exception e1) {
      System.out.println("\n\n3. Your code crashed.");
    }
  
    try {
      ArrayList a1 = new ArrayList();
      Object[] o1 = new Object[10];
      for (int i = 0; i < 10; i++) {
        o1[i] = new Object();
        a1.add(o1[i]);
      }
      for (int i = 9; i >= 0; i -= 2) {
        a1.remove(i);
      }
      boolean test=true;
      for (int i = 0; i < 5; i++) {
        test &= o1[2 * i] == a1.get(i);
      }
      System.out.println("4. remove: " +
        score(test));
    }
    catch (Exception e1) {
      System.out.println("\n\n4. Your code crashed.");
    }
  
  
    try {
      ArrayList a1 = new ArrayList();
      ArrayList a2 = new ArrayList();
      Object[] o1 = new Object[10];
      for (int i = 0; i < 10; i++) {
        o1[i] = new Object();
        a1.add(o1[i]);
      }
      for (int i = 9; i >= 0; i -= 2) {
        a1.remove(i);
      }
      System.out.println("5. size: " +
        score(a1.size() == 5 && a2.size() == 0));
    }
    catch (Exception e1) {
      System.out.println("\n\n5. Your code crashed.");
    }
  
    try {
      ArrayList a1 = new ArrayList();
      ArrayList a2 = new ArrayList();
      Integer[] o1 = new Integer[10];
      for (int i = 0; i <= 3; i++) {
        o1[i] = new Integer(i);
        a1.add(o1[i]);
      }
      System.out.println("6. toString(): " +
        score(a1.toString().equals("[0, 1, 2, 3]")));
    }
    catch (Exception e1) {
      System.out.println("\n\n6. Your code crashed.");
    }
  
    try {
      ArrayList a1 = new ArrayList();
      ArrayList a2 = new ArrayList();
      String[] o1 = new String[10];
      for (int i = 0; i <= 3; i++) {
        o1[i] = (new Character((char) (97 + i))).toString();
        a1.add(o1[i]);
      }
      System.out.println("7. toString(): " +
        score(a1.toString().equals("[a, b, c, d]")));
    }
    catch (Exception e1) {
      System.out.println("\n\n7. Your code crashed.");
    }
    System.out.format("Score: %d/7%n", grade);
  }
  
  public static boolean score(boolean b) {
    if (b)
      grade++;
    return b;
  }
}
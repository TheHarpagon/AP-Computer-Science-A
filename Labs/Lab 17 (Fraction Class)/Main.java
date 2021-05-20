class Main {
  private static Grade grade = new Grade();
  public static void main(String[] args) {
    System.out.println("Part 1: Manually Graded"); 
    try{
      Fraction a = new Fraction();
      a.setNumerator(2);
      a.setDenominator(3);
      System.out.println("2. Getters/Setters: " +
        score(a.getNumerator()==2&&a.getDenominator()==3));
    }
    catch(Exception e1){
      System.out.println("\n\n2. Your code crashed.");
    }
    try{
      Fraction a = new Fraction();
      a.setNumerator(2);
      a.setDenominator(3);
      Fraction b = new Fraction();
      b.setNumerator(2);
      b.setDenominator(1);
      System.out.println("3. toString(): " +
        score(a.toString().equals("2/3")));
      System.out.println("3. toString() den 1: " +
        score(b.toString().equals("2")));
    }
    catch(Exception e2){
      System.out.println("\n\n3. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(4,5);
      Fraction b = new Fraction(a);
      a.setNumerator(3);
      a.setDenominator(2);
      System.out.println("4. Constructors: " +
        score(a.toString().equals("3/2") &&
              b.toString().equals("4/5")));
    }
    catch(Exception e3){
      System.out.println("\n\n4. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(30,7);
      Fraction b = new Fraction(6,1);
      Fraction c = new Fraction(1,4);
      System.out.println("5. toMixedNumber(): " +
        score(a.toMixedNumber().equals("4 2/7")));
      System.out.println("5. toMixed() Integer: " +
        score(b.toMixedNumber().equals("6")));
      System.out.println("5. toMixed() <1: " +
        score(c.toMixedNumber().equals("1/4")));
    }
    catch(Exception e4){
      System.out.println("\n\n5. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(30,7);
      Fraction b = new Fraction(17,3);
      Fraction c = new Fraction(5,0);
      System.out.println("5. integerPart(): " +
        score(a.integerPart()==4));
      System.out.println("5. static intPart(): " +
        score(Fraction.integerPart(b)==5));
      System.out.println("5. remainder(): " +
        score(a.remainder()==2));
      System.out.println("5. isError(): " +
        score(!a.isError() && c.isError()));
    }
    catch(Exception e5){
      System.out.println("\n\n5. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(30,7);
      Fraction b = new Fraction(17,-3);
      Fraction c = new Fraction(5,0);
      Fraction d = new Fraction(-2,-3);
      System.out.println("5. abs(): " +
        score(Fraction.abs(-3)==3));
      System.out.println("5. isPositive(): " +
        score(a.isPositive() && !b.isPositive()
              && !c.isPositive() && d.isPositive()));
    }
    catch(Exception e6){
      System.out.println("\n\n5. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(30,6);
      Fraction b = new Fraction(5,1);
      Fraction c = new Fraction(5,-1);
      Fraction d = new Fraction(2,3);
      Fraction e = new Fraction(3,4);
      Fraction f = new Fraction(4,3);
      System.out.println("5. equals(): " +
        score(a.equals(b) && !a.equals(c)
              && !d.equals(e) && !e.equals(f)));
    }
    catch(Exception e6){
      System.out.println("\n\n5. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(2,3);
      Fraction b = new Fraction(3,4);
      Fraction c = new Fraction(4,-3);
      Fraction d = Fraction.min(a,b);
      System.out.println("5. min/max(): " +
        score(Fraction.min(a,b).toString().equals("2/3")
              && Fraction.min(b,a).toString().equals("2/3")));
      System.out.println("5. min/max() negatives: " +
        score(Fraction.max(a,c).toString().equals("2/3")
              && Fraction.min(a,c).equals(new Fraction(4,-3))));
      a.setNumerator(4);
      System.out.println("5. min/max() pointers: " +
        score(d.equals(new Fraction(2,3))));
    }
    catch(Exception e7){
      System.out.println("\n\n5. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(2,3);
      Fraction b = new Fraction(26,39);
      Fraction c = new Fraction(-4,-3);
      Fraction d = new Fraction(-15,9);
      System.out.println("6. isSimplified(): " +
        score(a.isSimplified() && !b.isSimplified()
              && !c.isSimplified() && !d.isSimplified()));
    }
    catch(Exception e8){
      System.out.println("\n\n6. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(2,3);
      Fraction b = new Fraction(26,-39);
      Fraction c = new Fraction(-8,-6);
      Fraction d = new Fraction(18,63);
      a.simplify();
      b.simplify();
      c.simplify();
      d.simplify();
      System.out.println("6. simplify(): " +
        score(a.getNumerator()==2 && a.getDenominator()==3
              && d.getNumerator()==2 && d.getDenominator()==7));
      System.out.println("6. simplify() negatives: " +
        score(b.getNumerator()==-2 && b.getDenominator()==3));
      System.out.println("6. simplify() double negatives: " +
        score(c.getNumerator()==4 && c.getDenominator()==3));
    }
    catch(Exception e8){
      System.out.println("\n\n6. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(2,3);
      Fraction d = new Fraction(18,63);
      a = a.simplified();
      d = d.simplified();
      System.out.println("6. simplified(): " +
        score(a.getNumerator()==2 && a.getDenominator()==3
              && d.getNumerator()==2 && d.getDenominator()==7));
    }
    catch(Exception e8){
      System.out.println("\n\n6. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(2,3);
      Fraction b = new Fraction(1,2);
      Fraction c = new Fraction(3,4);
      Fraction d = new Fraction(1,-2);
      System.out.println("7. sum(): " +
        score(a.sum(b).equals(new Fraction(7,6))));
      System.out.println("7. simplify sum(): " +
        score(c.sum(b).toString().equals("5/4")));
      System.out.println("7. negatives sum(): " +
        score(d.sum(b).equals(new Fraction(0,1))));
    }
    catch(Exception e8){
      System.out.println("\n\n7. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(5,3);
      Fraction b = new Fraction(5,4);
      Fraction c = new Fraction(2,-3);
      Fraction d = new Fraction(-3,4);
      System.out.println("7. difference: " +
        score(a.difference(c).equals(new Fraction(7,3))));
      System.out.println("7. difference simplified: " +
        score(d.difference(b).toString().equals("-2")));
      System.out.println("7. product: " +
        score(a.product(d).equals(new Fraction(-5,4))));
      System.out.println("7. product simplified: " +
        score(c.product(d).toString().equals("1/2")));
      System.out.println("7. quotient: " +
        score(a.quotient(c).equals(new Fraction(-5,2))));
      System.out.println("7. quotient simplified: " +
        score(b.quotient(d).toString().equals("-5/3")));
    }
    catch(Exception e9){
      System.out.println("\n\n7. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(4,9);
      Fraction b = new Fraction(2*2*5*5,3*3*5*5);
      System.out.println("7. sqrt(): " +
        score(a.sqrt().equals(new Fraction(2,3))));
      System.out.println("7. simplify sqrt(): " +
        score(b.sqrt().toString().equals("2/3")));
    }
    catch(Exception e10){
      System.out.println("\n\n7. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(1,1);
      Fraction b = new Fraction(5,1);
      Fraction c = new Fraction(6,1);
      Fraction a1 = new Fraction(1,1);
      Fraction b1 = new Fraction(4,1);
      Fraction c1 = new Fraction(4,1);
      Fraction a2 = new Fraction(1,1);
      Fraction b2 = new Fraction(0,1);
      Fraction c2 = new Fraction(1,1);
      Fraction[] ans = Fraction.quadraticFormula(a,b,c);
      Fraction[] ans1 = Fraction.quadraticFormula(a1,b1,c1);
      Fraction[] ans2 = Fraction.quadraticFormula(a2,b2,c2);
  
      System.out.println("8. quadraticFormula() # ans: " +
        score(ans.length==2 && ans1.length==1 && ans2==null));
      System.out.println("8. quadraticFormula() 1: " +
        score(ans[0].sum(ans[1]).equals(new Fraction(-5,1))));
      System.out.println("8. quadraticFormula() 2: " +
        score(ans1[0].equals(new Fraction(-2,1))));
    }
    catch(Exception e11){
      System.out.println("\n\n8. Your code crashed.");
    }
    try{
      Fraction a = new Fraction(5,12);
      Fraction[] ans = a.partialPartialFractionDecomposition();
      Fraction total = Fraction.sum(ans);
      int nonzero = 0;
      for(int i=0; i<ans.length; i++)
        if(ans[i]!=null && !ans[i].equals(new Fraction(0,1)))
          nonzero++;
      System.out.println("9. ppfd() sum: " +
        score(total.equals(new Fraction(5,12))));
      System.out.println("9. ppfd() decomposition: " +
        score(nonzero > 1));
  
    }
    catch(Exception e12){
      System.out.println("\n\n9. Your code crashed.");
    }
  
    System.out.println("Total Score: " + grade.toString());
  }
  public static boolean score(boolean b){
    if(b)
      grade.grade++;
    return b;
  }
}
class Grade{
  int grade=0;
  public String toString(){
    return "" + grade + " / 38";
  }
}
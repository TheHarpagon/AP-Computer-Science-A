import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Stack a = new Stack();
    a.push("Celica");
    a.push("Supra");
    a.push("Skyline");
    a.push("Lancer");
    a.push("Impreza");
    System.out.println(a.toString());
    while(a.size() != 0) {
      System.out.println(a.pop());
    }
    
    Queue b = new Queue();
    int menu;
    Scanner i = new Scanner(System.in);
    menu = i.nextInt();
    while (menu != 9) {
      System.out.println("1. Add person to queue");
      System.out.println("2. Remove person from queue");
      System.out.println("3. Print queue");
      System.out.println("9. Exit");
      
      if (menu == 1) {
        String name = i.nextLine();
        System.out.println("Name to add?");
        b.enqueue(name);
      } 
      
      else if (menu == 2) {
        b.dequeue();
      } 
      
      else if (menu == 3) {
        System.out.println(b.toString());
      } 
      
      else if (menu == 4) {
        b.bubbleSort();
      } 
      
      else if (menu == 9) {
        break;
      }
    }
    i.close();
  }
}
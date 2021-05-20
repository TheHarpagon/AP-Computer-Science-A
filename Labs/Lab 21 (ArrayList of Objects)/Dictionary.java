import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
  private ArrayList words = new ArrayList();
  private ArrayList defs = new ArrayList();

  public void add(String word, String def) {
    words.add(word);
    defs.add(def);
  }

  public int size() {
    return words.size();
    // or return defs.size();
  }

  public void randomFlashCard() {
    // building a copy to be restored to defs at the end
    // since I mess with it on line 37
    ArrayList defsCopy = new ArrayList();
    for (int i = 0; i < defs.size(); i++)
      defsCopy.add(defs.get(i));

    // building the question
    // the question and answer are selected with an assigned random index
    Random random = new Random();
    int randomIndex = random.nextInt(words.size());
    String word = words.get(randomIndex).toString();
    String answer = defs.get(randomIndex).toString();
    
    // building the choices array
    String[] choices = new String[4];
    // setting first value as the answer
    choices[0] = answer;
    // removing the answer from the defs object
    // so it will not be repeated in choices
    defs.remove(randomIndex);
    // copying over from defs ↔ choices
    int randomIndex2 = 0;
    for (int i = 1; i < 4; i++) {
      randomIndex2 = random.nextInt(defs.size());
      choices[i] = defs.get(randomIndex2).toString();
      defs.remove(randomIndex2);
    }
    
    // shuffling choices
    int change = 0;
    String temp = "";
    for (int i = 0; i < choices.length; i++) {
      change = i + random.nextInt(choices.length - i);
      temp = choices[i];
      choices[i] = choices[change];
      choices[change] = temp;
    }

    // displaying the question
    String[] options = {"a", "b", "c", "d"};
    System.out.format("What is the defintion/translation of \"%s\"?%n%n", word);
    for (int i = 0; i < 4; i++)
      System.out.format("%s) \"%s\"%n", options[i], choices[i]);
    
    // fetching user input
    Scanner inputScanner = new Scanner(System.in);
    System.out.print("\nEnter choice: ");
    // fetches and capitalizes the first character of the user input
    String input = inputScanner.nextLine().substring(0, 1).toLowerCase();
    
    // loops user inputting if input is invalid
    while (!Arrays.asList(options).contains(input)) {
      System.out.print("\n\u001B[31mInvalid choice!\u001B[0m\nEnter choice: ");
      input = inputScanner.nextLine().substring(0, 1).toLowerCase();
    }
    inputScanner.close();
    
    // checking

    // fetch the index of the answer to be used for checking
    int answerIndex = 0;
    for (int i = 0; i < choices.length; i++) {
      if (choices[i] == answer) {
        answerIndex = i;
        break;
      }
    }
    
    // input and answer comparision
    if (input.equals(options[answerIndex]))
      System.out.println("\n\u001B[32mYou are correct!\u001B[0m");
    else
      System.out.format("%n\u001B[31mNice try! The answer was %s.\u001B[0m%n", options[answerIndex].toUpperCase());
    
    // defs reassignment and function close
    defs = defsCopy;
  }
}
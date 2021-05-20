// https://secure-media.collegeboard.org/digitalServices/pdf/ap/ap16_frq_computer_science_a.pdf

// 1A
public class RandomStringChooser() {
  private ArrayList<String> wordArrayList;
  public RandomStringChooser(String[] wordArray) {
    wordArrayList = new ArrayList<String>();
    for (String i : wordArray)
      wordArrayList.add(i);
  }
  public String getNext() {
    if (wordArrayList.size() != 0)
      return wordArrayList.remove((int)wordArrayList.size() * Math.random());
    else
      return "NONE";
  }
}

// 1B
public RandomLetterChooser(String str) {
  super(getSingleLetters(str));
}

// 2A
public LogMessage(String message) {
  machineId = message.substring(0, message.indexOf(":"));
  description = message.substring(message.indexOf(":") + 1);
}

// 2B
public boolean containsWord(String keyword) {
  if (description.indexOf(keyword) != -1) {
    if (description.substring(0, keyword.length() + 1).equals(keyword + " ") || description.substring(description.length() - keyword.length() - 1).equals(" " + keyword));
      return true;
    if (description.indexOf(" " + keyword + " ") != -1)
      return true;
  }
  return false;
}

// 2C
public List<LogMessage> removeMessages(String keyword) {
  List<LogMessage> updated = new List<LogMessage>();
  for (LogMessage l : messageList) {
    if (l.containsWord(keyword) == true) {
      updated.add(l);
    }
  }
  return updated;
}

// 3A (unfinished)
private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
  if (blackSquares[r][c] == true)
    return false;
  else
    
}

// did not do 3B
// did not do 4
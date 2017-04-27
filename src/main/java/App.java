import java.io.Console;

public class App {
    public static void main(String[] args) {
      Console myConsole = System.console();
      StringBuilder mystery = new StringBuilder();
      int MAX_GUESSES = 7; //   These are the maximum guesses a user has
      int incorrectGuesses = 0; // These are the number of incorrectGuesses
      boolean continueGame = true; // This boolean determines if the game will continue or stop
      String challenge = "";
      System.out.println("Pick a level to begin : Easy,Easier, Hard ,Harder, Medium ,Lexy");
      String level = myConsole.readLine();
      level = level.toLowerCase();
      if (level.equals("easy")){
           challenge = "handling";
      } else if (level.equals("easier")){
         challenge = "money";
     } else if (level.equals("hard")){
           challenge = "mammoth";
      } else if (level.equals("medium")){
            challenge = "eskimo";
       }
      else {
            challenge = "zinjanthropus";
       }
    //
    // challenge = challenge.toLowerCase();
    // The loop below gets the length of the input and replaces each character with a dash so that the next user will just see dashes .
    for ( int i= 0 ; i < challenge.length()*2 ; i ++ ) {
        if (i % 2 == 0 ) {
             mystery.append("_");
        } else {
            mystery.append(" ");
        }
    }
    // end of loop above

    // The while loop below is in relation the the boolean above and will keep the game running until the number of incorrect guesses is reached or the user guesses the word.
    while (continueGame) {
        System.out.println(mystery);
        System.out.println("Now guess the words in the blank spaces");
        char attempt = myConsole.readLine().charAt(0);
        boolean isCorrect = false;
        for (int i = 0 ;i < challenge.length(); i ++ ) {
            if (challenge.charAt(i) == attempt) {
                mystery.setCharAt(i*2,attempt);
                isCorrect = true;
            }
        }
        //Loop below determines if the user has won the game . it tajes mystery and converts it to a string from there it replaces the empty spaces with nothing thus bringing the word together and then compares it to challenge the initial input
        if (mystery.toString().replace(" ","").equals(challenge)){
            System.out.println("Your good the word entered was " + mystery);
            System.out.println("You won!");
            continueGame = false;
        }

        //Checks if the guess is correct . if not correct it will increment the variable (incorrectGuesses)
        if(!isCorrect) {
            incorrectGuesses++;
        }

        if (incorrectGuesses >= MAX_GUESSES) {
            System.out.println("Sorry! You're out of guesses. The word was " + mystery);
            continueGame = false;
        }
    }
    // End of while loop
}
}

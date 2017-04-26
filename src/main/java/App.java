import java.io.Console;

public class App {
    public static void main(String[] args) {
      Console myConsole = System.console();
      StringBuilder mystery = new StringBuilder();
      int MAX_GUESSES = 7;
      int incorrectGuesses = 0;
      boolean continueGame = true;

      System.out.println("Enter a word to begin");
    String challenge = myConsole.readLine();
    challenge = challenge.toLowerCase();
    for ( int i= 0 ; i < challenge.length()*2 ; i ++ ) {
        if (i % 2 == 0 ) {
             mystery.append("_");
        } else {
            mystery.append(" ");
        }
    }
    while (continueGame) {
    // String replaced = challenge.replace("H_ _ _o");
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
        if (mystery.toString().replace(" ","").equals(challenge)){
            System.out.println(mystery);
            System.out.println("You won!");
            continueGame = false;
        }
        if(!isCorrect) {
            incorrectGuesses++;
        }

        if (incorrectGuesses >= MAX_GUESSES) {
            System.out.println("Sorry! You're out of guesses.");
            continueGame = false;
        }
    }
}
}

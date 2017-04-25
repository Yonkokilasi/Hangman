import java.io.Console;

public class App {
    public static void main(String[] args) {
      Console myConsole = System.console();
      System.out.println("Enter a word to begin");
    String challenge = myConsole.readLine();
    String replaced = challenge.replace("H_ _ _o");
    System.out.println(replaced);
}
}

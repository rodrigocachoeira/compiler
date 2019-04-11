import Lexical.LexicalAnalyzer;

import java.util.Scanner;

/**
 * Primary Class for running
 * application only
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 *
 * q0 -> Initial State
 * q1 -> Is a Number
 * q2 -> dot or comma
 * q3 -> quotation marks
 * q4 -> Alpha Numeric or underline
 */
public class App {

    /**
     * Start method
     *
     * @param args arguments passed as parameters
     */
    public static void main(String args[]) {
        App.waitForInput();
    }

    /**
     * Wait for input and execute alg
     */
    private static void waitForInput() {
        String input = "";
        Scanner scanner = new Scanner(System.in);

        while(! (input = scanner.nextLine()).isEmpty()) {
            System.out.println(new LexicalAnalyzer().setInput(input).run());
        }
    }

}

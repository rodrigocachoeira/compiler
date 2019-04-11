package Lexical;

import Core.AnalyzerMessage;
import Exceptions.InvalidFloatException;
import Exceptions.InvalidIntegerException;
import Exceptions.InvalidTextException;
import Lexical.rules.QuotationMarksLexical;
import Exceptions.InvalidEndPointException;
import Lexical.rules.IntegerLexical;
import Core.Tape;
import Lexical.rules.TextLexical;

/**
 * Class that union all lexical analyzers
 * for validate values
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public class LexicalAnalyzer {

    /**
     * Set Input value
     *
     * @param input Text to be analyzed
     * @return own class
     */
    public LexicalAnalyzer setInput(String input) {
        new Tape(input);
        return this;
    }

    /**
     * Some resets for analytics work again
     */
    public void resetAnalytics () {
        QuotationMarksLexical.openedCharacter = null;
        IntegerLexical.isFloat = false;
    }

    /**
     * Start Method
     *
     * @since 1.0.0
     */
    public String run() {
        try {
            if (IntegerLexical.regexValidation(Tape.getCurrentInputValue())) {
                new IntegerLexical().run();

            } else if (QuotationMarksLexical.regexValidation(Tape.getCurrentInputValue())) {
                new QuotationMarksLexical().run();

            }  else if (TextLexical.regexValidation(Tape.getCurrentInputValue())) {
                new TextLexical().run();
            }

            return AnalyzerMessage.getMessage();
        } catch (InvalidEndPointException | InvalidIntegerException | InvalidTextException | InvalidFloatException e) {
            return "Language error: ".concat(e.getMessage());
        } finally {
            this.resetAnalytics();
        }
    }

}

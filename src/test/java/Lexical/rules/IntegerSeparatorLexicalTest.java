package Lexical.rules;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import Exceptions.InvalidEndPointException;
import Exceptions.InvalidFloatException;
import Exceptions.InvalidIntegerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import Exceptions.InvalidTextException;
import org.junit.jupiter.api.Test;
import Core.Tape;

/**
 * Define all tests about integer
 * rule validation of lexical module
 *
 * @author Rodrigo Cachoeira
 */
@DisplayName("Lexical Analyzer Test Class of Integer Separator Pattern")
class IntegerSeparatorLexicalTest {

    /**
     * Test Analyzer
     */
    private IntegerSeparatorLexical analyzer = new IntegerSeparatorLexical();

    /**
     * Set default method for recognize some
     * text
     *
     * @return validated
     */
    private boolean recognize() throws InvalidEndPointException, InvalidIntegerException, InvalidTextException, InvalidFloatException {
        return this.analyzer.setInput(Tape.getCurrentInputValue()).run().ok();
    }

    @Test
    void regexAnalyzerShouldBeRecognizeAnSemicolon() throws Exception {
        new Tape(",");
        assertTrue(this.recognize());
    }

    @Test
    void regexAnalyzerShouldBeRecognizeAnDot() throws Exception {
        new Tape(".");
        assertTrue(this.recognize());
    }

    @Test
    void regexAnalyzerDoNotShouldRecognizeAnStringValue() throws InvalidEndPointException {
        Assertions.assertThrows(InvalidIntegerException.class, () -> {
            new Tape("q");
            assertFalse(this.recognize());
        });
    }

    @Test
    void regexAnalyzerDoNotShouldRecognizeAnInteger() throws InvalidEndPointException {
        Assertions.assertThrows(InvalidIntegerException.class, () -> {
            new Tape("1");
            assertFalse(this.recognize());
        });
    }

}

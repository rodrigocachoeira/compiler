package Exceptions;

/**
 * Define exception about line end point
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public class InvalidEndPointException extends Exception {

    /**
     * Default Constructor method
     */
    public InvalidEndPointException() {
        super("Invalid end point of line");
    }

}

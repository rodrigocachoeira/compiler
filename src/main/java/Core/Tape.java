package Core;

import Exceptions.InvalidEndPointException;

/**
 * Define class will be define
 * behaviour of string ribbon
 */
public class Tape {

    /**
     * Define all input string
     */
    private static String completeInput;

    /**
     * Define in witch tape position the pointer is
     */
    private static int pointer;

    /**
     * Construct method
     *
     * @param completeInput all of input
     */
    public Tape(String completeInput) {
        Tape.completeInput = completeInput;
        Tape.pointer = 0; //in the begging of tape
    }

    /**
     * Get complete input
     *
     * @return complete input
     */
    public static String getCompleteInput() {
        return completeInput;
    }

    /**
     * Get witch point of tape is
     *
     * @return point of tape
     */
    public static int getPointer() {
        return pointer;
    }

    /**
     * Set point of tape
     *
     * @param pointer point of tape
     */
    public static void setPointer(int pointer) {
        Tape.pointer = pointer;
    }

    /**
     * Get current value by index tape of complete input
     *
     * @return some value of tape
     */
    public static String getCurrentInputValue() {
        return String.valueOf(Tape.completeInput.charAt(Tape.pointer));
    }

    /**
     * Get next value by index tape of complete input
     *
     * @return some value of tape
     */
    public static String getNextInputValue() throws InvalidEndPointException {
        if (Tape.pointer++ >= Tape.completeInput.length() - 1) {
            throw new InvalidEndPointException(); //unexpected end of file
        }
        return String.valueOf(Tape.completeInput.charAt(Tape.pointer));
    }
}

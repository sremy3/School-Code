/**
 * This class handles an unsupported unit exception.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class UnsupportedUnitException extends RuntimeException {
    /**
     * Constructor for unsupportedUnitException. Creates a message for the user.
     *
     * @param String msg. The message of why there's an exception.
     */
    public UnsupportedUnitException(String msg) {
        super(msg);
    }
}

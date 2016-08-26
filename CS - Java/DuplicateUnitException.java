/**
 * This class handles an duplicate unit exception.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class DuplicateUnitException extends RuntimeException {
    /**
     * Constructor for DuplicateUnitException. Creates a message for the user.
     *
     * @param String msg. The message of why there's an exception.
     */
    public DuplicateUnitException(String msg) {
    super(msg);
    }
}

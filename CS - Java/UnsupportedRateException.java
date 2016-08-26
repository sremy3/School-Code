/**
 * This class handles an unsupported rate exception.
 *
 *
 * @author Stephanie Remy
 * @version 1.0
 */
public class UnsupportedRateException extends RuntimeException {
    /**
     * Constructor for UnsupportedRateException. Creates a message for the user.
     *
     * @param String msg. The message of why there's an exception.
    */
    public UnsupportedRateException(String msg) {
        super(msg);
    }
}

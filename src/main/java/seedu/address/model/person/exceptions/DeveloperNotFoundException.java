package seedu.address.model.person.exceptions;

/**
 * Signals that the operation is unable to find the specified person.
 */
public class DeveloperNotFoundException extends RuntimeException {
    public DeveloperNotFoundException() {
        super("Unable to find developer in operation");
    }
}

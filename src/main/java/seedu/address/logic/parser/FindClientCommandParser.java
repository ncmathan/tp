package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindClientCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.client.DocumentContainsKeywordsPredicate;
import seedu.address.model.client.OrganisationContainsKeywordsPredicate;
import seedu.address.model.person.AddressContainsKeywordsPredicate;
import seedu.address.model.person.EmailContainsKeywordsPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;
import seedu.address.model.person.ProjectContainsKeywordsPredicate;
import seedu.address.model.person.RoleContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindClientCommand object
 */
public class FindClientCommandParser implements Parser<FindClientCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindClientCommand
     * and returns a FindClientCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindClientCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindClientCommand.MESSAGE_USAGE));
        }

        if (trimmedArgs.startsWith("n/")) {
            String[] nameKeywords = trimmedArgs.replaceFirst("n/", "").split("\\s+");
            return new FindClientCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
        } else if (trimmedArgs.startsWith("r/")) {
            String[] roleKeywords = trimmedArgs.replaceFirst("r/", "").split("\\s+");
            return new FindClientCommand(new RoleContainsKeywordsPredicate(Arrays.asList(roleKeywords)));
        } else if (trimmedArgs.startsWith("a/")) {
            String[] addressKeywords = trimmedArgs.replaceFirst("a/", "").split("\\s+");
            return new FindClientCommand(new AddressContainsKeywordsPredicate(Arrays.asList(addressKeywords)));
        } else if (trimmedArgs.startsWith("e/")) {
            String[] emailKeywords = trimmedArgs.replaceFirst("e/", "").split("\\s+");
            return new FindClientCommand(new EmailContainsKeywordsPredicate(Arrays.asList(emailKeywords)));
        } else if (trimmedArgs.startsWith("ph/")) {
            String[] phoneKeywords = trimmedArgs.replaceFirst("ph/", "").split("\\s+");
            return new FindClientCommand(new PhoneContainsKeywordsPredicate(Arrays.asList(phoneKeywords)));
        } else if (trimmedArgs.startsWith("pr/")) {
            String[] projectKeywords = trimmedArgs.replaceFirst("pr/", "").split("\\s+");
            return new FindClientCommand(new ProjectContainsKeywordsPredicate(Arrays.asList(projectKeywords)));
        } else if (trimmedArgs.startsWith("d/")) {
            String[] nameKeywords = trimmedArgs.replaceFirst("d/", "").split("\\s+");
            return new FindClientCommand(new DocumentContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
        } else if (trimmedArgs.startsWith("o/")) {
            String[] phoneKeywords = trimmedArgs.replaceFirst("o/", "").split("\\s+");
            return new FindClientCommand(new OrganisationContainsKeywordsPredicate(Arrays.asList(phoneKeywords)));
        } else {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindClientCommand.MESSAGE_USAGE));
        }
    }
}